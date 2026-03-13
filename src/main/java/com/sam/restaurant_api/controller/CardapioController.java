package com.sam.restaurant_api.controller;

import com.sam.restaurant_api.model.Prato;
import com.sam.restaurant_api.service.CozinhaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardapioController {
    private final CozinhaService cozinhaService;

    public CardapioController(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }

    @GetMapping("/cardapio")
    public List<Prato> exibirCardapio() {
        return cozinhaService.listarCardapio();
    }

    @PostMapping("/cardapio")
    public Prato adicionarPrato(@Valid @RequestBody Prato novoPrato) {
        return cozinhaService.salvarPrato(novoPrato);
    }

    @DeleteMapping("/cardapio/{id}")
    public void removerPrato(@PathVariable Long id) {
        cozinhaService.deletarPrato(id);
    }

    @PutMapping("/cardapio/{id}")
    public Prato atualizacaoPrato(@Valid @PathVariable Long id, @RequestBody Prato pratoAtualizado) {
        return cozinhaService.atualizarPrato(id, pratoAtualizado);
    }
}
