package com.example.kanban.service;

import com.example.kanban.model.TarefaModel;
import com.example.kanban.model.enuns.Status;
import com.example.kanban.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModel criarTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    public List<TarefaModel> listarTarefas() {
        List<TarefaModel> listaGeral = new ArrayList<>();

        listaGeral.addAll(tarefaRepository.findAllByStatus(Status.A_FAZER));
        listaGeral.addAll(tarefaRepository.findAllByStatus(Status.EM_ANDAMENTO));
        listaGeral.addAll(tarefaRepository.findAllByStatus(Status.FINALIZADO));

        return listaGeral;
    }

    public TarefaModel moverTarefa(int id) {
         TarefaModel tarefa = findById(id);

        if (tarefa.getStatus() == Status.A_FAZER){
            tarefa.setStatus(Status.EM_ANDAMENTO);
        } else if(tarefa.getStatus() == Status.EM_ANDAMENTO){
            tarefa.setStatus(Status.FINALIZADO);
        }

        return tarefaRepository.save(tarefa);
    }

    public TarefaModel alterarTarefa(TarefaModel tarefaModel, int id) {
        TarefaModel tarefa = findById(id);

        tarefa.setTitulo(tarefaModel.getTitulo());
        tarefa.setDesc(tarefaModel.getDesc());
        tarefa.setDataFim(tarefaModel.getDataFim());
        tarefa.setPrioridade(tarefaModel.getPrioridade());

        return tarefaRepository.save(tarefa);
    }

    public void deletar (int id) {
        TarefaModel tarefa = findById(id);

        tarefaRepository.delete(tarefa);
    }

    private TarefaModel findById(int id) {
        Optional<TarefaModel> tarefaViva = this.tarefaRepository.findById(id);

        if(tarefaViva.isEmpty()) {
            System.out.println("Tarefa não encontrada");
        }

        return tarefaViva.get();
    }
}