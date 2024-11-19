package com.example.kanban.controller;

import com.example.kanban.model.TarefaModel;
import com.example.kanban.service.TarefaService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping()
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefaModel){
        return tarefaService.criarTarefa(tarefaModel);
    }

    @GetMapping()
    public List<TarefaModel> listarTarefas(){
        return tarefaService.listarTarefas();
    }

    @PutMapping("/{id}/move")
    public TarefaModel moverTarefa(@PathVariable("id") int id){
        return tarefaService.moverTarefa(id);
    }

    @PutMapping("/{id}")
    public TarefaModel alterarTarefa(@RequestBody TarefaModel tarefaModel,@PathVariable("id") int id){
        return  tarefaService.alterarTarefa(tarefaModel, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") int id){
        tarefaService.deletar(id);
    }



}
