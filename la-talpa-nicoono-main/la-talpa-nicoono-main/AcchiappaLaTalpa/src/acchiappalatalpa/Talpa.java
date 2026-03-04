/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acchiappalatalpa;

import java.awt.Color;

/**
 *
 * @author onorati.nicolo
 */
public class Talpa extends Thread { 
    private RoundButton buca;

    public Talpa(RoundButton buca) {
        this.buca = buca;
    }

    @Override
    public void run() {
        try {
            buca.setBackground(new Color(139, 69, 19)); // Esce
            Thread.sleep(1000);                         // Resta per 1 secondo
            buca.setBackground(Color.LIGHT_GRAY);       // Rientra
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
