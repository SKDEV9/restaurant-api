package com.sam.restaurant_api.controller;

import com.sam.restaurant_api.dto.PratoRequestDTO;
import com.sam.restaurant_api.model.Prato;
import com.sam.restaurant_api.service.CozinhaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")   // rota base para todos os métodos
public class CardapioController {

    private final CozinhaService cozinhaService;

    public CardapioController(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }

    @GetMapping
    public ResponseEntity<List<Prato>> exibirCardapio() {
        return ResponseEntity.ok(cozinhaService.listarCardapio());
    }

    @PostMapping
    public ResponseEntity<Prato> adicionarPrato(@Valid @RequestBody PratoRequestDTO dto) {
        Prato pratoSalvo = cozinhaService.salvarPrato(dto.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED).body(pratoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPrato(@PathVariable Long id) {
        cozinhaService.deletarPrato(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prato> atualizacaoPrato(@Valid @PathVariable Long id, @RequestBody PratoRequestDTO dto) {
        Prato pratoAtualizado = cozinhaService.atualizarPrato(id, dto.toEntity());

        return ResponseEntity.ok(pratoAtualizado);
    }
}
