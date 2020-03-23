package com.hugo.algamoney.api.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix =  "algamoney")
public class AlgamoneyApiProperty {

	@Value("${origem-Permitida}")
	private String origemPermitida = "http://localhost:8000";
	
	private final Seguranca seguranca = new Seguranca();
	
	
	public Seguranca getSeguranca() {
		return seguranca;
	}
	
	public String getOrigemPermitida() {
		return origemPermitida;
	}

	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}

	public static class Seguranca{
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		 
	}
}
