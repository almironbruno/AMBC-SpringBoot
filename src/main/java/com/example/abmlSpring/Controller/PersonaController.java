/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.abmlSpring.Controller;

import com.example.abmlSpring.model.Persona;
import com.example.abmlSpring.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno
 */
@RestController
public class PersonaController {
    @Autowired 
    private IPersonaService interPersona;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return interPersona.getpersonas();
    }
    @PostMapping("/personas/crear")
    public String createStudent(@RequestBody Persona per) {
        interPersona.savePersona(per);
        return "La persona fue creada correctamente";
    }
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        interPersona.deletePersona(id);
        return "La persona fue borrada correctamente";
    }
    @PutMapping("/personas/editar/{id}")
    public Persona editarPersona(@PathVariable Long id ,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("edad") int nuevaEdad) {
        Persona perso = interPersona.findPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        
        interPersona.savePersona(perso);
        
        return perso;
    }
    
}
