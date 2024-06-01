/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paraulogic;

import java.util.Iterator;

/**
 *
 * @author carlo
 */
public class UnsortedArraySet<E> {

    //VARIABLES
    private E[] array;
    private int n;

    //MÉTODO QUE NOS DEVUELVE UN OBJETO DE TIPO <IteratorUnsortedArraySetz>
    public Iterator iterator() {
        Iterator it = new IteratorUnsortedArraySet();
        return it;
    }

    //CLASE ITERADOR
    private class IteratorUnsortedArraySet implements Iterator {

        //VARIABLES
        private int idxIterator;

        //CONSTRUCTOR
        private IteratorUnsortedArraySet() {
            idxIterator = 0;
        }

        //MÉTODOS
        @Override
        public boolean hasNext() {
            return idxIterator < n;
        }

        @Override
        public Object next() {
            idxIterator++;
            return array[idxIterator - 1];
        }

    }

    //CONSTRUCTOR < Reserva memòria per un array de longitud max i inicialitza n a 0 >
    public UnsortedArraySet(int max) {
        array = (E[]) new Object[max];
        //n = 1;
        n = 7;
    }

    //MÉTODOS
    // O(n): cerca lineal
    public boolean contains(E elem) {
        boolean b = false;
        while (iterator().hasNext()) {
            if (iterator().next().equals(elem)) {
                b = true;
                break; //no hem de seguir mirant més
            }
        }
        return b;
    }

    // O(n): abans d’afegir, ha de comprovar que la clau no existeix dins el conjunt (cerca lineal)
    public boolean add(E elem) {
        return !(contains(elem));
    }

    // O(n): cal cercar la clau dins el conjunt (cerca lineal) i el darrer element ha de situar-se a la posició alliberada
    public boolean remove(E elem) {
        boolean b = false;
        E darrerElem = array[n - 1];
        for (int i = 0; i < n; i++) {
            if (array[i] == elem) {
                array[i] = darrerElem; //situam el darrer element on l'element eliminat
                array[n - 1] = (E) ""; //buidam el contingut de la darrera posició
                b = true;
                break;
            }
        }
        return b; //si b = false ____> < L'element a eliminar no es troba a la llista >
    }

    // O(1)
    public boolean isEmpty() {
        return n == 0;
    }

}
