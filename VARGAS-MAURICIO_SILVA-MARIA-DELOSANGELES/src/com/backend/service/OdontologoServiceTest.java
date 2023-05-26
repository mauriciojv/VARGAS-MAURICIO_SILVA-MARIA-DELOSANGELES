package com.backend.service;

import com.backend.DAO.impl.OdontologoDaoH2;
import com.backend.entity.Odontologo;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class OdontologoServiceTest {
    private static Connection connection = null;
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void deberiaGuardarOdontologo() {
        Odontologo odoTest = new Odontologo("Mauricio", "vargas", 55555);
        Odontologo odoResult = odontologoService.guardarOdontologo(odoTest);

        assertNotNull(odoResult);
        assertEquals("Mauricio",odoResult.getNombre());
    }


    @Test
    public void deberiaListarOdontologos() {
        Odontologo OdontologoTest = new Odontologo("ana", "rodriguez", 5415742);
        List<Odontologo> odontoTest = odontologoService.listarOdontologos();
        assertTrue(odontoTest.size()>=3);
    }
}