package com.hugo.algamoney.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hugo.algamoney.api.model.Lancamento;
import com.hugo.algamoney.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	public Page<Lancamento> filtra(LancamentoFilter lancamentoFilter, Pageable pageable);
}
