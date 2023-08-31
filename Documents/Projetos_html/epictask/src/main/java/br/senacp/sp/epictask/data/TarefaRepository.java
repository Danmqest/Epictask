package br.senacp.sp.epictask.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senacp.sp.epictask.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}
