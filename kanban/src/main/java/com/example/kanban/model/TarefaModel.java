package com.example.kanban.model;

import com.example.kanban.model.enuns.Prioridade;
import com.example.kanban.model.enuns.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Tarefa")
@Table(name = "tarefas")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String desc;
    private LocalDate dataInicio = LocalDate.now();
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private Status status = Status.A_FAZER;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    public TarefaModel() {
    }

    public TarefaModel(int id, String titulo, String desc, LocalDate dataFim, Prioridade prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.desc = desc;
        this.dataInicio = LocalDate.now();
        this.dataFim = dataFim;
        this.status = Status.A_FAZER;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}