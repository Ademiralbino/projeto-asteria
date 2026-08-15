package com.ademiralbino.projetoasteria.repository;

import com.ademiralbino.projetoasteria.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModeloRepository extends JpaRepository<Modelo, UUID> {
}