package com.hugo.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hugo.algamoney.api.model.Lancamento;
import com.hugo.algamoney.api.model.Pessoa;
import com.hugo.algamoney.api.repository.LancamentoRepository;
import com.hugo.algamoney.api.repository.PessoaRepository;
import com.hugo.algamoney.api.service.exception.PessoaInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento insert(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElseThrow(() -> new EmptyResultDataAccessException("Pessoa inexistente", 1));
		if(!pessoa.isAtivo()) {
			throw new PessoaInativaException();
		}
		return lancamentoRepository.save(lancamento);
		
	}
	
	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = lancamentoRepository.findById(codigo)
															.orElseThrow(() -> new EmptyResultDataAccessException("Lancamento inexistente", 1) );
		if(!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
			validarPessoa(lancamento);
		}
		
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		return lancamentoRepository.save(lancamentoSalvo);
	}

	private void validarPessoa(Lancamento lancamento) {
		Pessoa pessoa = null;
		if(lancamento.getPessoa().getCodigo() != null) {
			pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo())
															.orElseThrow(() -> new EmptyResultDataAccessException("Pessoa inexistente", 1));
		}
		
		if(pessoa == null || !pessoa.isAtivo()) {
			throw new PessoaInativaException();
		}
		
	}

}
