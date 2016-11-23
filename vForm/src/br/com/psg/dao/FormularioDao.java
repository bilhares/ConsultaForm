package br.com.psg.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.factory.ConnectionFactory;
import br.com.psg.model.Agenfa;
import br.com.psg.model.Filme;
import br.com.psg.model.Formulario;
import br.com.psg.model.TipoDocumento;

public class FormularioDao {
	private Connection connection;
	private AgenfaDao agenfaDao;
	private List<Formulario> listaFormularios;

	public FormularioDao() {
		this.connection = new ConnectionFactory().getConnection();
		this.agenfaDao = new AgenfaDao();
	}

	public List<Formulario> buscaPorGrafico(String grafico, String serie) {

		String sql = "select top 5 * from Formularios where NumGrafico = ? and serie = ?";
		listaFormularios = new ArrayList<>();
		try {

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, grafico);
			stmt.setString(2, serie);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// Tipo Documento
				TipoDocumento tipoDoc = new TipoDocumento();
				tipoDoc.setTipo(rs.getInt("TipoDocumento"));
				String descricaoTipo = tipoDoc.getDescricao(tipoDoc.getTipo());

				// Filme
				Filme filme = new Filme();
				filme.setNumFilme(rs.getInt("Filme"));
				String sitFilme = filme.getSituacao(rs.getInt("TipoFilme"));

				// Agenfa
				Agenfa agenfa = agenfaDao.obterDadosAgenfa(rs.getInt("NumAgenfa"));

				// Montagem Formulario
				Formulario form = new Formulario();

				form.setGrafico(rs.getString("NumGrafico"));
				form.setSituacao(form.obterSituacao(rs.getInt("TipoFormulario")));
				form.setSemTransmissao(form.obterTransmissao(rs.getInt("semTransmissao")));
				form.setCodTipo(tipoDoc.getTipo());
				form.setTipoDocumento(descricaoTipo);
				form.setnLogico(rs.getString("NumLogico"));
				form.setNumAgenfa(rs.getString("NumAgenfa"));
				form.setDescricaoAgenfa(agenfa.getDescricao());
				form.setData(rs.getString("Data"));
				form.setFilme(filme.getNumFilme());
				form.setFotograma(rs.getInt("Fotograma"));
				form.setSituacaoFilme(sitFilme);
				// form.setObs("OBS");
				/*
				 * form.setNumLote("000001"); form.setTipoLote("NORMAL");
				 * form.setSituacaoLote("A CONFERIR");
				 * form.setPosicao("posicao"); form.setMensagem("MSG");
				 */

				listaFormularios.add(form);
			}
			System.out.println("Formulario adicionado!");

			rs.close();
			stmt.close();
			return listaFormularios;

		} catch (Exception e) {
			System.out.println("Erro ao adicionar: " + e);
		}
		return null;
	}

	public List<Formulario> buscaIntervaloGrafico(String graficoInicial, String graficoFinal) {
		String sql = "select top 5 * from Formularios where NumGrafico between ? and ?";
		listaFormularios = new ArrayList<>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, graficoInicial);
			stmt.setString(2, graficoFinal);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// Tipo Documento
				TipoDocumento tipoDoc = new TipoDocumento();
				tipoDoc.setTipo(rs.getInt("TipoDocumento"));
				String descricaoTipo = tipoDoc.getDescricao(tipoDoc.getTipo());

				// Filme
				Filme filme = new Filme();
				filme.setNumFilme(rs.getInt("Filme"));
				String sitFilme = filme.getSituacao(rs.getInt("TipoFilme"));

				// Agenfa
				Agenfa agenfa = agenfaDao.obterDadosAgenfa(rs.getInt("NumAgenfa"));

				// Montagem Formulario
				Formulario form = new Formulario();

				form.setGrafico(rs.getString("NumGrafico"));
				form.setSituacao(form.obterSituacao(rs.getInt("TipoFormulario")));
				form.setSemTransmissao(form.obterTransmissao(rs.getInt("semTransmissao")));
				form.setCodTipo(tipoDoc.getTipo());
				form.setTipoDocumento(descricaoTipo);
				form.setnLogico(rs.getString("NumLogico"));
				form.setNumAgenfa(rs.getString("NumAgenfa"));
				form.setDescricaoAgenfa(agenfa.getDescricao());
				form.setData(rs.getString("Data"));
				form.setFilme(filme.getNumFilme());
				form.setFotograma(rs.getInt("Fotograma"));
				form.setSituacaoFilme(sitFilme);
				// form.setObs("OBS");
				/*
				 * form.setNumLote("000001"); form.setTipoLote("NORMAL");
				 * form.setSituacaoLote("A CONFERIR");
				 * form.setPosicao("posicao"); form.setMensagem("MSG");
				 */

				listaFormularios.add(form);
			}
			System.out.println("Formulario adicionado!");
			
			
			rs.close();
			stmt.close();
			this.connection.close();
			
			return listaFormularios;

		} catch (Exception e) {
		   System.out.println("Erro na pesquisa de intervalo: "+e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		FormularioDao dao = new FormularioDao();
		List<Formulario> f = new ArrayList<>();
		f = dao.buscaIntervaloGrafico("816435", "5754291");
		
		for(Formulario lf:f){
			System.out.println("numLogicos:"+lf.getnLogico());
		}

	}

}
