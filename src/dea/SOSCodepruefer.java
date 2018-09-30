/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dea;

/**
 *  Unglaublich lange und umständliche Implemetierung eines Beispielautomaten.
 * Der SOSCodePruefer prüft, ob ein Eingabewort im Morsecode (#,-,.) die Zeichenfolge #---...---# enthält.
 * Die Pause # vor und nach dem Wort ist wichtig, damit die Meldung RinderSOSse keinen falschen Alarm ausgibt.
 * Das Beispiel zeigt die Implementierung von Automaten: Zustand und Eingabezeichen werden über switch-Mehrfachverzeigungen unterschieden.
 * Es gibt zwei wesentliche Methoden: wortUntersuchen und zustandWechseln. ZustandWechseln wechselt den Zustand pro eingelesenen Zeichen. wortUntersuchen wiederholt für das gesamte Wort und beurteilt das Wort am Ende.
 * 
 * @author K
 */
public class SOSCodepruefer {
    private int zustand;
    public void zustandWechseln(char zeichen){
        switch(zustand) {
                case 0:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=0;}break;
                        
                    }
                }break;
                case 1:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=2;}break;
                        
                    }
                }break;
                case 2:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=3;}break;
                        
                    }
                }break;
                case 3:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=4;}break;
                        case '.':{zustand=0;}break;
                        
                    }
                }break;
                case 4:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=5;}break;
                        case '.':{zustand=0;}break;
                        
                    }
                }break;
                case 5:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=6;}break;
                        case '.':{zustand=0;}break;
                        
                    }
                }break;
                case 6:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=7;}break;
                        
                    }
                }break;
                case 7:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=8;}break;
                        
                    }
                }break;
                case 8:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=9;}break;
                        
                    }
                }break;
                case 9:{
                    switch(zeichen) {
                        case '#':{zustand=10;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=0;}break;
                        
                    }
                }break;
                case 10:{
                    switch(zeichen) {
                        case '#':{zustand=10;}break;
                        case '-':{zustand=10;}break;
                        case '.':{zustand=10;}break;
                        
                    }
                }break;
                case 11:{
                    switch(zeichen) {
                        case '#':{zustand=11;}break;
                        case '-':{zustand=0;}break;
                        case '.':{zustand=1;}break;
                        
                    }
                }break;
            }
                            
    }
    public boolean wortUntersuchen(String text){
        boolean SOSistEnthalten = false;
        System.out.println(zustand);
        for(int i = 0;i<text.length();i++){
            zustandWechseln(text.charAt(i));
                    System.out.println(zustand);

        }
        if (zustand==10){
            SOSistEnthalten = true;
        }
        System.out.println(zustand);
        zustand = 0;
        return SOSistEnthalten;
    }
    public static void main(String[]args){
        SOSCodepruefer s = new SOSCodepruefer();
        System.out.println(s.wortUntersuchen("#...---...#"));
        System.out.println(s.wortUntersuchen("##...---...##"));
        System.out.println(s.wortUntersuchen("........."));
    }
    
}
