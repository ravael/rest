package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

import com.thoughtworks.xstream.XStream;

@Path("projetos")
public class ProjetoResource {

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getBtId(@PathParam("id") Long id){
		ProjetoDAO projetoDAO = new ProjetoDAO();
		Projeto projeto = projetoDAO.busca(id);
		return projeto.toJson();
	}
	


	@POST
    @Consumes(MediaType.APPLICATION_XML)
     public Response adiciona(String conteudo) {
        Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
        new ProjetoDAO().adiciona(projeto);
        URI uri = URI.create("/projetos/" + projeto.getId());
        return Response.created(uri).build();
    }


}
