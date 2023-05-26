package com.backend.DAO;

import com.backend.entity.Odontologo;

import java.util.List;

public interface IDao <T> {
    public T guardar (T t);
    public List<T> listarTodos();
}
