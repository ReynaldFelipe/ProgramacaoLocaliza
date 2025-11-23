package Projeto_Localiza.Interface;

import java.util.List;

public interface Crud<T> {
    void salvar(T obj);
    void atualizar(String id, T obj);
    void remover(String id);
    T buscar(String id);
    List<T> listar();
}
