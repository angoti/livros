package com.professorangoti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.professorangoti.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
