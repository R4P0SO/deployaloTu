package com.TrabajoEntornos.trabajoEntornos.services;

import java.util.ArrayList;

import com.TrabajoEntornos.trabajoEntornos.models.TrabajoEntornosModel;
import com.TrabajoEntornos.trabajoEntornos.repositories.TrabajoEntornosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*permite conectar a la app con el exterior,
 mediante el service se lanzan las consultas usando el repository*/
@Service
public class TrabajoEntornosBDservice {

    @Autowired
    TrabajoEntornosRepository entornosRepository;

    /* recibe un objeto del tipo del modelo como parámetro y lo guarda en la base de
     * datos con 'save' */
    public TrabajoEntornosModel guardarDatos(TrabajoEntornosModel modeloDatos){
        return entornosRepository.save(modeloDatos);
    }

    /*devuelve un arrayList del tipo modelo con los datos guardados en la base de datos,
    el método 'findAll' lo provee JPA*/
    public ArrayList<TrabajoEntornosModel> devuelveDatos(){
        return (ArrayList<TrabajoEntornosModel>) entornosRepository.findAll();
    }

    
}
