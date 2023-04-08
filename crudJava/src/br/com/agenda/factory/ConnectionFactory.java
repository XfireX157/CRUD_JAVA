package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_agenda";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "252525";

    public static Connection getConnection() {
        try {
        	Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
       
    }
}
