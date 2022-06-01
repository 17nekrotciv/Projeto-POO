/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Auxiliar.Posicao;
import Modelo.Elemento;
import Modelo.Hero;
import Modelo.ArvoreFixa;
import Modelo.PedraMoveQuebra;
import Modelo.PedraMove;
import Modelo.PedraQuebra;
import Modelo.Pokeball;
import Modelo.Pokemon;
import Modelo.PokemonVoador;
import Modelo.SetaBaixo;
import Modelo.SetaCima;
import Modelo.SetaDireita;
import Modelo.SetaEsquerda;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Fases extends ArrayList<Elemento>{
    int curFase;
    Hero h;
    Fases(int size){
        super(size);
        this.curFase = 1;
    }
    
    public void Fase1(){
        this.curFase = 1; 
        this.clear();
        this.add(Hero.instance());
        Hero.instance().setPosicao(0, 7);
        
        
        
        this.add(new ArvoreFixa(new Posicao(1,1)));
        this.add(new ArvoreFixa(new Posicao(3,1)));
        this.add(new ArvoreFixa(new Posicao(5,1)));
        this.add(new ArvoreFixa(new Posicao(7,1)));
        this.add(new ArvoreFixa(new Posicao(9,1)));
        this.add(new ArvoreFixa(new Posicao(1,3)));
        this.add(new ArvoreFixa(new Posicao(3,3)));
        this.add(new ArvoreFixa(new Posicao(5,3)));
        this.add(new ArvoreFixa(new Posicao(7,3)));
        this.add(new ArvoreFixa(new Posicao(9,3)));
        this.add(new ArvoreFixa(new Posicao(1,5)));
        this.add(new ArvoreFixa(new Posicao(3,5)));
        this.add(new ArvoreFixa(new Posicao(5,5)));
        this.add(new ArvoreFixa(new Posicao(7,5)));
        this.add(new ArvoreFixa(new Posicao(9,5)));
        this.add(new ArvoreFixa(new Posicao(1,7)));
        this.add(new ArvoreFixa(new Posicao(3,7)));
        this.add(new ArvoreFixa(new Posicao(5,7)));
        this.add(new ArvoreFixa(new Posicao(7,7)));
        this.add(new ArvoreFixa(new Posicao(9,7)));
        this.add(new ArvoreFixa(new Posicao(1,9)));
        this.add(new ArvoreFixa(new Posicao(3,9)));
        this.add(new ArvoreFixa(new Posicao(5,9)));
        this.add(new ArvoreFixa(new Posicao(7,9)));
        this.add(new ArvoreFixa(new Posicao(9,9)));
        
        this.add(new PedraMoveQuebra(new Posicao(3,0)));
        this.add(new PedraMoveQuebra(new Posicao(9,0)));
        this.add(new PedraMoveQuebra(new Posicao(0,1)));
        this.add(new PedraMoveQuebra(new Posicao(2,1)));
        this.add(new PedraMoveQuebra(new Posicao(4,1)));
        this.add(new PedraMoveQuebra(new Posicao(1,2)));
        this.add(new PedraMoveQuebra(new Posicao(5,2)));
        this.add(new PedraMoveQuebra(new Posicao(9,2)));
        this.add(new PedraMoveQuebra(new Posicao(8,3)));
        this.add(new PedraMoveQuebra(new Posicao(0,5)));
        this.add(new PedraMoveQuebra(new Posicao(2,5)));
        this.add(new PedraMoveQuebra(new Posicao(6,5)));
        this.add(new PedraMoveQuebra(new Posicao(5,6)));
        this.add(new PedraMoveQuebra(new Posicao(9,6)));
        this.add(new PedraMoveQuebra(new Posicao(6,7)));
        this.add(new PedraMoveQuebra(new Posicao(10,7)));
        this.add(new PedraMoveQuebra(new Posicao(1,8)));
        this.add(new PedraMoveQuebra(new Posicao(3,8)));
        this.add(new PedraMoveQuebra(new Posicao(7,8)));
        this.add(new PedraMoveQuebra(new Posicao(9,8)));
        this.add(new PedraMoveQuebra(new Posicao(4,9)));
        this.add(new PedraMoveQuebra(new Posicao(8,9)));
        this.add(new PedraMoveQuebra(new Posicao(1,10)));
        this.add(new PedraMoveQuebra(new Posicao(7,10)));
        
        Pokeball pokeball = new Pokeball("pokeball.png");
        pokeball.setPosicao(0,0);       
        this.add(pokeball);
        
        Pokeball greatball = new Pokeball("greatball.png");
        greatball.setPosicao(10,0);        
        this.add(greatball);
        
        Pokeball masterball = new Pokeball("masterball.png");
        masterball.setPosicao(10,10);        
        this.add(masterball); 
        
        Pokeball ultraball = new Pokeball("ultraball.png");
        ultraball.setPosicao(0,10);        
        this.add(ultraball);
        
        Pokemon eevee = new Pokemon("eevee.png");
        eevee.setPosicao(2, 0);
        this.add(eevee);
        
        Pokemon deoxys = new Pokemon("deoxys.png");
        deoxys.setPosicao(0, 9);
        this.add(deoxys);
        
        Pokemon magikarp = new Pokemon("magikarp.png");
        magikarp.setPosicao(10, 9);
        this.add(magikarp);
        
        Pokemon articuno = new Pokemon("articuno.png");
        PokemonVoador articunoV = new PokemonVoador(articuno);
        articunoV.setPosicao(10, 1);
        this.add(articunoV);
        
    }
    
    public void Fase2(){
        this.curFase = 2;
        this.clear();
        this.add(Hero.instance());
        Hero.instance().setPosicao(8, 5);
        
        Pokemon eevee = new Pokemon("eevee.png");
        eevee.setPosicao(1,1);
        this.add(eevee);
        
        Pokemon articuno = new Pokemon("articuno.png");
        articuno.setPosicao(9, 1);
        this.add(articuno);
        
        Pokemon deoxys = new Pokemon("deoxys.png");
        deoxys.setPosicao(1, 9);
        this.add(deoxys);
        
        Pokemon magikarp = new Pokemon("magikarp.png");
        magikarp.setPosicao(9, 9);
        this.add(magikarp);
        
        this.add(new ArvoreFixa(new Posicao(3,1)));
        this.add(new ArvoreFixa(new Posicao(7,1)));
        this.add(new ArvoreFixa(new Posicao(1,3)));
        this.add(new ArvoreFixa(new Posicao(3,3)));
        this.add(new ArvoreFixa(new Posicao(5,3)));
        this.add(new ArvoreFixa(new Posicao(7,3)));
        this.add(new ArvoreFixa(new Posicao(9,3)));
        this.add(new ArvoreFixa(new Posicao(3,5)));
        this.add(new ArvoreFixa(new Posicao(7,5)));
        this.add(new ArvoreFixa(new Posicao(1,7)));
        this.add(new ArvoreFixa(new Posicao(3,7)));
        this.add(new ArvoreFixa(new Posicao(5,7)));
        this.add(new ArvoreFixa(new Posicao(7,7)));
        this.add(new ArvoreFixa(new Posicao(9,7)));
        this.add(new ArvoreFixa(new Posicao(3,9)));
        this.add(new ArvoreFixa(new Posicao(7,9)));
        
        Pokeball pokeball = new Pokeball("pokeball.png");
        pokeball.setPosicao(1,5);
        this.add(pokeball);
        
        Pokeball greatball = new Pokeball("greatball.png");
        greatball.setPosicao(9,5);        
        this.add(greatball);
        
        Pokeball masterball = new Pokeball("masterball.png");
        masterball.setPosicao(5,1);        
        this.add(masterball); 
        
        Pokeball ultraball = new Pokeball("ultraball.png");
        ultraball.setPosicao(5,9);        
        this.add(ultraball);
        
        
        this.add(new SetaCima(new Posicao(3,0)));
        this.add(new SetaCima(new Posicao(4,0)));
        this.add(new SetaCima(new Posicao(5,0)));
        this.add(new SetaCima(new Posicao(6,0)));
        this.add(new SetaCima(new Posicao(7,0)));
        this.add(new SetaCima(new Posicao(3,6)));
        this.add(new SetaCima(new Posicao(7,6)));
        this.add(new SetaCima(new Posicao(3,8)));
        this.add(new SetaCima(new Posicao(4,8)));
        this.add(new SetaCima(new Posicao(7,8)));
        this.add(new SetaCima(new Posicao(7,10)));
        
        this.add(new SetaBaixo(new Posicao(3,2)));
        this.add(new SetaBaixo(new Posicao(7,2)));
        this.add(new SetaBaixo(new Posicao(2,4)));
        this.add(new SetaBaixo(new Posicao(3,4)));
        this.add(new SetaBaixo(new Posicao(7,4)));
        this.add(new SetaBaixo(new Posicao(3,10)));
        
        this.add(new SetaDireita(new Posicao(0,3)));
        this.add(new SetaDireita(new Posicao(2,3)));
        this.add(new SetaDireita(new Posicao(4,3)));
        this.add(new SetaDireita(new Posicao(6,3)));
        this.add(new SetaDireita(new Posicao(8,3)));
        this.add(new SetaDireita(new Posicao(0,7)));
        this.add(new SetaDireita(new Posicao(4,7)));
        this.add(new SetaDireita(new Posicao(8,7)));
        this.add(new SetaDireita(new Posicao(10,7)));
        
        this.add(new SetaEsquerda(new Posicao(10,3)));
        this.add(new SetaEsquerda(new Posicao(2,5)));
        this.add(new SetaEsquerda(new Posicao(2,6)));
        this.add(new SetaEsquerda(new Posicao(2,7)));
        this.add(new SetaEsquerda(new Posicao(6,7)));
        this.add(new SetaEsquerda(new Posicao(4,9)));
        this.add(new SetaEsquerda(new Posicao(4,10)));
        
    }
    
    public void Fase3(){
        this.curFase = 3;
        this.clear();
        this.add(Hero.instance());
        Hero.instance().setPosicao(5, 5);
        
        Pokemon eevee = new Pokemon("eevee.png");
        eevee.setPosicao(8, 5);
        this.add(eevee);
        
        Pokemon articuno = new Pokemon("articuno.png");
        articuno.setPosicao(10, 5);
        this.add(articuno);
        
        Pokemon deoxys = new Pokemon("deoxys.png");
        deoxys.setPosicao(2, 5);
        this.add(deoxys);
        
        Pokemon magikarp = new Pokemon("magikarp.png");
        magikarp.setPosicao(0, 5);
        this.add(magikarp);
        
        this.add(new PedraMove(new Posicao(1,1)));
        this.add(new PedraMove(new Posicao(2,1)));
        this.add(new PedraMove(new Posicao(3,1)));
        this.add(new PedraMove(new Posicao(4,1)));
        this.add(new PedraMove(new Posicao(5,1)));
        this.add(new PedraMove(new Posicao(6,1)));
        this.add(new PedraMove(new Posicao(7,1)));
        this.add(new PedraMove(new Posicao(8,1)));
        this.add(new PedraMove(new Posicao(9,1)));
        this.add(new PedraMove(new Posicao(1,2)));
        this.add(new PedraMove(new Posicao(1,3)));
        this.add(new PedraMove(new Posicao(1,4)));
        this.add(new PedraMove(new Posicao(1,5)));
        this.add(new PedraMove(new Posicao(1,6)));
        this.add(new PedraMove(new Posicao(1,7)));
        this.add(new PedraMove(new Posicao(1,8)));
        this.add(new PedraMove(new Posicao(1,9)));
        this.add(new PedraMove(new Posicao(2,9)));
        this.add(new PedraMove(new Posicao(3,9)));
        this.add(new PedraMove(new Posicao(4,9)));
        this.add(new PedraMove(new Posicao(5,9)));
        this.add(new PedraMove(new Posicao(6,9)));
        this.add(new PedraMove(new Posicao(7,9)));
        this.add(new PedraMove(new Posicao(8,9)));
        this.add(new PedraMove(new Posicao(9,9)));
        this.add(new PedraMove(new Posicao(9,2)));
        this.add(new PedraMove(new Posicao(9,3)));
        this.add(new PedraMove(new Posicao(9,4)));
        this.add(new PedraMove(new Posicao(9,5)));
        this.add(new PedraMove(new Posicao(9,6)));
        this.add(new PedraMove(new Posicao(9,7)));
        this.add(new PedraMove(new Posicao(9,8)));
        
        this.add(new PedraMove(new Posicao(3,3)));
        this.add(new PedraMove(new Posicao(4,3)));
        this.add(new PedraMove(new Posicao(5,3)));
        this.add(new PedraMove(new Posicao(6,3)));
        this.add(new PedraMove(new Posicao(7,3)));
        this.add(new PedraMove(new Posicao(3,4)));
        this.add(new PedraMove(new Posicao(3,5)));
        this.add(new PedraMove(new Posicao(3,6)));
        this.add(new PedraMove(new Posicao(3,7)));
        this.add(new PedraMove(new Posicao(4,7)));
        this.add(new PedraMove(new Posicao(5,7)));
        this.add(new PedraMove(new Posicao(6,7)));
        this.add(new PedraMove(new Posicao(7,7)));
        this.add(new PedraMove(new Posicao(7,3)));
        this.add(new PedraMove(new Posicao(7,4)));
        this.add(new PedraMove(new Posicao(7,5)));
        this.add(new PedraMove(new Posicao(7,6)));
        
        Pokeball pokeball = new Pokeball("pokeball.png");
        pokeball.setPosicao(5,0);
        this.add(pokeball);
        
        Pokeball greatball = new Pokeball("greatball.png");
        greatball.setPosicao(5,2);        
        this.add(greatball);
        
        Pokeball masterball = new Pokeball("masterball.png");
        masterball.setPosicao(5,8);        
        this.add(masterball); 
        
        Pokeball ultraball = new Pokeball("ultraball.png");
        ultraball.setPosicao(5,10);        
        this.add(ultraball);
        
        
    }
    
    public void Fase4(){
        this.curFase = 4;
        this.clear();
        this.add(Hero.instance());
        Hero.instance().setPosicao(4, 5);
        
        Pokemon eevee = new Pokemon("eevee.png");
        eevee.setPosicao(0, 5);
        this.add(eevee);
        
        Pokemon articuno = new Pokemon("articuno.png");
        articuno.setPosicao(10, 5);
        this.add(articuno);
        
        Pokemon deoxys = new Pokemon("deoxys.png");
        deoxys.setPosicao(5, 0);
        this.add(deoxys);
        
        Pokemon magikarp = new Pokemon("magikarp.png");
        magikarp.setPosicao(5, 10);
        this.add(magikarp);
        
        this.add(new PedraQuebra(new Posicao(1,1)));
        this.add(new PedraQuebra(new Posicao(3,1)));
        this.add(new PedraQuebra(new Posicao(5,1)));
        this.add(new PedraQuebra(new Posicao(7,1)));
        this.add(new PedraQuebra(new Posicao(9,1)));
        this.add(new PedraQuebra(new Posicao(2,2)));
        this.add(new PedraQuebra(new Posicao(4,2)));
        this.add(new PedraQuebra(new Posicao(6,2)));
        this.add(new PedraQuebra(new Posicao(8,2)));
        this.add(new PedraQuebra(new Posicao(1,3)));
        this.add(new PedraQuebra(new Posicao(3,3)));
        this.add(new PedraQuebra(new Posicao(5,3)));
        this.add(new PedraQuebra(new Posicao(7,3)));
        this.add(new PedraQuebra(new Posicao(9,3)));
        this.add(new PedraQuebra(new Posicao(2,4)));
        this.add(new PedraQuebra(new Posicao(4,4)));
        this.add(new PedraQuebra(new Posicao(6,4)));
        this.add(new PedraQuebra(new Posicao(8,4)));
        this.add(new PedraQuebra(new Posicao(1,5)));
        this.add(new PedraQuebra(new Posicao(3,5)));
        this.add(new PedraQuebra(new Posicao(5,5)));
        this.add(new PedraQuebra(new Posicao(7,5)));
        this.add(new PedraQuebra(new Posicao(9,5)));
        this.add(new PedraQuebra(new Posicao(2,6)));
        this.add(new PedraQuebra(new Posicao(4,6)));
        this.add(new PedraQuebra(new Posicao(6,6)));
        this.add(new PedraQuebra(new Posicao(8,6)));
        this.add(new PedraQuebra(new Posicao(1,7)));
        this.add(new PedraQuebra(new Posicao(3,7)));
        this.add(new PedraQuebra(new Posicao(5,7)));
        this.add(new PedraQuebra(new Posicao(7,7)));
        this.add(new PedraQuebra(new Posicao(9,7)));
        this.add(new PedraQuebra(new Posicao(2,8)));
        this.add(new PedraQuebra(new Posicao(4,8)));
        this.add(new PedraQuebra(new Posicao(6,8)));
        this.add(new PedraQuebra(new Posicao(8,8)));
        this.add(new PedraQuebra(new Posicao(1,9)));
        this.add(new PedraQuebra(new Posicao(3,9)));
        this.add(new PedraQuebra(new Posicao(5,9)));
        this.add(new PedraQuebra(new Posicao(7,9)));
        this.add(new PedraQuebra(new Posicao(9,9)));
        
        this.add(new ArvoreFixa(new Posicao(1,0)));
        this.add(new ArvoreFixa(new Posicao(7,0)));
        this.add(new ArvoreFixa(new Posicao(8,1)));
        this.add(new ArvoreFixa(new Posicao(10,1)));
        this.add(new ArvoreFixa(new Posicao(3,2)));
        this.add(new ArvoreFixa(new Posicao(5,2)));
        this.add(new ArvoreFixa(new Posicao(0,3)));
        this.add(new ArvoreFixa(new Posicao(6,3)));
        this.add(new ArvoreFixa(new Posicao(2,5)));
        this.add(new ArvoreFixa(new Posicao(0,7)));
        this.add(new ArvoreFixa(new Posicao(8,7)));
        this.add(new ArvoreFixa(new Posicao(1,8)));
        this.add(new ArvoreFixa(new Posicao(5,8)));
        this.add(new ArvoreFixa(new Posicao(3,10)));
        this.add(new ArvoreFixa(new Posicao(8,10)));
        
        Pokeball pokeball = new Pokeball("pokeball.png");
        pokeball.setPosicao(0,0);
        this.add(pokeball);
        
        Pokeball greatball = new Pokeball("greatball.png");
        greatball.setPosicao(0,10);        
        this.add(greatball);
        
        Pokeball masterball = new Pokeball("masterball.png");
        masterball.setPosicao(10,0);        
        this.add(masterball); 
        
        Pokeball ultraball = new Pokeball("ultraball.png");
        ultraball.setPosicao(10,10);        
        this.add(ultraball);
        
         
    }
    
    public void proxFase(){
        if(this.curFase == 0){
            this.Fase1();
            return;
        }
        if(this.curFase == 1){
            this.Fase2();
            return;
        }
        if(this.curFase == 2){
            this.Fase3();
            return;
        }
        if(this.curFase == 3){
            this.Fase4();
            return;
        }
        if(this.curFase == 4){
            this.Fase1();
            return;
        }
        System.out.println(this.curFase);
    }

    public void setCurFase(int curFase) {
        this.curFase = curFase;
    }

    public void setHero(Hero hero) {
        this.h = hero;
    }
    
    
}
