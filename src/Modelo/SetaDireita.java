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
public class SetaDireita extends Elemento implements Serializable{
    public SetaDireita(Posicao umaPosicao){
        super("seta_direita.png");
        this.tipoSeta = "direita";
        this.setPosicao(umaPosicao);
        bTransponivel = true;
        bSeta = true;
    }

    @Override
    public String getTipo() {
        return null;
    }
}
