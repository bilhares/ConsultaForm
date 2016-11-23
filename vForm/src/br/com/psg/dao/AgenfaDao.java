package br.com.psg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.psg.factory.ConnectionFactory;
import br.com.psg.model.Agenfa;
import br.com.psg.model.Lote;

public class AgenfaDao {
	private Connection connectionProd;

	public AgenfaDao() {
		this.connectionProd = new ConnectionFactory().getConnectionProducao();
	}
	
	public Agenfa obterDadosAgenfa(int numAgenfa){
		String sql = "select * from Agenfas where NumAgenfa = ?";
		try {
			PreparedStatement stmt = this.connectionProd.prepareStatement(sql);
			stmt.setInt(1, numAgenfa);
			ResultSet rs = stmt.executeQuery();			
			rs.next();
			Agenfa agenfa = new Agenfa();
			agenfa.setNumAgenfa(rs.getInt("NumAgenfa"));
			agenfa.setDescricao(rs.getString("NomeAgenfa"));
			return agenfa;
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar Agenfa: " + e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		AgenfaDao dao = new AgenfaDao();
		Agenfa a = dao.obterDadosAgenfa(90100000);
		
		System.out.println("Nome:"+a.getDescricao());
	}
}
