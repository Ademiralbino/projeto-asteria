package com.ademiralbino.projetoasteria.service;
import com.ademiralbino.projetoasteria.exception.RecursoNaoEncontradoException;

import com.ademiralbino.projetoasteria.entity.Booker;
import com.ademiralbino.projetoasteria.repository.BookerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BookerService {

    private final BookerRepository bookerRepository;

    public BookerService(BookerRepository bookerRepository) {
        this.bookerRepository = bookerRepository;
    }

    @Transactional
    public Booker criar(Booker booker) {
        return bookerRepository.save(booker);
    }

    @Transactional(readOnly = true)
    public List<Booker> listar() {
        return bookerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Booker buscarPorId(UUID id) {
        return bookerRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Booker não encontrado."));
    }

    @Transactional
    public Booker atualizar(UUID id, Booker dados) {

        Booker booker = bookerRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Booker não encontrado."));

        booker.setNome(dados.getNome());
        booker.setTelefone(dados.getTelefone());
        booker.setEmail(dados.getEmail());

        return bookerRepository.save(booker);
    }

    @Transactional
    public void excluir(UUID id) {

        if (!bookerRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Booker não encontrado.");
        }

        bookerRepository.deleteById(id);
    }
}