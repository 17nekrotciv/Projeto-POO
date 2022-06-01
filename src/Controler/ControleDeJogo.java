package Controler;

import Auxiliar.Desenhador;
import Modelo.Elemento;
import Modelo.Hero;
import Auxiliar.Posicao;
import Modelo.Pokeball;
import Modelo.PokeballJoga;
import Modelo.Pokemon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author junio
 */
public class ControleDeJogo {

    public void desenhaTudo(ArrayList<Elemento> e) {
        for (int i = 0; i < e.size(); i++) {
            e.get(i).autoDesenho();
        }
    }

    public void processaTudo(ArrayList<Elemento> e) {
        Hero.instance();
        /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        /*Processa todos os demais em relacao ao heroi*/
        for (int i = 1; i < e.size(); i++) {
            eTemp = e.get(i);
            /*Pega o i-esimo elemento do jogo*/
 /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if (Hero.instance().getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) /*Nem todos os elementos podem ser transpostos pelo heroi*/ {
                if (eTemp.isbTransponivel() && !eTemp.isSeta() && !eTemp.ehPokemon()) {
                    e.remove(eTemp);
                }
            }
            if (eTemp.isbTransponivel() && eTemp.isSeta() && Hero.instance().getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())) {
                switch (eTemp.getTipoSeta()) {
                    case "cima":
                        Hero.instance().moveUp();
                        break;
                    case "baixo":
                        Hero.instance().moveDown();
                        break;
                    case "esquerda":
                        Hero.instance().moveLeft();
                        break;
                    case "direita":
                        Hero.instance().moveRight();
                        break;
                }
            }
        }
    }

    public Elemento ehPosicaoValida(ArrayList<Elemento> e, Posicao p) {
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for (int i = 1; i < e.size(); i++) {
            /*Olha todos os elementos*/
            eTemp = e.get(i);
            /*Pega o i-esimo elemento do jogo*/
            if (!eTemp.isbTransponivel()) {
                if (eTemp.getPosicao().estaNaMesmaPosicao(p)) {
                    return eTemp; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
                }
            }
        }
        return null;
    }

    public boolean ehPosicaoValidaRelativaAUmPersonagem(ArrayList<Elemento> e, Elemento Elemento) {
        Elemento eTemp;
        for (int i = 0; i < e.size(); i++) {
            eTemp = e.get(i);
            if (eTemp == Elemento) {
                continue;
            }
            if (Elemento.ehPokemon() && eTemp.ehColecionavel()) {
                if (eTemp.getPosicao().estaNaMesmaPosicao(Elemento.getPosicao())) {
                    return true;
                }
            }
            if (Elemento.ehPokemon() && eTemp.isSeta()) {
                if (eTemp.getPosicao().estaNaMesmaPosicao(Elemento.getPosicao())) {
                    return false;
                }
            }
            if (!eTemp.isbTransponivel() || eTemp.ehColecionavel()) {
                if (eTemp.getPosicao().estaNaMesmaPosicao(Elemento.getPosicao())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean haColecionaveis(ArrayList<Elemento> e) {
        for (int i = 0; i < e.size(); i++) {
            if (i == 0) {
                continue;
            } else if (e.get(i).ehColecionavel()) {
                return true;
            }
        }
        return false;
    }

    public void destroi(ArrayList<Elemento> e, Hero h) {
        switch (h.getUltimoMov()) {
            case "cima":
                for (int i = 1; i < e.size(); i++) {
                    if (e.get(i).getPosicao().getColuna() == h.getPosicao().getColuna() && (e.get(i).getPosicao().getLinha() - 1) == h.getPosicao().getLinha()) {
                        e.get(i).setbTransponivel(true);
                    }
                }
                break;
            case "baixo":
                for (int i = 1; i < e.size(); i++) {
                    if (e.get(i).getPosicao().getColuna() == h.getPosicao().getColuna() && (e.get(i).getPosicao().getLinha() + 1) == h.getPosicao().getLinha()) {
                        e.get(i).setbTransponivel(true);
                    }
                }
                break;
            case "esquerda":
                for (int i = 1; i < e.size(); i++) {
                    if ((e.get(i).getPosicao().getColuna() - 1) == h.getPosicao().getColuna() && e.get(i).getPosicao().getLinha() == h.getPosicao().getLinha()) {
                        e.get(i).setbTransponivel(true);
                    }
                }
                break;
            case "direita":
                for (int i = 1; i < e.size(); i++) {
                    if ((e.get(i).getPosicao().getColuna() + 1) == h.getPosicao().getColuna() && e.get(i).getPosicao().getLinha() == h.getPosicao().getLinha()) {
                        e.get(i).setbTransponivel(true);
                    }
                }
                break;
        }
    }

    public void perdeVida(ArrayList<Elemento> e) {
        Hero h = (Hero) e.get(0);
        for (int i = 1; i < e.size(); i++) {
            if (e.get(i).ehPokemon()) {
                if (h.getPosicao().estaNaMesmaPosicao(e.get(i).getPosicao())) {
                    h.setVidas(h.getVidas() - 1);
                    if (h.getVidas() >= 0) {
                        System.out.println("Vidas: " + h.getVidas());
                    }
                }
            }
        }
    }

    public void morreu(Hero h, Fases fase) {
        if (h.getVidas() < 0) {
            h.setVidas(6);
            fase.setCurFase(0);
            fase.proxFase();
        }
    }

    public boolean haPokemon(ArrayList<Elemento> e) {
        for (int i = 0; i < e.size(); i++) {
            if (i == 0) {
                continue;
            } else if (e.get(i).ehPokemon()) {
                return true;
            }
        }
        return false;
    }

    public void verificaCaptura(ArrayList<Elemento> e, PokeballJoga p) {
        for (int i = 1; i < e.size(); i++) {
            if (e.get(i).ehPokemon()) {
                if (p.getPosicao().estaNaMesmaPosicao(e.get(i).getPosicao())) {
                    e.remove(i);
                    Desenhador.getTelaDoJogo().removeElemento(p);
                }
            }
        }
    }

    public void save(ArrayList<Elemento> e, int fase) throws ClassNotFoundException {
        try {
            File tanque = new File("POO.zip");
            tanque.createNewFile();
            FileOutputStream canoOut = new FileOutputStream(tanque);
            GZIPOutputStream compactador = new GZIPOutputStream(canoOut);
            ObjectOutputStream serializador = new ObjectOutputStream(compactador);
            serializador.writeObject(e);
            serializador.close();
            canoOut.close();
            compactador.close();
            File f = new File("POO2.txt");
            f.createNewFile();
            FileOutputStream canoO = new FileOutputStream(f);
            ObjectOutputStream s = new ObjectOutputStream(canoO);
            s.writeInt(fase);
            s.close();
            canoO.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Elemento> load() {
        ArrayList<Elemento> e = new ArrayList<Elemento>();
        try {
            File tanque = new File("POO.txt");
            FileInputStream canoIn = new FileInputStream(tanque);
            GZIPInputStream descompactador = new GZIPInputStream(canoIn);
            ObjectInputStream deserializador = new ObjectInputStream(descompactador);
            e = (ArrayList<Elemento>) deserializador.readObject();
            canoIn.close();
            deserializador.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException es) {
            System.out.println(es.getMessage());
        }
        return e;
    }

    public int getSavedFase() throws FileNotFoundException, IOException {
        int fase = 0;

        File tanque = new File("POO2.txt");
        FileInputStream canoIn = new FileInputStream(tanque);
        ObjectInputStream deserializador = new ObjectInputStream(canoIn);
        fase = deserializador.readInt();
        canoIn.close();
        deserializador.close();
        return fase;

    }

    public void susbtitui(ArrayList<Elemento> e, Pokemon[] sub) {
        Posicao[] aux = new Posicao[4];
        int count = 0;
        int j = 0;
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).ehPokemon()) {
                j = i;
                break;
            }
        }
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).ehPokemon()) {
                aux[count] = e.get(i).getPosicao();
                e.remove(i);
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            e.add(sub[i]);
            e.get(e.size() - count).setPosicao(aux[i]);
        }
    }
}
