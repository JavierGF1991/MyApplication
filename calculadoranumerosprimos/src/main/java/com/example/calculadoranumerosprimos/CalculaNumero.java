package com.example.calculadoranumerosprimos;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class CalculaNumero {

    public CalculaNumero() {

    }

    public ArrayList<Integer> calcularPrimos(int numero) {
        //Los numeros primos ya calculados seran devueltos al MainActivity.java dentro de un Arraylist
        //Para que no sea necesario volver a calcularlos.
        ArrayList<Integer>numerosprimos=new ArrayList<Integer>();
        int cont = 0;
        int primomaximo = 1;
        int j = 0;
        while (numero + 1 != primomaximo) {
            j++;
            for (int i = 1; i <= j; i++) {
                if (j % i == 0) {
                    cont++;
                }
            }
            if (cont == 2 || j == 1) {
                primomaximo++;
                numerosprimos.add(j);
            }
            cont = 0;
        }
        return numerosprimos;
    }

}
