package com.individual.ninah;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/triagens")
public class TriagemController {
    private final JdbcTemplate jdbcTemplate;

    public TriagemController (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Triagem>> listarTriagens() {
        String sql = "SELECT * FROM triagem";
        List<Triagem> triagem = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Triagem.class));
        return ResponseEntity.status(200).body(triagem);
    }

    @PostMapping
    public ResponseEntity<?> salvarTriagem(@RequestBody Triagem triagem) {
        if (triagem.getNome() == null || triagem.getNome().trim().length() < 2) {
            return ResponseEntity.status(400).body("Digite um nome válido.");
        }

        if (triagem.getIdade() == null || triagem.getIdade() < 0 || triagem.getIdade() > 120) {
            return ResponseEntity.status(400).body("Digite uma idade válida (0 a 120).");
        }

        if (triagem.getDataNascimento() == null) {
            return ResponseEntity.status(400).body("Selecione sua data de nascimento.");
        }

        if (triagem.getSenteDor() == null || triagem.getSenteDor().trim().isEmpty()) {
            return ResponseEntity.status(400).body("Selecione uma das opções sobre dor.");
        }

        if (triagem.getSintomas() == null || triagem.getSintomas().trim().isEmpty()) {
            return ResponseEntity.status(400).body("Marque ao menos um sintoma.");
        }

        if (triagem.getPais() == null || triagem.getPais().trim().isEmpty()) {
            return ResponseEntity.status(400).body("Selecione o seu país.");
        }

        String sql = "INSERT INTO triagem (nome, idade, data_nascimento, sente_dor, sintomas, pais_origem) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                triagem.getNome().trim(),
                triagem.getIdade(),
                triagem.getDataNascimento(),
                triagem.getSenteDor(),
                triagem.getSintomas(),
                triagem.getPais()
        );

        return ResponseEntity.status(201).build();
    }


}
