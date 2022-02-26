package com.esanchez.back_inventario.controller;

import com.esanchez.back_inventario.modelo.Producto;
import com.esanchez.back_inventario.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> listarProdcutos(){
        return productoServicio.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
        try {
            Producto producto = productoServicio.obtenerProducto(id);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public void guardarProducto(@RequestBody Producto producto){
        productoServicio.guardarProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try {

            Producto productoActual= productoServicio.obtenerProducto(id);
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());

            productoServicio.guardarProducto(productoActual);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoServicio.eliminarProdcuto(id);
    }
}
