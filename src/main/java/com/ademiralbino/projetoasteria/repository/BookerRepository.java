package com.ademiralbino.projetoasteria.repository;

import com.ademiralbino.projetoasteria.entity.Booker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookerRepository extends JpaRepository<Booker, UUID> {
}