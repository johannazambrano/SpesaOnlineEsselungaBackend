package com.esselunga.spese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esselunga.spese.repository.SpesaRepository;
import com.esselunga.spese.model.Spesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/spese")
public class SpesaController {

    @Autowired
    private SpesaRepository spesaRepository;

    // 1. Endpoint per la creazione di una spesa
    @PostMapping
    public Spesa creaSpesa(@RequestBody Spesa spesa) {
        // Logica di validazione salvataggio
        spesa.setStato("In elaborazione");
        spesa.setDataCreazione(LocalDateTime.now());
        Spesa nuovaSpesa = spesaRepository.save(spesa);
        return new ResponseEntity<>(nuovaSpesa, HttpStatus.CREATED).getBody();
    }

    // 2. Endpoint per ottenere la lista di tutta la spesa
    @GetMapping
    public List<Spesa> getSpesa(@RequestParam(required=false) String stato,
                                @RequestParam(required=false) String ordinaPer){
         // TODO Logica per filtrre e ordinare
        // ...
        return spesaRepository.findAll();
    }

    // 3. Endpoint per la notifica di una spesa (solo per alcuni campi)
    @PutMapping("/{id}")
    public Spesa modificaSpesa(@PathVariable Long id, @RequestBody Spesa spesaModificata) {
        Spesa spesa = spesaRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Spesa non trovata"));

        // Logica per aggiornare solo i campi permessi (es. indirizzo di consegna)
        spesa.setLatConsegna(spesaModificata.getLatConsegna());
        spesa.setLonConsegna(spesaModificata.getLonConsegna());
        // altri campi eventualmente...

        return spesaRepository.save(spesa);

    }

    // 4. Endpoint per il calcolo del percorso (da implementare)

    @GetMapping("/percorso")
    public String calcolaPercorso() {
        // TODO: Implementare l'algoritmo per il calcolo del percorso
        return "Percorso calcolato";
    }

    /*
    @GetMapping("/percorso")
    public List<Coordinate> calcolaPercorso(){
        // 1. trova il magazzino (dal DB)
        // 2. trova le spese con stato "Pronta per la consegna"
        // 3. Implementa l'algoritmo del percorso (anche semplice)
        // 4. Costruisci la lista di coordinate (magazzino -> consegna -> magazzino)
        return percorsoCalcolato;
    }
     */

}
