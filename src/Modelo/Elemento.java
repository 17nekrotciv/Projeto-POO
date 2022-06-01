package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Controler.Tela;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Junio
 */
public abstract class Elemento implements Serializable {

    protected ImageIcon iImage[];
    protected int curImage;
    protected Posicao pPosicao;
    protected String ultimoMov;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bCaptura;       /*Se encostar, morre?*/
    protected boolean bMovel;
    protected boolean bColecionavel;
    protected boolean bSeta;
    protected boolean bPokemon;
    protected boolean bVoador;
    protected String tipoSeta;
    protected boolean bQuebra;
       
    protected Elemento(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bCaptura = false;
        this.ultimoMov = null;
        this.bMovel= false;
        this.bPokemon = false;
        this.bVoador = false;
        this.curImage = 0;
        this.bColecionavel = false;
        this.bSeta = false;
        this.tipoSeta = null;
        this.bQuebra = false;
        iImage = new ImageIcon[4];
        try {
            iImage[0] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage[0].getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage[0] = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    protected Elemento(String[] sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bCaptura = false;
        this.ultimoMov = null;
        this.bMovel= false;
        this.bPokemon = false;
        this.bVoador = false;
        this.curImage = 0;
        this.bSeta = false;
        this.tipoSeta = null;
        this.bQuebra = false;
        iImage = new ImageIcon[4];
        try {
            for(int i=0; i<sNomeImagePNG.length; i++){
                iImage[i] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG[i]);
                Image img = iImage[i].getImage();
                BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                iImage[i] = new ImageIcon(bi);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    protected Elemento(){
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bCaptura = false;
        this.ultimoMov = null;
        this.bMovel= false;
        this.bPokemon = false;
        this.bVoador = false;
        this.curImage = 0;
        this.bSeta = false;
        this.tipoSeta = null;
        this.bQuebra = false;
        iImage = new ImageIcon[4];
        String[] imgH = new String[4];
        imgH[0] = ("hero_baixo.png");
        imgH[1] = ("hero_cima.png");
        imgH[2] = ("hero_dir.png");
        imgH[3] = ("hero_esq.png");
        try {
            for(int i=0; i<imgH.length; i++){
                iImage[i] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imgH[i]);
                Image img = iImage[i].getImage();
                BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                iImage[i] = new ImageIcon(bi);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean isbVoador() {
        return bVoador;
    }

    public void setbVoador(boolean bVoador) {
        this.bVoador = bVoador;
    }

    public void setbMortal(boolean bMortal) {
        this.bCaptura = bMortal;
    }
    
    
    public boolean quebra(){
        return this.bQuebra;
    }
    
    public boolean ehPokemon(){
        return this.bPokemon;
    }
    
    public String getTipoSeta() {
        return tipoSeta;
    }
    
    public boolean isSeta(){
        return this.bSeta;
    }
    
    public boolean ehColecionavel(){
        return this.bColecionavel;
    }
    
    public boolean ehMovel(){
        return this.bMovel;
    }
    
    public abstract String getTipo();
    
    public String getUltimoMov() {
        return ultimoMov;
    }
    
    public Posicao getPosicao() {
        return pPosicao;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public void setUltimoMov(String ultimoMov) {
        this.ultimoMov = ultimoMov;
    }
    
    
    
    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean setPosicao(Posicao umaPosicao) {
        return pPosicao.copia(umaPosicao);
    }
    
    public boolean moveUp() {
        boolean statusMovimento = this.pPosicao.moveUp();
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaAUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        this.ultimoMov = "cima";
        return statusMovimento;
    }

    public boolean moveDown() {
        boolean statusMovimento = this.pPosicao.moveDown();
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaAUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        this.ultimoMov = "baixo";
        return statusMovimento;
    }

    public boolean moveRight() {
        boolean statusMovimento = this.pPosicao.moveRight();
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaAUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        this.ultimoMov = "direita";
        return statusMovimento;
    }

    public boolean moveLeft() {
        boolean statusMovimento = this.pPosicao.moveLeft();
        if(!Desenhador.getTelaDoJogo().ehPosicaoValidaRelativaAUmPersonagem(this)){
            this.getPosicao().volta();
            return false;
        }
        this.ultimoMov = "esquerda";
        return statusMovimento;
    }

    public void setCurImage(int curImage) {
        this.curImage = curImage;
    }
    
   public void autoDesenho(){
        Desenhador.desenhar(this.iImage[curImage], pPosicao.getColuna(), pPosicao.getLinha());        
    }    
}
