package com.esselunga.spese.repository;

import com.esselunga.spese.model.Magazzino;
import com.esselunga.spese.model.Spesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpesaRepository extends JpaRepository<Spesa, Long> {
}
