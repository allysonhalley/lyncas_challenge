package com.lyncas.contas_a_pagar.domain.conta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public record ContaResponseDTO(

        @NotNull
        String id,
        @NotNull
        String dataVencimento,
        @NotNull
        BigDecimal valor,
        @NotBlank
        String descricao,
        @NotBlank
        String situacao
) {
        public ContaResponseDTO (Conta conta) {
                this(
                        conta.getId(),
                        conta.getDataVencimento().toString().formatted("dd/MM/yyyy"),
                        conta.getValor(),
                        conta.getDescricao(),
                        conta.getSituacao()
                );
        }

        public static Page<ContaResponseDTO> converterToDTO(Page<Conta> contas) {
                return contas.map(ContaResponseDTO::new);
        }

        public static Page<ContaResponseDTO> converterListToPageDTO(List<Conta> contas) {
                PageImpl<Conta> pageImpl = new PageImpl<>(contas);
                return pageImpl.map(ContaResponseDTO::new);
        }

        public static ContaResponseDTO converterContaToDTo(Conta conta) {
                return new ContaResponseDTO(conta);
        }
}
