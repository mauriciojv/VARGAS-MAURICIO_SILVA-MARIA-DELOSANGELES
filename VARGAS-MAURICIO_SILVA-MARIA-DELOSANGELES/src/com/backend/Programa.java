package com.backend;

import com.backend.DAO.H2Connection;
import com.backend.DAO.impl.OdontologoDaoEnMemoria;
import com.backend.DAO.impl.OdontologoDaoH2;
import com.backend.entity.Odontologo;
import com.backend.service.OdontologoService;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class Programa {

    private static final Logger LOGGER = Logger.getLogger(Programa.class);

    public static void main(String[] args) {
        Connection connection = null;
        H2Connection.crearTabla();

        Odontologo odontologo1 = new Odontologo("Javier", "Duque", 304504);
        Odontologo odontologo2 = new Odontologo("Ana", "Perez",3045505);
        Odontologo odontologo3 = new Odontologo("Maria", "Silva",30544478);

        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        System.out.println("Odontologos en BDD");

        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.guardarOdontologo(odontologo3);

        System.out.println("-----------------------------------------------");
        odontologoService.listarOdontologos();

        System.out.println("////////////////////////////////////////////////");
        OdontologoService odontologoService1 = new OdontologoService((new OdontologoDaoEnMemoria(new ArrayList<>())));

        odontologo1.setNombre(odontologo1.getNombre());
        odontologo2.setNombre(odontologo2.getNombre());
        odontologo3.setNombre(odontologo3.getNombre());

        odontologo1.setApellido(odontologo1.getApellido());
        odontologo2.setApellido(odontologo2.getApellido());
        odontologo3.setApellido(odontologo3.getApellido());

        odontologo1.setMatricula(odontologo1.getMatricula());
        odontologo2.setMatricula(odontologo2.getMatricula());
        odontologo3.setMatricula(odontologo3.getMatricula());

        odontologoService1.guardarOdontologo(odontologo1);
        odontologoService1.guardarOdontologo(odontologo2);
        odontologoService1.guardarOdontologo(odontologo3);

        System.out.println("-----------------------------------------------");

        odontologoService1.listarOdontologos();


        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/pruebaBackend2", "sa", "sa");
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
}