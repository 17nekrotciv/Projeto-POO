/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Posicao;
import java.io.Serializable;

/**
 *
 * @author Victo
 */
public class PedraMoveQuebra extends Elemento implements Serializable{
    public PedraMoveQuebra(Posicao umaPosicao){
        super("pedra2.png");
        this.setPosicao(umaPosicao);
        bTransponivel = false;
        bMovel = true;
        bQuebra = true;
    }
    @Override
    public String getTipo() {
        return "pedra";
    }
}
