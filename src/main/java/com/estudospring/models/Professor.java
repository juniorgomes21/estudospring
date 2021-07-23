package com.estudospring.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    public String nome;
    public BigDecimal salario;
    @Enumerated(EnumType.STRING)
    @Column(name = "statusprofessor")
    public StatusProfessor statusProfessor;

    public Professor() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setStatusProfessor(StatusProfessor statusProfessor) {
        this.statusProfessor = statusProfessor;
    }

    public Long getId() {
        return id;
    }

    public String getNome(@NotBlank String nome) {
        return this.nome;
    }

    public BigDecimal getSalario(@NotNull @DecimalMin("0.0") BigDecimal salario) {
        return this.salario;
    }

    public StatusProfessor getStatusProfessor(StatusProfessor statusProfessor) {
        return this.statusProfessor;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                ", statusProfessor=" + statusProfessor +
                '}';
    }
}
