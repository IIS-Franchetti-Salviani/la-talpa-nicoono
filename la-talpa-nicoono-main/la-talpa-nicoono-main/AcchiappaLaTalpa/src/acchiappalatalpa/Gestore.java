/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acchiappalatalpa;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author onorati.nicolo
 */
public class Gestore extends Thread {
    private ArrayList<RoundButton> buche;
    private JLabel lblTimer;    // Questa scriverà sulla lbl_tempo
    private Giocatore giocatore; 
    private int tempoResiduo = 10;
    private Random rand = new Random();

    // IL COSTRUTTORE: Accetta esattamente 3 cose
    public Gestore(ArrayList<RoundButton> buche, JLabel lblTimer, Giocatore giocatore) {
        this.buche = buche;
        this.lblTimer = lblTimer;
        this.giocatore = giocatore;
    }

    @Override
    public void run() {
        while (tempoResiduo > 0 && !Thread.currentThread().isInterrupted()) {
            faiUscireTalpa();
            try {
                Thread.sleep(1000); // Aspetta 1 secondo
                tempoResiduo--;     // Diminuisce il tempo
                
                // Aggiorna SOLO la label del tempo
                SwingUtilities.invokeLater(() -> {
                    if (lblTimer != null) {
                        lblTimer.setText("Tempo: " + tempoResiduo);
                    }
                });
            } catch (InterruptedException e) {
                break; 
            }
        }
        terminaPartita();
    }

    public void faiUscireTalpa() {
        if (buche != null && !buche.isEmpty()) {
            int indice = rand.nextInt(buche.size());
            Talpa t = new Talpa(buche.get(indice));
            t.start();
        }
    }

    private void terminaPartita() {
        SwingUtilities.invokeLater(() -> {
            for (RoundButton b : buche) {
                b.setEnabled(false); // Blocca i bottoni
            }
            JOptionPane.showMessageDialog(null, "Fine Partita! Punteggio: " + giocatore.getPunteggio());
        });
    }
}