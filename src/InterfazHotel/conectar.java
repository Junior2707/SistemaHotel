package InterfazHotel;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class conectar {
		Connection con;
	    String user = "root";
	    String password = "";
	    String url = "jdbc:mysql://localhost:3306/evalti";
	    Connection connection = null;
	    
    public Connection Conectar(){
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection(url,user,password);
        if (connection!=null){
            System.out.println("Conexión a base de datos");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public Connection getConnection(){
        return connection;
    }
   
    public void desconectar(){
        try{
            System.out.println("Cerrando conexion");
            connection.close();
        }catch(Exception ex){}
    }

	void fecha() {
	        Calendar calendar = new GregorianCalendar();
	        //txtFecha.setText("" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
	    }
}
