package teste.Aula1;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        int contador = 0;
        boolean condicao = true;
        while (condicao == true) {
            contador = contador + 1;
            System.out.println(contador);
            if (contador >= 10) {
                System.out.println("Contador está no seu limite.");
                break;
            }
        }

        for (int numero = 0; numero <= 10; numero++) {
            System.out.println(numero);
        }

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elias");
        lista.add("Gabriel");
        lista.add("Ítalo");

        for (String objeto : lista) {
            System.out.println(objeto);
            if (objeto == "Gabriel") {
                System.out.println("O objeto é igual à Gabriel");
                break;
            }
        }

        /*
         * String texto = "O número é: "; int numero = 12; double numeroDecimal = 10.5;
         * //Printando algo no console System.out.println(texto + numero);
         * System.out.println(numero / 2); System.out.println(numeroDecimal); boolean
         * souAdulto = true; System.out.println(souAdulto); if(!souAdulto) {
         * System.out.println("Não sou adulto."); }else {
         * System.out.println("Sou adulto."); }
         *
         * if(numero == 10) { System.out.println("O número é igual à 10."); }else
         * if(numero == 11) { System.out.println("O número é igual à 11."); }else
         * if(numero == 12) { System.out.println("O número é igual à 12."); }else {
         * System.out.println("O número não é igual a 10, nem 11 e nem 12."); }
         *
         * /*if(souAdulto == false) { System.out.println("Não sou adulto."); }else {
         * System.out.println("Sou adulto."); }
         * 
         * if(numero == 10) { System.out.println("é igual a 10"); }else if (numero ==
         * 11) { System.out.println("é igual a 11"); }else if (numero == 12) {
         * System.out.println("é igual a 12"); }else {
         * System.out.println("nao é igual 10, 11 ou 12"); }
         */

        somar();
    }

    public static void somar() {
        int numero = 1;
        int numero2 = 4;

        int soma = numero + numero2;
        System.out.println("Resultado: " + soma);
    }

}