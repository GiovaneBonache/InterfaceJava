package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaSimples fila = new FilaSimples(10);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU DA FILA SIMPLES ===");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Inserir sequência");
            System.out.println("3 - Ordenar crescente");
            System.out.println("4 - Editar elemento");
            System.out.println("5 - Verificar se está cheia");
            System.out.println("6 - Buscar elemento");
            System.out.println("7 - Buscar elemento por índice");
            System.out.println("8 - Ver quantidade de elementos");
            System.out.println("9 - Remover primeiro elemento");
            System.out.println("10 - Obter primeiro elemento");
            System.out.println("11 - Obter último elemento");
            System.out.println("12 - Remover sequência");
            System.out.println("13 - Limpar fila");
            System.out.println("14 - Exibir fila");
            System.out.println("15 - Meu teste de Mesa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a inserir: ");
                    Object elemento = scanner.nextInt();
                    fila.inserirElemento(elemento);
                    break;

                case 2:
                    System.out.print("Quantos elementos deseja inserir? ");
                    int qtd = scanner.nextInt();
                    Object[] sequencia = new Object[qtd];
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        sequencia[i] = scanner.nextInt();
                    }
                    fila.inserirSequencia(sequencia);
                    break;

                case 3:
                    fila.ordenarCrescente();
                    System.out.println("Fila ordenada!");
                    break;

                case 4:
                    System.out.print("Elemento antigo: ");
                    Object antigo = scanner.nextInt();
                    System.out.print("Novo elemento: ");
                    Object novo = scanner.nextInt();
                    fila.editarElemento(antigo, novo);
                    break;

                case 5:
                    System.out.println("Fila cheia? " + fila.estaCheia());
                    break;

                case 6:
                    System.out.print("Elemento a buscar: ");
                    Object buscar = scanner.nextInt();
                    System.out.println("Encontrado? " + fila.buscarElemento(buscar));
                    break;

                case 7:
                    System.out.print("Índice: ");
                    int indice = scanner.nextInt();
                    try {
                        System.out.println("Elemento: " + fila.buscarElementoIndice(indice));
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 8:
                    System.out.println("Quantidade: " + fila.quantidadeElementos());
                    break;

                case 9:
                    fila.removerElemento();
                    System.out.println("Primeiro elemento removido.");
                    break;

                case 10:
                    System.out.println("Primeiro elemento: " + fila.obterPrimeiroElemento());
                    break;

                case 11:
                    System.out.println("Último elemento: " + fila.obterUltimoElemento());
                    break;

                case 12:
                    System.out.print("Quantos deseja remover? ");
                    int qtdRemover = scanner.nextInt();
                    Object[] removerSeq = new Object[qtdRemover];
                    for (int i = 0; i < qtdRemover; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        removerSeq[i] = scanner.nextInt();
                    }
                    fila.removerSequencia(removerSeq);
                    break;

                case 13:
                    fila.limpar();
                    System.out.println("Fila limpa.");
                    break;

                case 14:
                    fila.exibir();
                    break;

                case 15:
                    fila.limpar();
                    fila.inserirSequencia(new Object[]{1, 2, 3, 4, 5, 6});
                    System.out.println("\n Essa é a sequencia inicial");
                    fila.exibir();
                    fila.removerSequencia(new Object[]{2, 4, 6});
                    System.out.println("\n Essa é a nova sequencia");
                    fila.exibir();

                    fila.limpar();
                    fila.inserirSequencia(new Object[]{1, 2, 3, 4, 5, 6});
                    System.out.println("\n Essa é a sequencia inicial");
                    fila.exibir();
                    fila.removerSequencia(new Object[]{5,8,9});
                    System.out.println("\n Essa é a nova sequencia");
                    fila.exibir();
                    





                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}