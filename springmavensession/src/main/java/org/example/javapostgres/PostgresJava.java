package org.example.javapostgres;

import java.sql.*;

public class PostgresJava {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?autoReconnect=true&useSSL=false", "shaileshbhattarai", "password");
        Statement stmt = con.createStatement();
        System.out.println("connection established");
        ResultSet rst = stmt.executeQuery("select * from public.\"Mentor\"");

        while(rst.next()) {
            System.out.println(rst.getString(1) + " ");
        }

        // creating a connection using singleton class
    }
}
