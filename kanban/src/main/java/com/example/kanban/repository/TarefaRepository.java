package com.example.kanban.repository;

import com.example.kanban.model.TarefaModel;
import com.example.kanban.model.enuns.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository <TarefaModel, Integer> {

    List<TarefaModel> findAllByStatus(Status status);

}
