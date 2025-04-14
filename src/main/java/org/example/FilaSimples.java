package org.example;

public class FilaSimples implements IEstruturaSimples {
    private Object[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public FilaSimples(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.elementos = new Object[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public FilaSimples() {
        this(10); // Capacidade padrão de 10
    }

    @Override
    public void inserirElemento(Object elemento) {
        if (estaCheia()) {
            dobrarCapacidade();
        }

        fim = (fim + 1) % capacidade;
        elementos[fim] = elemento;
        tamanho++;
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        // Não aplicável para fila (viola o princípio FIFO)
        throw new UnsupportedOperationException("Inserção por índice não suportada em fila");
    }

    @Override
    public void inserirSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            Object[] array = (Object[]) elementos;
            for (Object elemento : array) {
                inserirElemento(elemento);
            }
        } else {
            throw new IllegalArgumentException("O parâmetro deve ser um array de objetos");
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            return false;
        }

        elementos[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;

        return true;
    }

    @Override
    public Object removerIndice(int indice) {
        // Não aplicável para fila (viola o princípio FIFO)
        throw new UnsupportedOperationException("Remoção por índice não suportada em fila");
    }

    @Override
    public void removerSequencia(Object elementos) {
        // Não aplicável para fila (viola o princípio FIFO)
        throw new UnsupportedOperationException("Remoção de sequência não suportada em fila");
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        // Não aplicável para fila (viola o princípio FIFO)
        throw new UnsupportedOperationException("Remoção de ocorrências não suportada em fila");
    }

    @Override
    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % capacidade;
            if (elementos[index].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        return elementos[(inicio + indice) % capacidade];
    }

    @Override
    public void ordenarCrescente() {
        // Não aplicável para fila (viola o princípio FIFO)
        throw new UnsupportedOperationException("Ordenação não suportada em fila");
    }

    @Override
    public void ordenarDecrescente() {
        // Não aplicável para fila (viola o princípio FIFO)
        throw new UnsupportedOperationException("Ordenação não suportada em fila");
    }

    @Override
    public int quantidadeElementos() {
        return tamanho;
    }

    @Override
    public void dobrarCapacidade() {
        Object[] novoArray = new Object[capacidade * 2];

        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[(inicio + i) % capacidade];
        }

        elementos = novoArray;
        capacidade *= 2;
        inicio = 0;
        fim = tamanho - 1;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        // Não aplicável para fila (viola o princípio FIFO)
        throw new UnsupportedOperationException("Edição de elementos não suportada em fila");
    }

    @Override
    public void limpar() {
        elementos = new Object[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    @Override
    public void exibir() {
        System.out.print("Fila: [");
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % capacidade;
            System.out.print(elementos[index]);
            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()) {
            return null;
        }
        return elementos[inicio];
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) {
            return null;
        }
        return elementos[fim];
    }
}