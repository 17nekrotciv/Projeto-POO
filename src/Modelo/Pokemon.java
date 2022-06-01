package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class Pokemon extends Elemento implements Serializable{
    private int vez;
    private String imgName;
    public Pokemon(String sNomeImagePNG) {
        super(sNomeImagePNG);
        imgName = sNomeImagePNG;
        this.bTransponivel = true;
        this.bPokemon = true;
        this.vez = 0;
    }
    
    public String getImgName(){
        return imgName;
    }
    
    public void autoDesenho(){
        Random r = new Random();
        int direcao = r.nextInt(4);
        if(this.bCaptura == true){
            super.autoDesenho();
            return;
        }
        if(this.vez == 1){
            this.vez = 0;
            super.autoDesenho();
            return;
        }
        if(this.vez == 0){
            switch(direcao){
                case 0:
                    this.moveUp();
                    this.vez = 1;
                    break;
                case 1:
                    this.moveDown();
                    this.vez = 1;
                    break;
                case 2:
                    this.moveLeft();
                    this.vez = 1;
                    break;
                case 3:
                    this.moveRight();
                    this.vez = 1;
                    break;
            }
        }
        
        super.autoDesenho();
    }
    @Override
    public String getTipo() {
        return "pokemon";
    }
}
