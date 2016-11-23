package br.com.psg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.factory.ConnectionFactory;
import br.com.psg.model.Agenfa;
import br.com.psg.model.Filme;
import br.com.psg.model.Formulario;
import br.com.psg.model.Lote;
import br.com.psg.model.TipoDocumento;

public class FormularioDaoProducao {
	private Connection connectionProd;
	LoteDao loteDao;
	AgenfaDao agenfaDao;
	List<Formulario> listaFormularios;
	
	public FormularioDaoProducao() {
		this.connectionProd = new ConnectionFactory().getConnectionProducao();
		this.loteDao = new LoteDao();
		this.agenfaDao = new AgenfaDao();
	}
	
	public List<Formulario> buscaPorGrafico(String grafico) {

		String sql = "select top 5 * from Formularios where NumGrafico = ?";
		listaFormularios = new ArrayList<>();
		try {

			PreparedStatement stmt = this.connectionProd.prepareStatement(sql);
			stmt.setString(1, grafico);

			
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
				
				//Lote
				Lote lote = this.loteDao.obterDadosLote(rs.getString("ID_Exportacao"));
				
				//Agenfa
				Agenfa agenfa = this.agenfaDao.obterDadosAgenfa(rs.getInt("NumAgenfa"));
				
				// Montagem Formulario
				Formulario form = new Formulario();

				form.setGrafico(rs.getString("NumGrafico"));
				form.setSituacao(form.obterSituacao(rs.getInt("TipoFormulario")));
				form.setSemTransmissao(form.obterTransmissao(rs.getInt("cancelarFisico")));
				form.setCodTipo(tipoDoc.getTipo());
				form.setTipoDocumento(descricaoTipo);
				form.setnLogico(rs.getString("NumLogico"));
				form.setNumAgenfa(rs.getString("NumAgenfa"));
				form.setDescricaoAgenfa(agenfa.getDescricao());
				form.setData(rs.getString("Data"));
				form.setFilme(filme.getNumFilme());
				form.setFotograma(rs.getInt("Fotograma"));
				form.setSituacaoFilme(sitFilme);
				form.setObs(rs.getString("Obs"));
				form.setNumLote(rs.getString("ID_Exportacao"));
				form.setTipoLote(lote.obterTipoLote(lote.getTipo()));
				form.setSituacaoLote(lote.obterSitLote(lote.getSituacao()));
				form.setPosicao(form.obterPosicao(rs.getInt("Posicao")));
				form.setMensagem(rs.getString("Mensagem"));

				listaFormularios.add(form);
			}
			System.out.println("Formulario adicionado!");
			
			rs.close();
			stmt.close();
			return listaFormularios;
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar por grafico: " + e);
		}
		return null;
	}
	
	public List<Formulario> buscarIntervaloGrafico(String graficoInicial, String graficoFinal){
		String sql = "select top 5 * from Formularios where NumGrafico between ? and ?";
		listaFormularios = new ArrayList<>();
		
		try {

			PreparedStatement stmt = this.connectionProd.prepareStatement(sql);
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
				
				//Lote
				Lote lote = this.loteDao.obterDadosLote(rs.getString("ID_Exportacao"));
				
				//Agenfa
				Agenfa agenfa = this.agenfaDao.obterDadosAgenfa(rs.getInt("NumAgenfa"));
				
				// Montagem Formulario
				Formulario form = new Formulario();

				form.setGrafico(rs.getString("NumGrafico"));
				form.setSituacao(form.obterSituacao(rs.getInt("TipoFormulario")));
				form.setSemTransmissao(form.obterTransmissao(rs.getInt("cancelarFisico")));
				form.setCodTipo(tipoDoc.getTipo());
				form.setTipoDocumento(descricaoTipo);
				form.setnLogico(rs.getString("NumLogico"));
				form.setNumAgenfa(rs.getString("NumAgenfa"));
				form.setDescricaoAgenfa(agenfa.getDescricao());
				form.setData(rs.getString("Data"));
				form.setFilme(filme.getNumFilme());
				form.setFotograma(rs.getInt("Fotograma"));
				form.setSituacaoFilme(sitFilme);
				form.setObs(rs.getString("Obs"));
				form.setNumLote(rs.getString("ID_Exportacao"));
				form.setTipoLote(lote.obterTipoLote(lote.getTipo()));
				form.setSituacaoLote(lote.obterSitLote(lote.getSituacao()));
				form.setPosicao(form.obterPosicao(rs.getInt("Posicao")));
				form.setMensagem(rs.getString("Mensagem"));

				listaFormularios.add(form);
			}
			System.out.println("Formulario adicionado!");
			
			
			return listaFormularios;
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar por intervalo grafico: " + e);
		}
		return null;		
	}
	
	public static void main(String[] args) {
		FormularioDaoProducao dao = new FormularioDaoProducao();
		List<Formulario> f = dao.buscarIntervaloGrafico("B356007", "B356007");
		
		for(Formulario lf : f){
			System.out.println(lf.getnLogico());
		}
	}
}
