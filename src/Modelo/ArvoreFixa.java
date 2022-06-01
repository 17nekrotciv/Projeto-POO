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
 * @author victor
 */
public class ArvoreFixa extends Elemento implements Serializable{
    public ArvoreFixa(Posicao umaPosicao){
        super("arvore.png");
        this.setPosicao(umaPosicao);
        bTransponivel = false;
        bMovel = false;
    }
    @Override
    public String getTipo() {
        return "arvore";
    }
}
