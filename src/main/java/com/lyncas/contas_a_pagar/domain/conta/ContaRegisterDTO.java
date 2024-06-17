package com.lyncas.contas_a_pagar.domain.conta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record ContaRegisterDTO(

        @NotBlank
        String dataVencimento,
        String dataPagamento,
        @NotNull
        BigDecimal valor,
        @NotBlank
        String descricao,
        @NotBlank
        String situacao
){
        public static Conta convertoToConta(ContaRegisterDTO dto){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return new Conta(
                        LocalDate.parse(dto.dataVencimento().toString(), formatter),
                        dto.valor(),
                        dto.descricao(),
                        dto.situacao()
                );
        }
}
