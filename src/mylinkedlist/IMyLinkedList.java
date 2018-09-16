package mylinkedlist;

/**
 *
 * @author Sávio Andres
 * @param <T>
 */
public interface IMyLinkedList<T> extends Iterable<T> {
    public void adicionar(T elemento);
    public void adicionarNoInicio(T elemento);
    public void adicionar(int indice, T elemento);
    public void adicionarTodos(T... elementos);
    public T obter(int indice);
    public T remover(int indice);
    public boolean remover(T elemento);
    public void limpar();
    public int tamanho();
    public boolean contem(T elemento);
    public boolean ehVazio();
}
