package com.hugo.algamoney.api.repository.lancamento;

import java.util.List;

import com.hugo.algamoney.api.model.Lancamento;
import com.hugo.algamoney.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	public List<Lancamento> filtra(LancamentoFilter lancamentoFilter);
}
