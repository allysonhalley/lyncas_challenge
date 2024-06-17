package com.lyncas.contas_a_pagar.domain.conta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @DateTimeFormat
    private LocalDate dataVencimento;

    @DateTimeFormat
    private LocalDate dataPagamento;

    @NumberFormat
    private BigDecimal valor;

    private String descricao;

    private String situacao;

    public Conta(LocalDate dataVencimento, LocalDate dataPagamento, BigDecimal valor, String descricao, String situacao) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.descricao = descricao;
        this.situacao = situacao;
    }
    public Conta(LocalDate dataVencimento, BigDecimal valor, String descricao, String situacao) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.descricao = descricao;
        this.situacao = situacao;
    }
}
