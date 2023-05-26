package com.backend.DAO.impl;

import com.backend.DAO.H2Connection;
import com.backend.DAO.IDao;
import com.backend.SQL;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.backend.DAO.H2Connection.getConnection;

public class OdontologoDaoH2 implements IDao<Odontologo> {


    private static  final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);



    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement(SQL.INSERT);
            ps.setString(1,odontologo.getNombre());
            ps.setString(2, odontologo.getApellido());
            ps.setInt(3,odontologo.getMatricula());
            ps.execute();

            connection.commit();
            LOGGER.info("Se ha registrado al nuevo miembro: " + odontologo);


        }catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if(connection != null){
                try {
                    connection.rollback();
                    LOGGER.error("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception){
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la base de datos. " + e.getMessage());
                e.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection =  null;
        List<Odontologo> odontologos= new ArrayList<>();

        try{
            connection = H2Connection.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL.SELECT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Odontologo odontologo = crearObjetoOdontologo(rs);
                odontologos.add(odontologo);
            }

            LOGGER.info("Listado de todos los odontologos :" + odontologos);

        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la base de datos. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologos;
    }


    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {
        String nombreOdontologo = resultSet.getString("nombre");
        String apellidoOdontologo = resultSet.getString("apellido");
        int matriculaOdontologo = resultSet.getInt(3);
        return new Odontologo( nombreOdontologo, apellidoOdontologo, matriculaOdontologo);
    }
}
