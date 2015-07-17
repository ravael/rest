package br.com.alura.loja;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjetoTest {

	private HttpServer server;
	
	@Before
	public void serverStart(){
		server = Servidor.inicializaServidor();
	}
	
	@After
	public void serverShutDown(){
		server.stop();
	}
	
	@Test
	public void testaConexaoProjeto(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos/1").request().get(String.class);
		assertTrue(conteudo.contains("<nome>Minha loja"));
	}
}
	
