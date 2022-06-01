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
public class SetaEsquerda extends Elemento{
    public SetaEsquerda(Posicao umaPosicao){
        super("seta_esquerda.png");
        this.tipoSeta = "esquerda";
        this.setPosicao(umaPosicao);
        bTransponivel = true;
        bSeta = true;
    }

    @Override
    public String getTipo() {
        return null;
    }
}
