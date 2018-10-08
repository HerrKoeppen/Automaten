package dka;

import java.util.ArrayList;

/**
 * Ein Stack oder Stapel ist eine abstrakte Datenstruktur, die Elemente
 * aufbewahrt. Ein Stack fügt neue Elemente immer ganz vorne ein. Wenn ein
 * Element zurückgeliefert wird, dann wird es ganz vorne entnommen. Dieses
 * Prinzip nennt sich LIFO (last in first out).
 *
 * Die zugrundeliegende Struktur kann unter anderem ein Array, eine Liste oder
 * eine ArrayList sein.
 *
 * Unser Stack soll diese Methoden zur Verfügung stellen: push: Fügt ein neues
 * Element vorne in den Stapel ein pop: Entfernt das vorderste Listenelement aus
 * der Datenstruktur und liefert es zurück top: Zeigt das vorderste Element an,
 * ohne es aus der Datenstruktur zu löschen isEmpty: Zeigt an, ob der Stapel
 * leer ist
 *
 * Der Stapel kennt zwei Attribute: Eine ArrayList stapel, die die Element
 * ablegt Eine Zahl indexVorderstesElement, welche der Index des vordersten
 * Eintrags ist
 *
 * @author Bobjwa
 */
public class BessererStackBobjwa {

    private ArrayList<String> stapel;
    private int indexVorderstesElement;

    public BessererStackBobjwa() {
        indexVorderstesElement = 0;
        stapel = new ArrayList();
    }

    

    /**
     * Fügt das Element s in den Stapel ein
     *
     * @param s das einzufügende Element
     */
    public void push(String s) {
        indexVorderstesElement++;
        stapel.add(s);
    }

    /**
     * Entfernt das vorderste Element aus der Datenstruktur und gibt es zurück.
     *
     * @return ein String als vorderstes Element oder null, wenn es keine
     * Elemente im Stapel gibt
     */
    public String pop() {
        if(indexVorderstesElement > 0){
            String s = stapel.get(indexVorderstesElement - 1);
            stapel.remove(indexVorderstesElement -1);
            indexVorderstesElement--;
            return s;
        }
        
        return null;
    }

    /**
     * Zeigt das vorderste Element aus der Datenstruktur an. Das Element wird
     * nicht entfern, es ist weiterhin das vorderste Element.
     *
     * @return ein String als vorderstes Element oder null, wenn es keine
     * Elemente im Stapel gibt
     */
    public String top() {
       if(indexVorderstesElement > 0) return stapel.get(indexVorderstesElement -1);
       return null;
    }

    /**
     * Zeigt an, ob der Stapel leer ist.
     *
     * @return true, wenn der Stapel kein Element enthält, sonst false
     */
    public boolean isEmpty() {
        return indexVorderstesElement <= 0;
    }
    
    /**
     * Super tolle Funktion, die sehr wichtig ist
     */
    public void kaputtMachen(){
        stapel.removeAll(stapel);
        indexVorderstesElement = 666;
    }
    
    public static void kellerOperation(BessererStackBobjwa k,String op, String e){
        switch(op){
            case "push":{
                System.out.println("Keller: push('" + e + "')");
                k.push(e);
                break;
            }
        }
    }
    
    public static void kellerOperation(BessererStackBobjwa k,String op){
        switch(op){
            case "pop":{
                System.out.println("Keller: pop()");
                System.out.println(k.pop());
                break;
            }
            case "top":{
                System.out.println("Keller: top()");
                System.out.println(k.top());
                break;
            }
            case "isEmpty":{
                System.out.println("Keller: isEmpty()");
                System.out.println(k.isEmpty());
                break;
            }
            case "kaputtMachen":{
                System.out.println("Keller: kaputtMachen()");
                k.kaputtMachen();
                break;
            }
            
        }
    }
    
    public static void main(String[] args){
        BessererStackBobjwa keller = new BessererStackBobjwa();
        kellerOperation(keller,"push","Hallo");
        kellerOperation(keller,"push","Haus");
        kellerOperation(keller,"pop");
        kellerOperation(keller,"top");
        kellerOperation(keller,"isEmpty");
        kellerOperation(keller,"pop");
        kellerOperation(keller,"pop");
        kellerOperation(keller,"isEmpty");
        kellerOperation(keller,"top");
    }
    
}
