package br.com.psg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.psg.factory.ConnectionFactory;
import br.com.psg.model.Lote;

public class LoteDao {
	private Connection connectionProd;

	public LoteDao() {
		this.connectionProd = new ConnectionFactory().getConnectionProducao();
	}
	
	public Lote obterDadosLote(String idExportacao){
		String sql = "select * from Lote where ID_Exportacao = ?";
		try {
			PreparedStatement stmt = this.connectionProd.prepareStatement(sql);
			stmt.setString(1, idExportacao);
			ResultSet rs = stmt.executeQuery();			
			rs.next();
			Lote lote = new Lote();
			lote.setNumLote(rs.getInt("ID_Exportacao"));
			lote.setSituacao(rs.getInt("Conferido"));
			lote.setTipo(rs.getInt("TipoFormulario"));
			
			return lote;
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar lote: " + e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		LoteDao dao = new LoteDao();
		Lote l = dao.obterDadosLote("00014701");
		System.out.println(""+l.getNumLote());
	}
}

