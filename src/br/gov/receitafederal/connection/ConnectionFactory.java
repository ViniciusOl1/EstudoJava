package br.gov.receitafederal.connection;

import java.sql.*;

public class ConnectionFactory {
    public static Connection getConnection() {
        String host = "jdbc:mysql://localhost:3306/receitafederal?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";
        try{
            return DriverManager.getConnection(host, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection){
        try{
            if(connection != null)
                connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, PreparedStatement pst){
        close(connection);
        try{
            if(pst != null)
                pst.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, PreparedStatement pst, ResultSet rs){
        close(connection, pst);

        try{
            if(rs != null)
                rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
