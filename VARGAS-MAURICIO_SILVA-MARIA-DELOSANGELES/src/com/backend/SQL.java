package com.backend;

import java.sql.Connection;
import java.sql.Statement;

public class SQL {
    public static final String CREATE = "DROP TABLE IF EXISTS CLINICA; CREATE TABLE CLINICA(NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, NUMERO_MATRICULA INT NOT NULL)";

    public static final String INSERT = "INSERT INTO CLINICA (NOMBRE, APELLIDO, NUMERO_MATRICULA) VALUES(?, ?, ?)";

    public static final String UPDATE = "UPDATE CLINICA SET NOMBRE = ? WHERE MATRICULA = ?";

    public static final String SELECT = "SELECT * FROM CLINICA";


}