package com.estudospring.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.estudospring.models.Professor;
import com.estudospring.models.StatusProfessor;

public class RequisicaoNovoProfessor {
	@NonNull
	@NotBlank
    private String nome;
    @DecimalMin("0.0")
    @NonNull
    private BigDecimal salario;
    private StatusProfessor statusProfessor;
    //    private Professor professor;


    public RequisicaoNovoProfessor(@NotBlank String nome, @DecimalMin("0.0") BigDecimal salario,
			StatusProfessor statusProfessor) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.statusProfessor = statusProfessor;
	}



	public Professor makeProfessor() {
		Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);

        return professor;
    }


}
