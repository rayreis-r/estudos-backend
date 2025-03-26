package com.exemplo.fatura.fatura.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "faturas")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão não deve estar vazio")
    @Pattern(regexp = "\\d{16}", message="O numéro do cartão deve conter exatamente 16 dígitos")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não poderá ser vazio")
    @Size(min = 3, max = 100, message = "O nome do titular deve estar entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "O campo valor não poderá estar vazio")
    @DecimalMin(value = "10.00", message = "O valor minimo deve ser 10.00")
    @DecimalMax(value = "5000.00", message = "O valor máximo deve ser 5000.00")
    private Double valor;

    @NotNull(message = "A data do pagamento não pode estar vazia")
    @FutureOrPresent(message = "A data do pagamento deverá ser futura ou presente")
    private LocalDate dataPagamento;

    @NotBlank(message = "O campo e-mail não deve estar vazio")
    @Email(message = "O e-mail deve ser válido")
    private String emailContato;


    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
}
