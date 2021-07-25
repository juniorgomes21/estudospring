package com.estudospring.controlles;


import com.estudospring.dto.RequisicaoNovoProfessor;
import com.estudospring.models.Professor;
import com.estudospring.models.StatusProfessor;
import com.estudospring.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepositories;
//    java.util.

    @GetMapping("/professores")
    public ModelAndView index() {
        List<Professor> professores = this.professorRepositories.findAll();
        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professors", professores);

        return mv;
    }

    @GetMapping("/novoprofessor")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("professores/novoprofessor");
        mv.addObject("statusProfessor", StatusProfessor.values());

        return mv;
    }

 
    @PostMapping("/professores")
    public ModelAndView create(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            System.out.println("\n\n\n\n\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Entrou no if");
            ModelAndView mv = new ModelAndView("professores/novoprofessor");
            mv.addObject("listaStatusProfessor", StatusProfessor.values());

            return mv;
        }
        else {
            Professor professor = requisicao.makeProfessor();
            System.out.println(professor.toString());
            this.professorRepositories.save(professor);

            return new ModelAndView("redirect:/professores");
        }
    }

}
