package dao;

import model.Tarefa;
import java.util.ArrayList;

public class TarefaDao {
    public ArrayList<Tarefa> lista;

    public TarefaDao() {
        lista = new ArrayList<>();
    }

    public ArrayList<Tarefa> getLista() {
        return lista;
    }

    // Inserir
    public boolean inserirTarefa(Tarefa tarefa) {
        return lista.add(tarefa);
    }

    // Buscar por ID
    public Tarefa buscarPorId(int id) {
        for (Tarefa t : lista) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    // Atualizar substituindo tarefa existente
    public void atualizar(Tarefa tarefaAtualizada) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == tarefaAtualizada.getId()) {
                lista.set(i, tarefaAtualizada);
                return;
            }
        }
    }

    // Atualizar apenas o status (concluída ou não)
    public void atualizarStatus(Tarefa tarefa, boolean concluida) {
        for (Tarefa t : lista) {
            if (t.getId() == tarefa.getId()) {
                t.setConcluida(concluida);
                return;
            }
        }
    }
}
