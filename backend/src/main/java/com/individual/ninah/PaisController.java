package com.individual.ninah;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/paises")
public class PaisController {
    private final JdbcTemplate jdbcTemplate;

    public PaisController (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Pais>> listarPaises() {
        String sql = "SELECT * FROM pais";
        List<Pais> paises = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pais.class));
        return ResponseEntity.status(200).body(paises);
    }
}
