package br.senacp.sp.epictask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senacp.sp.epictask.data.TarefaRepository;
import br.senacp.sp.epictask.model.Tarefa;
import lombok.Delegate;

@Controller
public class TarefaController {

@Autowired
TarefaRepository repository;
    //localhost/tarefas
    @GetMapping("/tarefas")
    public String tarefas(Model model){
        var tarefas = repository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "tarefas";
    }

    @GetMapping("tarefas/cadastrar")
    public String formulario(){
        return "formulario_tarefa";
    }

    @GetMapping("/")
    public String Home(){
        return "redirect:/tarefas";
    }

    @PostMapping("/tarefas")
    public String cadastrar(Tarefa tarefa){
        repository.save(tarefa);
        return "redirect:/tarefas";
    }

    @DeleteMapping("/tarefas")
    public String apagar (Long id, RedirectAttributes redirect){
        repository.deleteById(id);
        redirect.addFlashAttribute("mensagem", "Tarefa apagada com sucesso");
        return "redirect:/tarefas";
    }
}
