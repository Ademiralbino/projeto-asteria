package com.ademiralbino.projetoasteria.controller;

import com.ademiralbino.projetoasteria.dto.ScouterRequest;
import com.ademiralbino.projetoasteria.dto.ScouterResponse;
import com.ademiralbino.projetoasteria.service.ScouterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/scouters")
public class ScouterController {

    private final ScouterService scouterService;

    public ScouterController(ScouterService scouterService) {
        this.scouterService = scouterService;
    }

    @PostMapping
    public ResponseEntity<ScouterResponse> criar(
            @Valid @RequestBody ScouterRequest request
    ) {

        ScouterResponse response = scouterService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ScouterResponse>> listar() {

        return ResponseEntity.ok(
                scouterService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScouterResponse> buscarPorId(
            @PathVariable UUID id
    ) {

        return ResponseEntity.ok(
                scouterService.buscarPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScouterResponse> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody ScouterRequest request
    ) {

        return ResponseEntity.ok(
                scouterService.atualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable UUID id
    ) {

        scouterService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}