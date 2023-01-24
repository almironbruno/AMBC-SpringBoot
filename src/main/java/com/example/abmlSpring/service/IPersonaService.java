/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.abmlSpring.service;

import com.example.abmlSpring.model.Persona;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface IPersonaService {
    
    public List<Persona> getpersonas();
    
    public void savePersona(Persona perso);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
