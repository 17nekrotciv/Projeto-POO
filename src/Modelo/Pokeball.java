/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Pokeball extends Elemento implements Serializable{

    public Pokeball(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bTransponivel = true;
        bColecionavel = true;
    }
    
    
    
    public void autoDesenho() {
        super.autoDesenho();
    }
    
    
    @Override
    public String getTipo() {
        return "pokeball";
    }
}
