package com.backend.DAO;

import com.backend.SQL;

import java.sql.*;

public class H2Connection{

    private static final String CREATE = SQL.CREATE;

    public static void crearTabla() {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement st = connection.createStatement();
            st.execute(CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/pruebaBackend2", "sa", "sa");
    }

}
