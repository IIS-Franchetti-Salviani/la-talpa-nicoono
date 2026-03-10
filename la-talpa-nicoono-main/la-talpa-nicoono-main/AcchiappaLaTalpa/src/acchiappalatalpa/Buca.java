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
public class Buca {
    private boolean occupata;
    private RoundButton bottone;
    private final Color COLORE_TALPA = new Color(139,69,19); 
    private final Color COLORE_VUOTO = Color.LIGHT_GRAY;

    public Buca(boolean occupata, RoundButton bottone) {
        this.occupata = false;
        this.bottone = bottone;
        this.bottone.setBackground(COLORE_VUOTO);
    }
    
    public void setOccupata(boolean stato){
        this.occupata = stato;
        
        if(stato){
            bottone.setBackground(COLORE_TALPA);
        }
        else{
            bottone.setBackground(COLORE_VUOTO);
        }
    }
    
    public boolean isOccupata(){
        return occupata;
    }
    
    
    public RoundButton getBottone(){
        return bottone;
    }
    
    
}
