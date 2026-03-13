/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tienda.repository.CategoriaRepository;


@Service
public class CategoriaService {
    //se usa para crear automaticamente una unica instacia de esta clase
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    // se usa para indicar que se hara una transaccion a una bd... de solo lectura
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos){
        //se usa "activos" si se 
        var lista=categoriaRepository.findAll();
        
        if (activos) {// si solo se quieren los registros de categorias activas 
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
        
    }
    
    @Transactional
    public void save(Categoria categoria){
       categoriaRepository.save(categoria);
        }
    
           
    
    
}
