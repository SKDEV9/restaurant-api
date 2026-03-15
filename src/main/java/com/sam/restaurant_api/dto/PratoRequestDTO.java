package com.sam.restaurant_api.dto;

import com.sam.restaurant_api.model.Prato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PratoRequestDTO(
        @NotBlank(message = "O nome do prato não pode estar vazio!")
        String nome,

        String descricao,

        @NotNull(message = "O preço é obrigatório!")
        @Positive(message = "O preço deve ser maior que zero!")
        Double preco
) {

        // Método utilitário para converter este DTO na Entidade que o banco entende
        public Prato toEntity() {
                Prato prato = new Prato();
                prato.setNome(this.nome());
                prato.setDescricao(this.descricao());
                prato.setPreco(this.preco());
                return prato;
        }
}
