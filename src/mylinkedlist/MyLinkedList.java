package mylinkedlist;

import java.util.Iterator;

/**
 *
 * @author Sávio Andres
 * @param <T>
 */
public class MyLinkedList<T> implements IMyLinkedList<T> {

    private No<T> inicio, fim;
    private int tamanho;

    @Override
    public void adicionar(T elemento) {
        No<T> node = new No<>();
        node.setElemento(elemento);
        if (this.inicio == null) {
            this.inicio = this.fim = node;
        } else {
            this.fim.setProximo(node);
            node.setAnterior(this.fim);
            this.fim = node;
            this.fim.setProximo(null);
        }
        this.tamanho++;
    }

    @Override
    public void adicionarNoInicio(T elemento) {
        No<T> node = new No<>();
        node.setElemento(elemento);
        if (this.tamanho == 0) {
            this.inicio = this.fim = node;
            this.tamanho++;
        } else {
            node.setProximo(this.inicio);
            node.setAnterior(null);
            this.inicio.setAnterior(node);
            this.inicio = node;
            this.tamanho++;
        }
    }

    @Override
    public void adicionar(int indice, T elemento) {
        No<T> no, temp, node = new No<>();
        node.setElemento(elemento);
        double aux = this.tamanho / 2;

        if (indice < 0) {
            throw new NullPointerException("Índice invalido");
        } else if (indice == this.tamanho) {
            adicionar(elemento);
        } else if (indice == 0) {
            adicionarNoInicio(elemento);
        } else {
            if (aux >= indice) {
                no = this.inicio;
                for (int i = 0; i < indice - 1; i++) {
                    no = no.getProximo();
                }
                temp = no.getProximo();
                no.setProximo(node);
                node.setProximo(temp);
                node.setAnterior(no);
                temp.setAnterior(node);
                this.tamanho++;
            } else {
                no = this.fim;
                for (int i = this.tamanho - 1; i > indice; i--) {
                    no = no.getAnterior();
                }
                temp = no.getAnterior();
                temp.setProximo(node);
                node.setProximo(no);
                no.setAnterior(node);
                node.setAnterior(temp);
                this.tamanho++;
            }
        }
    }

    @Override
    public void adicionarTodos(T... elementos) {
        for (T elemento : elementos) {
            this.adicionar(elemento);
        }
    }

    @Override
    public T obter(int indice) {
        No<T> node = new No<>();
        if (this.tamanho == 0) {
            throw new NullPointerException("Não há elemento");
        } else if (indice < 0 || indice > this.tamanho - 1) {
            throw new NullPointerException("Índice inválido");
        } else if (indice == 0) {
            return this.inicio.getElemento();
        } else if (indice == this.tamanho - 1) {
            return this.fim.getElemento();
        } else {
            node = this.inicio;
            for (int i = 0; i < indice; i++) {
                node = node.getProximo();
            }
        }
        return node.getElemento();
    }

    private int obter(T elemento) {
        No<T> node = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            if (node.getElemento().equals(elemento)) {
                return i;
            } else {
                node = node.getProximo();
            }
        }
        return -1;
    }

    @Override
    public T remover(int indice) {
        No node;
        T elemento = obter(indice);

        if (this.tamanho == 0 || indice < 0) {
            throw new NullPointerException("Índice inválido");
        } else if (indice == 0) {
            removerNoInicio();
        } else if (indice == this.tamanho - 1) {
            removerNoFim();
        } else {
            if (this.tamanho / 2 >= indice) {
                node = this.inicio;
                for (int i = 0; i < indice; i++) {
                    node = node.getProximo();
                }
            } else {
                node = this.fim;
                for (int i = this.tamanho - 1; i > indice; i--) {
                    node = node.getAnterior();
                }
            }
            node.getAnterior().setProximo(node.getProximo());
            node.getProximo().setAnterior(node.getAnterior());

            this.tamanho--;
        }
        return elemento;
    }

    @Override
    public boolean remover(T elemento) {
        int indice = obter(elemento);
        if (indice != -1) {
            remover(indice);
            return true;
        }
        return false;
    }

    private void removerNoInicio() {
        if (this.tamanho == 1) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(null);
        }
        this.tamanho--;
    }

    private void removerNoFim() {
        No<T> node;
        node = this.fim.getAnterior();
        this.fim.setElemento(null);
        this.fim = node;
        this.fim.setProximo(null);
        this.tamanho--;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean contem(T elemento) {
        return obter(elemento) != -1;
    }

    @Override
    public boolean ehVazio() {
        return this.inicio == null;
    }

    @Override
    public String toString() {
        if (this.tamanho != 0) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < this.tamanho - 1; i++) {
                str.append(obter(i)).append(", ");
            }
            return "[" + str.toString() + obter(tamanho - 1) + "]";
        } else {
            return "[]";
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaEncadeada();
    }

    private class IteradorListaEncadeada implements Iterator<T> {

        private No<T> proximo;

        public IteradorListaEncadeada() {
            this.proximo = inicio;
        }

        @Override
        public boolean hasNext() {
            return proximo != null;
        }

        @Override
        public T next() {
            T elemento = this.proximo.getElemento();
            this.proximo = this.proximo.getProximo();
            return elemento;
        }

    }

}
