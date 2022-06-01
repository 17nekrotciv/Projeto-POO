/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Desenhador;

/**
 *
 * @author Victo
 */
public class PokemonVoador extends PokemonDecorator{

    public PokemonVoador(Pokemon pokemon) {
        super(pokemon, pokemon.getImgName());
        pokemon.setbVoador(true);
    }
    
    public boolean moveUp() {
        boolean statusMovimento = this.pPosicao.moveUp();
        
        this.ultimoMov = "cima";
        return statusMovimento;
    }

    @Override
    public boolean moveDown() {
        boolean statusMovimento = this.pPosicao.moveDown();
        
        this.ultimoMov = "baixo";
        return statusMovimento;
    }

    @Override
    public boolean moveRight() {
        boolean statusMovimento = this.pPosicao.moveRight();
        
        this.ultimoMov = "direita";
        return statusMovimento;
    }

    @Override
    public boolean moveLeft() {
        boolean statusMovimento = this.pPosicao.moveLeft();
        
        this.ultimoMov = "esquerda";
        return statusMovimento;
    }
}
