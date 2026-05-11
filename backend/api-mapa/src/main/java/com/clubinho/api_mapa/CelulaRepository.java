package com.clubinho.api_mapa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CelulaRepository extends JpaRepository<Celula, Long> {
    // O Spring já nos dá os métodos save(), findAll(), findById() de graça aqui!
}