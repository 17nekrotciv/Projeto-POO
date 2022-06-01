/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Desenhador;
import java.io.Serializable;

/**
 *
 * @author Victo
 */
public class PokeballJoga extends Elemento implements Serializable {
    private String direcao;
    public PokeballJoga(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bTransponivel = false;
        bColecionavel = true;
    }
    
    public PokeballJoga retorna(){
        return this;
    }
    
    public void autoDesenho(){
        super.autoDesenho();
        switch(this.direcao){
            case "cima":
                if(!moveUp()){
                    Desenhador.getTelaDoJogo().removeElemento(this);
                }
                break;
            case "baixo":
                if(!moveDown()){
                    Desenhador.getTelaDoJogo().removeElemento(this);
                }
                break;
            case "direita":
                if(!moveRight()){
                    Desenhador.getTelaDoJogo().removeElemento(this);
                }
                break;
               
            case "esquerda":
                if(!moveLeft()){
                    Desenhador.getTelaDoJogo().removeElemento(this);
                }
                break;
        }
        
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }
     
    
    
     @Override
    public String getTipo() {
        return "pokeball";
    }
}
