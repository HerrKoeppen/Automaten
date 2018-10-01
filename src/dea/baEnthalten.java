/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dea;

/**
 * Deterministischer Endlicher Automat zum Erkennen von Wörtern über {a,b}, die
 * die Silbe ba enthalten.
 *
 * @author K
 */
public class baEnthalten {

    private int zustand;

    public void zustandWechseln(char zeichen) {
        

        
    }

    public boolean wortUntersuchen(String text) {
        boolean baEnthalten = false;
        System.out.println(zustand);
        for (int i = 0; i < text.length(); i++) {
            zustandWechseln(text.charAt(i));
            System.out.println(zustand);

        }
        if (zustand == 2) {
            baEnthalten = true;
        }
        System.out.println(zustand);
        zustand = 0;
        return baEnthalten;
    }

    public static void main(String[] args) {
        baEnthalten s = new baEnthalten();
        System.out.println(s.wortUntersuchen("a"));
        System.out.println(s.wortUntersuchen("b"));
        System.out.println(s.wortUntersuchen("baaaabababb"));
    }

}
