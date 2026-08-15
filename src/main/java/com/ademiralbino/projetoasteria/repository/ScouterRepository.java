package com.ademiralbino.projetoasteria.repository;

import com.ademiralbino.projetoasteria.entity.Scouter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScouterRepository extends JpaRepository<Scouter, UUID> {
}