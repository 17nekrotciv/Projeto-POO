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
public class SetaBaixo extends Elemento implements Serializable{
    public SetaBaixo(Posicao umaPosicao){
        super("seta_baixo.png");
        this.tipoSeta = "baixo";
        this.setPosicao(umaPosicao);
        bTransponivel = true;
        bSeta = true;
    }

    @Override
    public String getTipo() {
        return null;
    }
}
