package com.ademiralbino.projetoasteria.controller;

import com.ademiralbino.projetoasteria.entity.Booker;
import com.ademiralbino.projetoasteria.service.BookerService;
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
    public ResponseEntity<Booker> criar(
            @RequestBody Booker booker
    ) {

        Booker salvo = bookerService.criar(booker);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salvo);
    }


    @GetMapping
    public ResponseEntity<List<Booker>> listar() {

        return ResponseEntity.ok(
                bookerService.listar()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<Booker> buscarPorId(
            @PathVariable UUID id
    ) {

        return ResponseEntity.ok(
                bookerService.buscarPorId(id)
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<Booker> atualizar(
            @PathVariable UUID id,
            @RequestBody Booker booker
    ) {

        return ResponseEntity.ok(
                bookerService.atualizar(id, booker)
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