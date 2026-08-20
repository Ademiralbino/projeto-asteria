package com.ademiralbino.projetoasteria.controller;

import com.ademiralbino.projetoasteria.dto.BookerRequest;
import com.ademiralbino.projetoasteria.dto.BookerResponse;
import com.ademiralbino.projetoasteria.service.BookerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookers")
public class BookerController {

    private final BookerService bookerService;

    public BookerController(BookerService bookerService) {
        this.bookerService = bookerService;
    }

    @PostMapping
    public ResponseEntity<BookerResponse> criar(
            @Valid @RequestBody BookerRequest request
    ) {

        BookerResponse response = bookerService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<BookerResponse>> listar() {

        return ResponseEntity.ok(
                bookerService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookerResponse> buscarPorId(
            @PathVariable UUID id
    ) {

        return ResponseEntity.ok(
                bookerService.buscarPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookerResponse> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody BookerRequest request
    ) {

        return ResponseEntity.ok(
                bookerService.atualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable UUID id
    ) {

        bookerService.excluir(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}