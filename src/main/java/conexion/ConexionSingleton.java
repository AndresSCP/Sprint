package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// clase llamada ConexionSingleton que implementa el patrón Singleton se encarga de crear y mantener una única instancia de la conexión a la base de datos.

public class ConexionSingleton {
	
	// variables y constantes son utilizadas para establecer una conexión a la base de datos MySQL a través del patrón de diseño Singleton en la clase ConexionSingleton
    private static ConexionSingleton instance = new ConexionSingleton(); //"Patron Singleton", que garantiza que sólo haya una única instancia de la clase en todo el programa.
    private static final String URL = "jdbc:mysql://localhost:3306/m5_abpro_5";//constante que almacena la dirección URL de la base de datos que se desea conectar.
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";//constante que especifica el controlador JDBC que se utilizará para la conexión a la base de datos
    private static final String USER = "root"; //usuario de la base de datos
    private static final String PASSWORD = "12345"; // Clave de la Base de datos.

    private Connection connection;

    
    
    private ConexionSingleton() {
        try {
            Class.forName(DRIVER); //carga el driver de MySQL mediante el método Class.forName(DRIVER)
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);//Luego, se establece la conexión con la base de datos a través del método DriverManager.getConnection(URL, USER, PASSWORD)
        } catch (ClassNotFoundException | SQLException e) { //si se produce una excepción el programa saltará al bloque catch.
            throw new RuntimeException("Error al conectar a la base de datos.", e);
        }
    }

    public static Connection conectar() {
        try {
            if (instance.connection == null || instance.connection.isClosed()) {
                // Si la conexión está cerrada o nunca se ha creado, crear una nueva conexión
                Class.forName(DRIVER);
                instance.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos.", e);
        }
        return instance.connection;
    }

    public static void cerrar() {
        if (instance != null && instance.connection != null) {
            try {
                instance.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


