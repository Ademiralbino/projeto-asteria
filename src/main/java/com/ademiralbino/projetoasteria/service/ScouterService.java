package com.ademiralbino.projetoasteria.service;

import com.ademiralbino.projetoasteria.dto.ScouterRequest;
import com.ademiralbino.projetoasteria.dto.ScouterResponse;
import com.ademiralbino.projetoasteria.entity.Scouter;
import com.ademiralbino.projetoasteria.exception.RecursoNaoEncontradoException;
import com.ademiralbino.projetoasteria.repository.ScouterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ScouterService {

    private final ScouterRepository scouterRepository;

    public ScouterService(ScouterRepository scouterRepository) {
        this.scouterRepository = scouterRepository;
    }

    @Transactional
    public ScouterResponse criar(ScouterRequest request) {

        Scouter scouter = Scouter.builder()
                .nome(request.nome())
                .telefone(request.telefone())
                .email(request.email())
                .build();

        Scouter scouterSalvo = scouterRepository.saveAndFlush(scouter);

        return toResponse(scouterSalvo);
    }

    @Transactional(readOnly = true)
    public List<ScouterResponse> listar() {

        return scouterRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ScouterResponse buscarPorId(UUID id) {

        Scouter scouter = scouterRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Scouter não encontrado.")
                );

        return toResponse(scouter);
    }

    @Transactional
    public ScouterResponse atualizar(UUID id, ScouterRequest request) {

        Scouter scouter = scouterRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Scouter não encontrado.")
                );

        scouter.setNome(request.nome());
        scouter.setTelefone(request.telefone());
        scouter.setEmail(request.email());

        Scouter scouterSalvo = scouterRepository.saveAndFlush(scouter);

        return toResponse(scouterSalvo);
    }

    @Transactional
    public void excluir(UUID id) {

        if (!scouterRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Scouter não encontrado.");
        }

        scouterRepository.deleteById(id);
    }

    private ScouterResponse toResponse(Scouter scouter) {

        return new ScouterResponse(
                scouter.getId(),
                scouter.getNome(),
                scouter.getTelefone(),
                scouter.getEmail(),
                scouter.getCriadoEm(),
                scouter.getAtualizadoEm()
        );
    }
}