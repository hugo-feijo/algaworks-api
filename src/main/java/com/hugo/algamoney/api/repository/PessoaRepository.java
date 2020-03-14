package com.hugo.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hugo.algamoney.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
