package com.rentcar.parcial_1_02N.validador;

public class TelefonoPerfectoValidador {

    //Determina si el número de teléfono corresponde a un número perfecto
    public static boolean esNumeroPerfecto(long numero){

        //Los números que son menores o iguales a 1 no son perfectos
        if (numero <= 1){

            return false;
        }

        long sumaDivisores = 1;

        //Busca los divisores del número
        for (long i = 2; i * i <= numero; i++){

            if (numero % i == 0){

                sumaDivisores = sumaDivisores + i;

                long otroDivisor = numero / i;

                //Evita sumar dos veces un mismo divisor
                if (otroDivisor != i){

                    sumaDivisores = sumaDivisores + otroDivisor;
                }
            }
        }

        //Compara la suma de los dividores propios con el número
        return sumaDivisores == numero;
    }
}
