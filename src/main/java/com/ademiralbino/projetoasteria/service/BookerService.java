package com.ademiralbino.projetoasteria.service;

import com.ademiralbino.projetoasteria.dto.BookerRequest;
import com.ademiralbino.projetoasteria.dto.BookerResponse;
import com.ademiralbino.projetoasteria.entity.Booker;
import com.ademiralbino.projetoasteria.repository.BookerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ademiralbino.projetoasteria.exception.RecursoNaoEncontradoException;
import java.util.List;
import java.util.UUID;

@Service
public class BookerService {

    private final BookerRepository bookerRepository;

    public BookerService(BookerRepository bookerRepository) {
        this.bookerRepository = bookerRepository;
    }

    @Transactional
    public BookerResponse criar(BookerRequest request) {

        Booker booker = Booker.builder()
                .nome(request.nome())
                .telefone(request.telefone())
                .email(request.email())
                .build();

        Booker bookerSalvo = bookerRepository.saveAndFlush(booker);

        return toResponse(bookerSalvo);
    }

    @Transactional(readOnly = true)
    public List<BookerResponse> listar() {

        return bookerRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public BookerResponse buscarPorId(UUID id) {

        Booker booker = bookerRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Booker não encontrado.")
                );

        return toResponse(booker);
    }

    @Transactional
    public BookerResponse atualizar(UUID id, BookerRequest request) {

        Booker booker = bookerRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Booker não encontrado.")
                );

        booker.setNome(request.nome());
        booker.setTelefone(request.telefone());
        booker.setEmail(request.email());

        Booker bookerSalvo = bookerRepository.saveAndFlush(booker);

        return toResponse(bookerSalvo);
    }

    @Transactional
    public void excluir(UUID id) {

        if (!bookerRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Booker não encontrado.");
        }

        bookerRepository.deleteById(id);
    }

    private BookerResponse toResponse(Booker booker) {

        return new BookerResponse(
                booker.getId(),
                booker.getNome(),
                booker.getTelefone(),
                booker.getEmail(),
                booker.getCriadoEm(),
                booker.getAtualizadoEm()
        );
    }
}