package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	// METODO PARA OBTER UMA CONEXÃO
	public static Connection getConnection() {
		// Se a conexão for nula, tenta criar uma nova conexão
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

		return conn;
	}

	// METODO PARA FECHAR UMA CONEXÃO
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	// METODO PARA CARREGAR AS PROPRIEDADES DO ARQUIVO db.properties
	private static Properties loadProperties() {
		// Tenta carregar o arquivo db.properties
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();

			props.load(fs);

			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}

	}

	// METODO PARA FECHAR UM STATEMENT
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	// METODO PARA FECHAR UM RESULTSET
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

	}

}
