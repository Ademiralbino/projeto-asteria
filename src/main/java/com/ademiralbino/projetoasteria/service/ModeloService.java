package com.ademiralbino.projetoasteria.service;

import com.ademiralbino.projetoasteria.dto.ModeloRequest;
import com.ademiralbino.projetoasteria.dto.ModeloResponse;
import com.ademiralbino.projetoasteria.entity.Booker;
import com.ademiralbino.projetoasteria.entity.Modelo;
import com.ademiralbino.projetoasteria.entity.Scouter;
import com.ademiralbino.projetoasteria.exception.RecursoNaoEncontradoException;
import com.ademiralbino.projetoasteria.repository.BookerRepository;
import com.ademiralbino.projetoasteria.repository.ModeloRepository;
import com.ademiralbino.projetoasteria.repository.ScouterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final BookerRepository bookerRepository;
    private final ScouterRepository scouterRepository;

    public ModeloService(
            ModeloRepository modeloRepository,
            BookerRepository bookerRepository,
            ScouterRepository scouterRepository
    ) {
        this.modeloRepository = modeloRepository;
        this.bookerRepository = bookerRepository;
        this.scouterRepository = scouterRepository;
    }

    @Transactional
    public ModeloResponse criar(ModeloRequest request) {

        Booker booker = bookerRepository.findById(request.bookerId())
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Booker não encontrado.")
                );

        Scouter scouter = null;

        if (request.scouterId() != null) {
            scouter = scouterRepository.findById(request.scouterId())
                    .orElseThrow(() ->
                            new RecursoNaoEncontradoException("Scouter não encontrado.")
                    );
        }

        Modelo modelo = Modelo.builder()
                .nome(request.nome())
                .nomeArtistico(request.nomeArtistico())
                .dataCadastro(request.dataCadastro())
                .status(request.status())
                .booker(booker)
                .scouter(scouter)
                .percentualComissao(request.percentualComissao())
                .telefone(request.telefone())
                .email(request.email())
                .foto(request.foto())
                .build();

        LocalDateTime agora = LocalDateTime.now();

        modelo.setCriadoEm(agora);
        modelo.setAtualizadoEm(agora);

        Modelo modeloSalvo = modeloRepository.save(modelo);

        return toResponse(modeloSalvo);
    }

    @Transactional(readOnly = true)
    public List<ModeloResponse> listar() {

        return modeloRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ModeloResponse buscarPorId(UUID id) {

        Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Modelo não encontrada.")
                );

        return toResponse(modelo);
    }

    @Transactional
    public ModeloResponse atualizar(UUID id, ModeloRequest request) {

        Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Modelo não encontrada.")
                );

        Booker booker = bookerRepository.findById(request.bookerId())
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Booker não encontrado.")
                );

        Scouter scouter = null;

        if (request.scouterId() != null) {
            scouter = scouterRepository.findById(request.scouterId())
                    .orElseThrow(() ->
                            new RecursoNaoEncontradoException("Scouter não encontrado.")
                    );
        }

        modelo.setNome(request.nome());
        modelo.setNomeArtistico(request.nomeArtistico());
        modelo.setDataCadastro(request.dataCadastro());
        modelo.setStatus(request.status());
        modelo.setBooker(booker);
        modelo.setScouter(scouter);
        modelo.setPercentualComissao(request.percentualComissao());
        modelo.setTelefone(request.telefone());
        modelo.setEmail(request.email());
        modelo.setFoto(request.foto());

        return toResponse(modeloRepository.save(modelo));
    }

    @Transactional
    public void excluir(UUID id) {

        if (!modeloRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Modelo não encontrada.");
        }

        modeloRepository.deleteById(id);
    }

    private ModeloResponse toResponse(Modelo modelo) {

        return new ModeloResponse(
                modelo.getId(),
                modelo.getNome(),
                modelo.getNomeArtistico(),
                modelo.getDataCadastro(),
                modelo.getStatus(),
                modelo.getBooker().getId(),
                modelo.getScouter() != null ? modelo.getScouter().getId() : null,
                modelo.getPercentualComissao(),
                modelo.getTelefone(),
                modelo.getEmail(),
                modelo.getFoto(),
                modelo.getCriadoEm(),
                modelo.getAtualizadoEm()
        );
    }
}