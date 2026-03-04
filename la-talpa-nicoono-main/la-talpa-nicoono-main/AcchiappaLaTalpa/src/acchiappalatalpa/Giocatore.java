/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acchiappalatalpa;

import javax.swing.JLabel;

/**
 *
 * @author onorati.nicolo
 */
public class Giocatore {
private int punteggio;
    private JLabel lblPunteggio; 

    public Giocatore(JLabel lblPunteggio) {
        this.punteggio = 0;
        this.lblPunteggio = lblPunteggio;
    }

    public void incrementaPunteggio() {
        this.punteggio++;
        aggiornaLabel();
    }
    
    public void decrementaPunteggio() {
        if (punteggio > 0) { 
            punteggio--;
        }
        aggiornaLabel();
    }

    // Metodo di supporto per non ripetere codice
    private void aggiornaLabel() {
        if (lblPunteggio != null) {
            lblPunteggio.setText("Punteggio: " + punteggio);
        }
    }

    public int getPunteggio() {
        return punteggio;
    }
}
