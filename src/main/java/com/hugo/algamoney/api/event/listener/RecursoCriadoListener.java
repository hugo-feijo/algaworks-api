package com.hugo.algamoney.api.event.listener;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hugo.algamoney.api.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		Long codigo = recursoCriadoEvent.getCodigo();
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		adicionarHeaderLocation(codigo, response); 
	}

	private void adicionarHeaderLocation(Long codigo, HttpServletResponse response) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{codigo}")
				.buildAndExpand(codigo)
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
