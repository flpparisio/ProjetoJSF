package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe SingleConnection
 * Responsável Por Fazer a Conexão com o BD
 * @author Filipe Pereira Lara
 */
public class SingleConnection {
	private static String url = "jdbc:postgresql://localhost:5432/posjava?autoReconnect=true";
	private static String usuario = "postgres";
	private static String senha = "teste";
	private static Connection connection = null;
	
	/*
	 * Chamada Estática do Método conectar()
	 */
	static {
		conectar();
	}
	
	/*
	 * Construtor da Classe SingleConnection()
	 * Chama o Método conectar()
	 */
	public SingleConnection() {
		conectar();
	}
	
	/*
	 * Método conectar()
	 * Provê os Meios de Conexão ao BD
	 */
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, usuario, senha);
				connection.setAutoCommit(false);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Conectar com o Banco de Dados");
		}
	}
	
	/*
	 * Método getConnection()
	 * Responsável Por Fazer Uso da Conexão na Aplicação
	 */
	public static Connection getConnection() {
		return connection;
	}
}
