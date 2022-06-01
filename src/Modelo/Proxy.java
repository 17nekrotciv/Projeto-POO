/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.KeyEvent;

/**
 *
 * @author Victo
 */
public class Proxy {
    KeyEvent k;

    public Proxy(int keyCode,KeyEvent k) {
        this.k = k;
        this.k.setKeyCode(keyCode);
    }
    
    public void preventCheat(){
        if(k.getKeyCode() == KeyEvent.VK_C){
            System.out.println("Tentativa de trapaca detectada");
        }
    }
}
