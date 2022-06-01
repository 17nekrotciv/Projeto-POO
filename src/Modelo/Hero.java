package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class Hero extends Elemento implements Serializable{
    protected static int vidas;
    private static Hero h = null;
    private Hero(String[] sNomeImagePNG) {
        super(sNomeImagePNG);
        this.vidas = 6;
    }
    
    private Hero(){
    }
    
    public static Hero instance(){
        if(h == null){
            h = new Hero();
            Hero.vidas = 6;
        }
        return h;
    }
    
    
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    @Override
    public String getTipo() {
        return "heroi";
    }
    
    public PokeballJoga joga(){
        PokeballJoga p = new PokeballJoga("pokeball.png");
        switch(this.ultimoMov){
            case "cima":
                p.setPosicao((this.getPosicao().getLinha() - 1), this.getPosicao().getColuna());
                p.setDirecao("cima");
                Desenhador.getTelaDoJogo().addElemento(p);
                break;
            case "baixo":
                p.setPosicao((this.getPosicao().getLinha() + 1),this.getPosicao().getColuna());
                p.setDirecao("baixo");
                Desenhador.getTelaDoJogo().addElemento(p);
                break;
            case "direita":
                p.setPosicao(this.getPosicao().getLinha(),(this.getPosicao().getColuna() + 1));
                p.setDirecao("direita");
                Desenhador.getTelaDoJogo().addElemento(p);
                break;
            case "esquerda":
                p.setPosicao(this.getPosicao().getLinha(),(this.getPosicao().getColuna() - 1));
                p.setDirecao("esquerda");
                Desenhador.getTelaDoJogo().addElemento(p);
                break;
        }
        return p;
    }
    
    @Override
    public void autoDesenho(){
        if("cima".equals(this.ultimoMov)){
            this.setCurImage(1);
            
        }
        if("baixo".equals(this.ultimoMov)){
            this.setCurImage(0);
            
        }
        if("direita".equals(this.ultimoMov)){
            this.setCurImage(2);
            
        }
        if("esquerda".equals(this.ultimoMov)){
            this.setCurImage(3);
            
        }
        super.autoDesenho();
    }
    
    public boolean moveUp(){
        this.setUltimoMov("cima");
        return this.pPosicao.moveUp();
    }
    
    public boolean moveDown(){
        this.setUltimoMov("baixo");
        return this.pPosicao.moveDown();
    }
    
    public boolean moveRight(){
        this.setUltimoMov("direita");
        return this.pPosicao.moveRight();
    }
    
    public boolean moveLeft(){
        this.setUltimoMov("esquerda");
        return this.pPosicao.moveLeft();
    } 

    public int getVidas() {
        return vidas;
    }
    
    
    
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    
}
