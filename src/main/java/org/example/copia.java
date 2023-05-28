package org.example;

import java.util.Scanner;

public class copia {
    public static void main(String[] args) {
        String[] array_palabras=new String[3];
        String p1="hola";
        String p2="sol";
        String p3="dios";
        array_palabras[0]=p1;
        array_palabras[1]=p2;
        array_palabras[2]=p3;

        int intentosFallidos=10;

        int aleatorio=(int) (Math.random()* (array_palabras.length));
        String[] letrasFallidas=new String[100];
        String [] letrasProbadas=new String[100];

        String[] palabra=array_palabras[aleatorio].split("");
        String[] palabraAuxiliar=new String[palabra.length];

        for(int i=0;i< palabraAuxiliar.length;i++){
            palabraAuxiliar[i]="_";
        }
        System.out.println("Bienvenido al juego del ahorcado, introduce una letra para empezar a jugar:");
        System.out.println();
        System.out.println(intentosFallidos + " fallos restantes para morir:");
        System.out.println();
        muestraPalabra(palabraAuxiliar);

        int palabraCompleta=0;
        int posicionRegistro=0;
        Scanner sc=new Scanner(System.in);
        while(palabraCompleta!=palabra.length){
            String letra=sc.next();
            letrasProbadas[posicionRegistro]=letra;
            int numeroLetra=letra.charAt(0);
            if(intentosFallidos>1){
                boolean comprobador=true;
                for(int m=0;m<palabra.length;m++){
                    int numeroLetraPalabra=palabra[m].charAt(0);
                    if(numeroLetra==numeroLetraPalabra){
                        palabraAuxiliar[m]=letra;
                        palabraCompleta++;
                        comprobador=false;
                    }
                }
                if(comprobador){
                    intentosFallidos--;
                    letrasFallidas[posicionRegistro]=letra;
                }
                System.out.println(intentosFallidos + " fallos restantes para morir");
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

        sc.close();
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
