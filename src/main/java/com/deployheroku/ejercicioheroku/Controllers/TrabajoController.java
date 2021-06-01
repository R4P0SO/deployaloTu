package com.deployheroku.ejercicioheroku.Controller;
import java.util.Map;

import com.TrabajoEntornos.trabajoEntornos.models.TrabajoEntornosModel;
import com.TrabajoEntornos.trabajoEntornos.services.ContarVocales_y_Consonantes;
import com.TrabajoEntornos.trabajoEntornos.services.TrabajoEntornosBDservice;
import com.TrabajoEntornos.trabajoEntornos.services.TransformarFrase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* 
http://localhost:8080
*/

@RestController
public class TrabajoController {

    @Autowired
    ContarVocales_y_Consonantes contar;

    @GetMapping("/")
    public String explicacion() {
        return "Bienvenido a la app de Max" + 
        "<br>"+ 
        "<br>"+
        
        "Estas son todas las funciones que puedes realizar:" +
        "<br>"+ 
        "<br>"+

        "- Para contar las vocales y consonantes de una palabra, escribe: /contar/{palabra}" +
        
        "<br>"+ 
        "<br>"+

        "- Para guardar datos en la base de datos, escribe: '/insercionDatos'" + 
        
        "<br>"+
        "<br>"+
        
        "- Para listar los datos de la base, escribe: '/listarDatos'" +
        "<br>"+
        "<br>"+

        "- Para mostrar una frase al reves, escribe: /fraseAlReves/{texto} ";
    }


    @GetMapping("/contar/{palabra}")
    public String contarVocalesYConsonantes(@PathVariable String palabra) {
        String resultado = ContarVocales_y_Consonantes.contarConsonantes(palabra);
        return resultado;
    }

    @GetMapping("/contar1")
    public String contar1() {
        return "hola";
    }

    @Autowired
    TrabajoEntornosBDservice trabajoBDservice;

    @PostMapping("/insertaDatos")
    public String insertaDatos(@RequestParam Map<String, String> body) {
        System.out.println(body.get("dato"));
        TrabajoEntornosModel entornosModel = new TrabajoEntornosModel();
        entornosModel.setDato(body.get("dato"));
        trabajoBDservice.guardarDatos(entornosModel);
        return "Dato guardado correctamente.";

    }

    @GetMapping("/listarDatos")
    public String listarDatos() {
        return trabajoBDservice.devuelveDatos().toString();
    }


    
    @GetMapping("/fraseAlReves/{texto}")
    public String fraseAlreves(@PathVariable String texto){
        String fraseAlreves = TransformarFrase.fraseAlreves(texto);
        return "- La frase original es: " + texto + 
        
        "<br>"+ 
        "<br>"+

        "- La frase al revés es: " + fraseAlreves;
    }
}
