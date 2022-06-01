package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.*;
import Controler.Fases;
import Modelo.Pokeball;
import javax.swing.JFileChooser;

/**
 *
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;
    private Fases fase;
    private PokeballJoga p;
    private int savedFase;

    /**
     * Creates new form
     */
    public Tela() {
        Desenhador.setCenario(this);
        /*Desenhador funciona no modo estatico*/
        initComponents();

        this.addMouseListener(this);
        /*mouse*/
        this.addKeyListener(this);
        /*teclado*/

 /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Elemento>(100);

        /*Cria eElementos adiciona elementos*/
 /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        /* https://www.online-image-editor.com/ */
        this.hHero = Hero.instance();
        Hero.instance().setPosicao(3, 4);
        this.addElemento(Hero.instance());

        fase = new Fases(100);
        fase.setHero(Hero.instance());
        fase.Fase1();
        eElementos = fase;

    }

    /*--------------------------------------------------*/
    public void addElemento(Elemento umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer() {
        return g2;
    }

    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grama.png");
                    g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);

            if (this.p != null) {
                this.cControle.verificaCaptura(eElementos, p);
            }
            if (!this.cControle.haColecionaveis(eElementos)) {
                for (int i = 0; i < eElementos.size(); i++) {
                    if (i == 0) {
                        continue;
                    }
                    if (!eElementos.get(i).ehPokemon()) {
                        eElementos.remove(i);
                    } else if (eElementos.get(i).ehPokemon()) {
                        eElementos.get(i).setbMortal(true);
                    }
                }
            }
            if (!this.cControle.haColecionaveis(eElementos) && !this.cControle.haPokemon(eElementos)) {
                eElementos.clear();
                System.out.println("antes: " + this.fase.curFase);
                this.fase.proxFase();
                eElementos = fase;
                System.out.println(fase.curFase);
                Hero.instance().setPosicao(eElementos.get(0).getPosicao());
                fase.setHero(Hero.instance());
            }
            this.cControle.perdeVida(eElementos);
            this.cControle.morreu(Hero.instance(), fase);

        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint();
                /*(executa o metodo paint)*/
            }
        };

        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        String direcao = new String();
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            direcao = "cima";
            Hero.instance().moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            direcao = "baixo";
            Hero.instance().moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direcao = "esquerda";
            Hero.instance().moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direcao = "direita";
            Hero.instance().moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            this.fase.curFase = 0;
            this.fase.proxFase();
        } else if(e.getKeyCode() == KeyEvent.VK_C){
            Proxy proxy = new Proxy(KeyEvent.VK_C,e);
            proxy.preventCheat();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            try {
                this.cControle.save(eElementos, fase.curFase);
                this.savedFase = fase.curFase;
                System.out.println("saved fase: " + savedFase);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            ArrayList<Elemento> aux = new ArrayList<Elemento>();
            int f=0;
            try {
                f = this.cControle.getSavedFase();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.fase.setCurFase(f - 1);
            aux = this.cControle.load();
            Hero.instance().setPosicao(aux.get(0).getPosicao());
            this.fase.proxFase();
            eElementos = aux;
            Hero.instance().setPosicao(eElementos.get(0).getPosicao());
            eElementos.add(0, Hero.instance());
            fase.setHero(Hero.instance());

        } else if (e.getKeyCode() == KeyEvent.VK_T) {
            if (!this.cControle.haColecionaveis(eElementos)) {
                this.p = Hero.instance().joga();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            switch (Hero.instance().getUltimoMov()) {
                case "cima":
                    for (int i = 1; i < eElementos.size(); i++) {
                        if (eElementos.get(i).getPosicao().getColuna() == Hero.instance().getPosicao().getColuna() && (eElementos.get(i).getPosicao().getLinha() + 1) == Hero.instance().getPosicao().getLinha()) {
                            if (eElementos.get(i).quebra()) {
                                eElementos.get(i).setbTransponivel(true);
                            }
                        }
                    }
                    break;
                case "baixo":
                    for (int i = 1; i < eElementos.size(); i++) {
                        if (eElementos.get(i).getPosicao().getColuna() == Hero.instance().getPosicao().getColuna() && (eElementos.get(i).getPosicao().getLinha() - 1) == Hero.instance().getPosicao().getLinha()) {
                            if (eElementos.get(i).quebra()) {
                                eElementos.get(i).setbTransponivel(true);
                            }
                        }
                    }
                    break;
                case "esquerda":
                    for (int i = 1; i < eElementos.size(); i++) {
                        if ((eElementos.get(i).getPosicao().getColuna() + 1) == Hero.instance().getPosicao().getColuna() && eElementos.get(i).getPosicao().getLinha() == Hero.instance().getPosicao().getLinha()) {
                            if (eElementos.get(i).quebra()) {
                                eElementos.get(i).setbTransponivel(true);
                            }
                        }
                    }
                    break;
                case "direita":
                    for (int i = 1; i < eElementos.size(); i++) {
                        if ((eElementos.get(i).getPosicao().getColuna() - 1) == Hero.instance().getPosicao().getColuna() && eElementos.get(i).getPosicao().getLinha() == Hero.instance().getPosicao().getLinha()) {
                            if (eElementos.get(i).quebra()) {
                                eElementos.get(i).setbTransponivel(true);
                            }
                        }
                    }
                    break;

            }
        }
        Elemento sobreposto;
        sobreposto = cControle.ehPosicaoValida(this.eElementos, Hero.instance().getPosicao());
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (sobreposto != null) {
            if (sobreposto.ehMovel()) {
                switch (direcao) {
                    case "cima":
                        if (!sobreposto.moveUp()) {
                            Hero.instance().voltaAUltimaPosicao();
                        }
                        break;
                    case "baixo":
                        if (!sobreposto.moveDown()) {
                            Hero.instance().voltaAUltimaPosicao();
                        }
                        break;
                    case "esquerda":
                        if (!sobreposto.moveLeft()) {
                            Hero.instance().voltaAUltimaPosicao();
                        }
                        break;
                    case "direita":
                        if (!sobreposto.moveRight()) {
                            Hero.instance().voltaAUltimaPosicao();
                        }
                        break;
                }
            }
            if (!sobreposto.isbTransponivel() && !sobreposto.ehMovel()) {
                Hero.instance().voltaAUltimaPosicao();
            }
        }

        this.setTitle("-> Cell: " + (Hero.instance().getPosicao().getColuna()) + ", " + (Hero.instance().getPosicao().getLinha()));
    }

    public void mousePressed(MouseEvent e) {
        //Movimento via mouse
        int x = e.getX();
        int y = e.getY();

        this.setTitle("X: " + x + ", Y: " + y
                + " -> Cell: " + (y / Consts.CELL_SIDE) + ", " + (x / Consts.CELL_SIDE));

        try {
            JFileChooser file = new JFileChooser("C:\\Users\\Victo\\OneDrive\\Área de Trabalho\\POO\\Skooter2021");
            int retorn = file.showOpenDialog(file);

            File f = file.getSelectedFile();
            FileInputStream canoIn = new FileInputStream(f);
            ObjectInputStream deserializador = new ObjectInputStream(canoIn);
            Pokemon[] ar = (Pokemon[]) deserializador.readObject();
            this.cControle.susbtitui(eElementos, ar);
            this.fase.setHero(Hero.instance());
        } catch (IOException es) {
            es.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.hHero.getPosicao().setPosicao(y / Consts.CELL_SIDE, x / Consts.CELL_SIDE);

        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        repaint();
    }

    public boolean ehPosicaoValidaRelativaAUmPersonagem(Elemento Elemento) {
        return cControle.ehPosicaoValidaRelativaAUmPersonagem(this.eElementos, Elemento);
    }

    public ControleDeJogo getControler() {
        return this.cControle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
