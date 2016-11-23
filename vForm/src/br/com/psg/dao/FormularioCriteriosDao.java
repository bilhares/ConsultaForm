package br.com.psg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.factory.ConnectionFactory;
import br.com.psg.model.Agenfa;
import br.com.psg.model.Filme;
import br.com.psg.model.Formulario;
import br.com.psg.model.TipoDocumento;

public class FormularioCriteriosDao {

	private Connection connection;
	private AgenfaDao agenfaDao;
	private List<Formulario> listaFormularios;
	private PreparedStatement stmt;
	private ResultSet rs;

	public FormularioCriteriosDao() {
		this.connection = new ConnectionFactory().getConnection();
		this.agenfaDao = new AgenfaDao();
	}

	public List<Formulario> buscaIntervaloGraficoData(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal) throws SQLException {

		String sql = "select * from Formularios where NumGrafico"+
					 " between ? and ? and Data between convert(date, ?, 103) "+
					 "and convert(date, ?, 103)";
		
		listaFormularios = new ArrayList<>();
		try {
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);

			this.rs = this.stmt.executeQuery();

			while (this.rs.next()) {

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

			return listaFormularios;
		} catch (Exception e) {
			System.out.println("Erro na busca de intervalo grafico com criterios de data: "+e);
		} finally {
			this.rs.close();
			this.stmt.close();
			this.connection.close();
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {
		FormularioCriteriosDao dao = new FormularioCriteriosDao();
		List<Formulario> f = new ArrayList<>();
		f = dao.buscaIntervaloGraficoData("2888918", "2888927", "9/07/2004", "9/07/2004");

		for(Formulario lf:f){
			System.out.println("numLogicos:"+lf.getnLogico());
		}
	}
}
