package com.estudospring.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.estudospring.models.Professor;
import com.estudospring.models.StatusProfessor;

public class RequisicaoNovoProfessor {
	@NotBlank
    private String nome;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal salario;
    @NotNull
    private StatusProfessor statusProfessor;


    /* public RequisicaoNovoProfessor(
		@NotBlank String nome, 
		@DecimalMin("0.0") 
		BigDecimal salario,
		StatusProfessor statusProfessor) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.statusProfessor = statusProfessor;
	} */

    

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public BigDecimal getSalario() {
		return salario;
	}



	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}



	public StatusProfessor getStatusProfessor() {
		return statusProfessor;
	}



	public void setStatusProfessor(StatusProfessor statusProfessor) {
		this.statusProfessor = statusProfessor;
	}



	public Professor makeProfessor() {
		Professor professor = new Professor();
        professor.nome = this.nome;
        professor.salario = this.salario;
        professor.statusProfessor = this.statusProfessor;
        return professor;
    }

	public Professor makeProfessor(Professor professor) {
		professor.setNome(this.nome);
		professor.setSalario(this.salario);
		professor.setStatusProfessor(this.statusProfessor);

		return professor;
	}

	public void fromProfessor(Professor professor) {
		this.nome= professor.getNome(nome);
		this.salario = professor.getSalario(salario);
		this.statusProfessor = professor.getStatusProfessor(statusProfessor);

	}

}
