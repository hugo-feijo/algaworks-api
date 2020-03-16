package com.hugo.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.algamoney.api.model.Lancamento;
import com.hugo.algamoney.api.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@GetMapping
	public List<Lancamento> findAll(){
		return lancamentoRepository.findAll();
	}
}
