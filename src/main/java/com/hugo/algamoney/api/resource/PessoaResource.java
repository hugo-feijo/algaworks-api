package com.hugo.algamoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hugo.algamoney.api.model.Pessoa;
import com.hugo.algamoney.api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	public PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll(); 
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> findById(@PathVariable Long codigo){
		Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(codigo);
		return pessoaEncontrada.isPresent() ? ResponseEntity.ok(pessoaEncontrada) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> insert(@Valid @RequestBody Pessoa pessoa){
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{codigo}")
				.buildAndExpand(pessoaSalva.getCodigo())
				.toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
}
