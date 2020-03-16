package com.hugo.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hugo.algamoney.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
