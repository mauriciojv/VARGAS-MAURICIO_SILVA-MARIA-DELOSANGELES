package com.backend.DAO.impl;

import com.backend.DAO.IDao;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    public static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologoRepository;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologoRepository){
        this.odontologoRepository = odontologoRepository;
    }
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologoRepository.add(odontologo);
        LOGGER.info("Nuevo miembro guardado : " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Listado de todos los odontologos: \n" + odontologoRepository);
        return odontologoRepository;
    }
}
