package com.lin.zip.db;

import java.sql.*;

public class JDBCSQLServerConnection {


    private static Connection _con;


    /**
     * Open a new connection
     *
     * @return connection instance that has been opened
     */
    public static Connection getConnection() {
        if (_con == null) {
            String dbURL = "jdbc:sqlserver://xxxxxxxxxxxxxx:1433;database=xxxxxxxxxxx";
            String user = "xxxxxxxxx";
            String pass = "xxxxxxxxx";


            try {
                _con = DriverManager.getConnection(dbURL, user, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return _con;
    }

    /**
     * Close the connection
     *
     * @param con connection to be operated
     */
    public static void closeAll(ResultSet rs, Statement st, Connection con) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (st != null && !st.isClosed()) {
                st.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
