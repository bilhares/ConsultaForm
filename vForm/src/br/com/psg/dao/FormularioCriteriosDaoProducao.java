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
import br.com.psg.model.Lote;
import br.com.psg.model.TipoDocumento;

public class FormularioCriteriosDaoProducao {

	private Connection connectionProd;
	private LoteDao loteDao;
	private AgenfaDao agenfaDao;
	private List<Formulario> listaFormularios;
	private PreparedStatement stmt;
	private ResultSet rs;

	public FormularioCriteriosDaoProducao() {
		this.connectionProd = new ConnectionFactory().getConnectionProducao();
		this.loteDao = new LoteDao();
		this.agenfaDao = new AgenfaDao();
	}

	public List<Formulario> buscaIntervaloGraficoData(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal) throws SQLException {

		String sql = "select * from Formularios where " + "NumGrafico between ? and ? and Data between ? and ?";
		listaFormularios = new ArrayList<>();

		try {
			this.stmt = this.connectionProd.prepareStatement(sql);
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

				// Lote
				Lote lote = this.loteDao.obterDadosLote(rs.getString("ID_Exportacao"));

				// Agenfa
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
			System.out.println("Erro ao buscar por intervalo grafico com data em produção: " + e);
		} finally {
			this.rs.close();
			this.stmt.close();
			this.connectionProd.close();
		}
		return null;
	}
}
