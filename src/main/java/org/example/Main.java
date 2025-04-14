package org.example;
public class Main {
    public static void main(String[] args) {
        FilaSimples fila = new FilaSimples(10);

        System.out.println("=== TESTE DA FILA ===");

        fila.inserirElemento("A");
        fila.inserirElemento("B");
        fila.inserirElemento("C");
        fila.exibir();

        fila.inserirSequencia(new Object[]{"D", "E", "F"});
        System.out.println("\nApós redimensionamento automático:");
        fila.exibir();

        System.out.println("\nFila esta cheia? " + fila.estaCheia());

        System.out.println("\nTem o elemento A? " + fila.buscarElemento("A"));

        System.out.println("\nO elemento do indice 2 é: " + fila.buscarElementoIndice(1));

        System.out.println("\nNumeros atuais de elemntos na lista: " +  fila.quantidadeElementos());

        System.out.println("\nRemovendo o primeiro elemento da lista");
        fila.removerElemento();
        fila.exibir();
        System.out.println("\nTem o elemento A? " + fila.buscarElemento("A"));

        System.out.println("\nO atual primeiro elemento é: " + fila.obterPrimeiroElemento());

        System.out.println("\nO atual ultimo elemento é: " + fila.obterUltimoElemento());

        System.out.println("\nRemovendo elementos:");
        fila.limpar();
        fila.exibir();


        System.out.println("\nFila vazia? " + fila.estaVazia());

    }
}