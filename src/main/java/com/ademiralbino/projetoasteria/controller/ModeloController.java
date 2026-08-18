package com.ademiralbino.projetoasteria.controller;

import com.ademiralbino.projetoasteria.dto.ModeloRequest;
import com.ademiralbino.projetoasteria.dto.ModeloResponse;
import com.ademiralbino.projetoasteria.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping
    public ResponseEntity<ModeloResponse> criar(
            @Valid @RequestBody ModeloRequest request
    ) {

        ModeloResponse response = modeloService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ModeloResponse>> listar() {

        return ResponseEntity.ok(
                modeloService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloResponse> buscarPorId(
            @PathVariable UUID id
    ) {

        return ResponseEntity.ok(
                modeloService.buscarPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloResponse> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody ModeloRequest request
    ) {

        return ResponseEntity.ok(
                modeloService.atualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable UUID id
    ) {

        modeloService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}