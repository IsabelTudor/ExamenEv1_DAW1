package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] arrayPalabras = new String[10];	//creo un array que me almacene 10 palabras distintas en 10 elementos
        arrayPalabras[0] = "java";
        arrayPalabras[1] = "eclipse";
        arrayPalabras[2] = "escuela";
        arrayPalabras[3] = "ordenador";
        arrayPalabras[4] = "hardware";
        arrayPalabras[5] = "piramide";
        arrayPalabras[6] = "instituto";
        arrayPalabras[7] = "numero";
        arrayPalabras[8] = "letra";
        arrayPalabras[9] = "examen";

        int fallosRestantes = 10;	//inicializo la cantidad de fallos restantes
        int aleatorio = (int) (Math.random()*(arrayPalabras.length));	//determina un numero aleatorio para asignarlo a una palabra (aleatoria)

        String[] letrasFallidas = new String[100];	//creo un array para almacenar las letras
        String[] letrasProbadas = new String[100];	//creo un array para almacenar las letras probadas
        String[] palabra = arrayPalabras[aleatorio].split("");	//creo un array para almacenar cada letra de la palabra escogida en un elemento de manera ordenada
        String[] palabraAuxiliar = new String[palabra.length];	//creo un array auxiliar para la palabra de la misma longitud para poder modificarlo y presentarlo por la consola

        for ( int i = 0; i < palabraAuxiliar.length; i++) {	//doy valor "_" a todos los elementos del array auxiliar

            palabraAuxiliar[i] = "_";

        }

        System.out.println("Bienvenido al juego del ahorcado, introduce una letra para empezar a jugar:");
        System.out.println();
        System.out.println(fallosRestantes + " fallos restantes para morir:");
        System.out.println();
        muestraPalabra(palabraAuxiliar);
        System.out.println();
        System.out.println("Letras fallidas:");
        System.out.println();
        System.out.println();


        int palabraCompleta = 0;	//inicializo un contador para trabajar con el bucle "while"
        int posicionRegistro = 0;	//inicializo otro contador para poder cambiar de elemento en los array
        Scanner escaner = new Scanner(System.in);

        while (palabraCompleta != palabra.length) {	//mientras la palabra no este completa sigue el bucle

            String letra = escaner.next();	//creo un String con el valor que introduce el usuario
            letrasProbadas[posicionRegistro] = letra;	//guardo la letra probada en el "almacen"

            int numeroletra = letra.charAt(0);

            if (fallosRestantes > 1) {	//mientras el usuario aun tenga fallos, podrá seguir probando

                boolean comprobador = true;	//creo un comprobador y lo inicializo como true

                for (int m = 0; m < palabra.length; m++) {	//creo un bucle para recorrer los elementos del array "palabra"

                    int numeroLetraPalabra = palabra[m].charAt(0);

                    if (numeroletra == numeroLetraPalabra) {	//comprueba si el caracter introducido por el usuario esta en algun elemento del array "palabra"

                        palabraAuxiliar[m] = letra;
                        palabraCompleta++;
                        comprobador = false;	//si algun elemento es igual cambia el valor del comprobador

                    }

                }

                if (comprobador) {	//si el comprobador no ha sido modificado cuenta como un "fallo por parte del usuario"

                    fallosRestantes--;	//aumenta los fallos
                    letrasFallidas[posicionRegistro] = letra;	//almacena el caracter introducidpo por el usuario en "letrasFallidas"

                }

                System.out.println(fallosRestantes + " fallos restantes para morir");
                System.out.println();
                muestraPalabra(palabraAuxiliar);
                System.out.println();
                System.out.print("Letras fallidas:");
                muestraLetras(letrasFallidas);
                System.out.println();
                System.out.println();

            }

            else {


                System.out.println();
                System.out.println();
                System.out.println("Has muerto, lo sentimos, pero no vales para este juego");
                System.out.println();
                System.out.print("Letras fallidas:");
                muestraLetras(letrasFallidas);
                System.out.print("Letras probadas:");
                muestraLetras(letrasProbadas);
                System.out.println();
                System.out.println();


            }

            posicionRegistro++;	//aumenta la posicion de registro para no "chafar" el valor anterior y guardar el actual

        }

        escaner.close();
        System.out.println();
        System.out.println();
        System.out.println("¡Lo has logrado, eres un fenomeno en este juego!");
        System.out.println();
        System.out.print("Letras fallidas:");
        muestraLetras(letrasFallidas);
        System.out.print("Letras probadas:");
        muestraLetras(letrasProbadas);
        System.out.println();
        System.out.println();

    }


    public static void muestraLetras(String[] palabra) {	//muestra las letras de los elementos de un array

        for ( int j = 0; j < palabra.length - 1; j++) {

            if (palabra[j] != null) {

                System.out.print(palabra[j] + " ");

            }

        }

        System.out.println();

    }


    public static void muestraPalabra(String[] palabra) {	//muestra los elementos de la palabra auxiliar (esta pensado para representar una palabra entera)

        for ( int j = 0; j < palabra.length - 1; j++) {

            System.out.print(palabra[j] + " ");

        }

        System.out.println(palabra[palabra.length - 1]);

    }

}

/*Ejercicio mas resumido en ->*/ https://youtu.be/Y9A9g35iDH4




