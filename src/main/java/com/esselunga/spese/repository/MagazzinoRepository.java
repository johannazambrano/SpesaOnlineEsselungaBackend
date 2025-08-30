package com.esselunga.spese.repository;

import com.esselunga.spese.model.Magazzino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazzinoRepository extends JpaRepository<Magazzino, Long> {
}
