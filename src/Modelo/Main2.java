/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Victo
 */
public class Main2 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Pokemon articuno = new Pokemon("articuno.png");
        PokemonVoador articunoV = new PokemonVoador(articuno);
        Pokemon articuno2 = new Pokemon("articuno.png");
        PokemonVoador articunoV2 = new PokemonVoador(articuno2);
        Pokemon articuno3 = new Pokemon("articuno.png");
        PokemonVoador articunoV3 = new PokemonVoador(articuno3);
        Pokemon articuno4 = new Pokemon("articuno.png");
        PokemonVoador articunoV4 = new PokemonVoador(articuno4);
        PokemonVoador[] array = new PokemonVoador[4];
        array[0] = articunoV;
        array[1] = articunoV2;
        array[2] = articunoV3;
        array[3] = articunoV4;
        try{
            File tanque = new File("Elemento.txt");
            tanque.createNewFile();
            FileOutputStream canoOut = new FileOutputStream(tanque);
            ObjectOutputStream serializador = new ObjectOutputStream(canoOut);
            serializador.writeObject(array);
            
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }
}
