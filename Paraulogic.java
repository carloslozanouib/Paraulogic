/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paraulogic;

import java.awt.Button;
import java.util.Iterator;
import java.util.Random;
import javax.swing.text.View;

/**
 *
 * @author carlo
 */
public class Paraulogic {

    public static void main(String[] args) {
        new Paraulogic().inicio2();

    }

    private void inicio2() {
        omplirLletres();
       // omplirBotons();
       // shuffle();
    }

    Random rand = new Random();
    Button[] bt = new Button[7];
    // TextView paraula = findViewById(R.id.paraula_id);
    // String pal = paraula.toString();

    UnsortedArraySet<Character> lletres = new UnsortedArraySet<>(7);
    Iterator it = lletres.iterator();
    //OMPLIM EL CONJUNT AMB 7 LLETRES ALEATÒRIES

    private void omplirLletres() {
        int i = 0;
        char c;
        while (i<7) {
            c = (char) (rand.nextInt(26) + 'a'); //caràcter aleatori
            System.out.println(c);
          /*  if (lletres.add(c)) { //si el caràcter no es repetit
                bt[i].setName(Character.toString(c));
                System.out.println(bt[i]);
                i++;
            ^*/
        }
    }

    //POSAM LES 7 LLETRES ALEATÒRIES A CADA BOTÓ
    private void omplirBotons() {
        for (int j = 0; j < bt.length; j++) {
            System.out.println("Contingut: " + bt[j]);
        }
    }

    private void shuffle() {
        for (int i = 6; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            //intercambiam indexos
            Button temp = bt[i];
            bt[i] = bt[j];
            bt[j] = temp;
        }
        System.out.println("Contingut Nou" + bt.toString());
    }

    //MÈTODE PER POSAR LA LLETRA DEL BOTÓ PITJAT A LA PARAULA
    /*public void setLletra ( View view ) {
        Button  btn = ( Button )findViewById(view.getId());
        pal += btn.getText();
        paraula.setText(pal);
    }*/
}
