/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;

/**
 *
 * @author Minwoo Park
 */
public class DBManager {

    String conn = "jdbc:mysql://localhost:3306/hockeyleaguedb?autoReconnect=true&useSSL=false&serverTimezone=Asia/Shanghai";
    String user = "root";
    String pass = "pass";

    public Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(conn, user, pass);
        } catch (Exception e) {
            System.out.println("error getting connection");

        }
        return con;
    }

    public int executeUpdate(String sql) {
        int update = -1;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            update = st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error execute update" + e);
        }
        return update;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Connection con = getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                rs = st.executeQuery(sql);
            }
        } catch (Exception e) {
            System.out.println("error executing query");
        }
        return rs;
    }
}
