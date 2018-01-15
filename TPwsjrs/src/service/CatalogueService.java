package service;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

import metier.CatalogueMetierImpl;
import metier.entities.*;
@Singleton //une seul inst CS
@Path("/catalogue")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class CatalogueService {
	private CatalogueMetierImpl metier;
	
	public CatalogueService(){
		metier = new CatalogueMetierImpl();
		metier.initialiserCatalogue();
	}
	@GET
	@Path("/categories")
	
	public List<Categorie> consulterCateguorie(){
		return metier.listCategories();
	}
	@GET
	@Path("/categories/{idCat}/produits")
	
	public List<Produit> produitsParCat(@PathParam(value="idCat")Long idCat){
		return metier.produitsParCat(idCat);
	}
	@GET
	@Path("/produits")//produits?mc=T
	
	public List<Produit> produitsParMC(@QueryParam(value="mc")String mc){
		return metier.produitsParMC(mc);
	}
	@GET
	@Path("/allproduits")
	
	public List<Produit> produits(){
		return metier.listProduits();
	}
	@GET
	@Path("/categories/{idCat}")
	
	public Categorie getCategorie(@PathParam(value="idCat")Long idCat){
		return metier.getCategorie(idCat);
	}
	@GET
	@Path("/produits/{idProd}")
	
	public Produit getProduit(@PathParam(value="idProd")Long idProd){
		return metier.getProduit(idProd);
	}
	@POST
	@Path("/categories")//format json
	//@Consumes(MediaType.APPLICATION_JSON)
	public Categorie saveCategorie(Categorie c){
		return metier.addCategorie(c);
	}
	@POST
	@Path("/produits")//format json{"idProduit": v, , ,}
	//@Consumes(MediaType.APPLICATION_JSON)
	public Produit saveProduit(Produit p){
		return metier.addProduit(p);
	}
	@DELETE
	@Path("/produits")//format application uncoded, idProd=2&p=v
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean deleteProduit(@FormParam(value="idProd")Long idProd){
		return metier.deleteProduit(idProd);
	}
	@PUT
	@Path("/produits")
	
	public Produit updateProduit(Produit p){
		return metier.updateProduit(p);
	}
}
