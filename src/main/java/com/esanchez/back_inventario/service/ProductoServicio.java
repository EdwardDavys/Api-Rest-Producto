package com.esanchez.back_inventario.service;

import com.esanchez.back_inventario.modelo.Producto;
import com.esanchez.back_inventario.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public void guardarProducto(Producto producto){
        productoRepository.save(producto);
    }

    public Producto obtenerProducto(Integer id){
        return productoRepository.findById(id).get();
    }

    public void eliminarProdcuto(Integer id){
        productoRepository.deleteById(id);
    }
}
