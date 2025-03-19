package com.boleto.apiBoleto.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

// o lombok cria automaticamente os getters e setters
import lombok.*;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDate;
@Entity
@Table(name = "boletos") //nome da tabela do banco de dados
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString // criando todos os getters e setters sem precisar
// dos construtores e converter para string
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pegando
    private Long id;

    @NotBlank(message="O banco não pode estar em branco") //validando se o campo está em branco e validando
    @Pattern(regexp = "\\d(3)", message="O código do banco deve conter 3 caracteres")
    private String Banco;

    @NotBlank(message = "Agência não pode estar em branco")
    @Pattern(regexp = "\\d{4}", message = "Agência deve possuir 4 digitos")
    private String agencia;

    @NotBlank(message = "A conta não pode estar em branco")
    @Pattern(regexp = "\\d{4}", message = "A conta deve possuir 4 digitos")
    private String conta;

    @NotBlank(message = "O código de barras do boleto não pode estar em branco")
    @Pattern(regexp = "\\d{5}\\.\\d{5} \\d{5}\\.\\d{6} \\d{5}\\.\\d{6} \\d \\d{14}",
        message = "Codigo de barras deve possuir o formato: 00000.00000.000000 ")
    private String codigoBarra;

    @NotNull(message = "O valor não deve ser nulo")
    @DecimalMin(value="0.01", message = "O valor minimo é: 1 centavos (0.01)")
    @DecimalMax(value="10.000", message = "O valor máximo é 10.000")
    private Double valor;

    @NotNull(message = "Essa data não pode ser nulo")
    @FutureOrPresent(message = "A data de vencimento deve ser a data atual ou futura")
    private LocalDate dataVencimento;

    @NotBlank(message = "O nome do Pagador não pode estar em branco")
    @Size(min = 10, max = 100, message = "O nome deve possuir entre dez e cem caracteres")
    private String nomePagador;

    @NotBlank(message = "O campo email não deve ser nulo")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "CPF não deve estar em branco")
    @Pattern(regexp = "\\d{11}", message = "O Campo CPF deve conter onze digitos ")
    private String cpf;

}
