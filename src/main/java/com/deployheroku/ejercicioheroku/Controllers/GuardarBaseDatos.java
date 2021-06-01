package com.deployheroku.ejercicioheroku.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuardarBaseDatos {
    
    @RequestMapping("/insercionDatos")
    public String insercionDatos(){
        return "insercionDatos";
    }
}
