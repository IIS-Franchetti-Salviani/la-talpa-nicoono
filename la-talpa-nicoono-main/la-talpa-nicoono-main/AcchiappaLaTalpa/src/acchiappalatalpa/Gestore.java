/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acchiappalatalpa;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author onorati.nicolo
 */
public class Gestore extends Thread {
    private ArrayList<RoundButton> buche;
    private Random rand = new Random();

    public Gestore(ArrayList<RoundButton> buche) {
        this.buche = buche;
    }

    @Override
    public void run() {
        while (true) { // Ciclo infinito
            faiUscireTalpa();
            try {
                // Aspetta 1 secondo (il tempo che la talpa stia fuori) 
                // prima di ricominciare il ciclo e lanciarne un'altra
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void faiUscireTalpa() {
        if (buche != null && !buche.isEmpty()) {
            int indice = rand.nextInt(buche.size());
            Talpa t = new Talpa(buche.get(indice));
            t.start(); // Avvia il thread della singola talpa
        }
    }
}
