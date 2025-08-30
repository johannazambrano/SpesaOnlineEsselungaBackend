package com.esselunga.spese;

import com.esselunga.spese.model.Magazzino;
import com.esselunga.spese.model.Spesa;
import com.esselunga.spese.repository.SpesaRepository;
import org.springframework.boot.CommandLineRunner;
import com.esselunga.spese.repository.MagazzinoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component // Importante: questa annotazione permette che Spring riconosca la classe
public class DatabasePopulator implements CommandLineRunner {

    private final MagazzinoRepository magazzinoRepository;
    private final SpesaRepository spesaRepository;

    public DatabasePopulator(MagazzinoRepository magazzinoRepository, SpesaRepository spesaRepository) {
        this.magazzinoRepository = magazzinoRepository;
        this.spesaRepository = spesaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // popolamento del database

        // 1. Inserimento di un magazzino
        Magazzino magazzino = new Magazzino();
        magazzino.setNome("Magazzino di Lucca");
        magazzino.setLat(45.4642);
        magazzino.setLon(9.1900);
        magazzinoRepository.save(magazzino);
        System.out.println("Magazzino salvato:" + magazzino);

        // 2. Inserimento di alcune spese
        Spesa spesa1 = new Spesa();
        spesa1.setLatConsegna(45.4740);
        spesa1.setLonConsegna(9.1849);
        spesa1.setArticoli(Arrays.asList("pane", "latte"));
        spesa1.setStato("In elaborazione");
        spesa1.setDataCreazione(LocalDateTime.now());
        spesaRepository.save(spesa1);

        Spesa spesa2 = new Spesa();
        spesa2.setLatConsegna(45.4740);
        spesa2.setLonConsegna(9.1849);
        spesa2.setArticoli(Arrays.asList("pane", "latte"));
        spesa2.setStato("In elaborazione");
        spesa2.setDataCreazione(LocalDateTime.now());
        spesaRepository.save(spesa2);

        System.out.println("Spese di esempio salvate");
    }
}
