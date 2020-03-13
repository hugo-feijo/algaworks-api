package com.hugo.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hugo.algamoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
