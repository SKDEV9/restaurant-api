package com.sam.restaurant_api.service;

import com.sam.restaurant_api.model.Prato;
import com.sam.restaurant_api.repository.PratoRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CozinhaService {
    private final PratoRepository pratoRepository;

    public CozinhaService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public Prato salvarPrato(Prato prato) {
        return pratoRepository.save(prato);
    }


    public List<Prato> listarCardapio() {
        return pratoRepository.findAll();
    }

    public void deletarPrato(Long id) {
        // Primeiro, verifica se o prato NÃO existe
        if (!pratoRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Prato não encontrado!");
        }

        pratoRepository.deleteById(id);
    }

    public Prato atualizarPrato(Long id, Prato pratoAtualizado) {

        // O orElseThrow garante que se o prato não existir, ele dá erro.
        Prato pratoExistente = pratoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Prato não encontrado!"));

        pratoExistente.setNome(pratoAtualizado.getNome());
        pratoExistente.setDescricao(pratoAtualizado.getDescricao());
        pratoExistente.setPreco(pratoAtualizado.getPreco());

        return pratoRepository.save(pratoExistente);
    }

}
