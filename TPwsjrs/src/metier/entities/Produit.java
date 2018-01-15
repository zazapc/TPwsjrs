package metier.entities;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSetter;

public class Produit implements Serializable{
	
	private Long idProduit;
	private String designation;
	private double prix;
	private String photo;
	private Categorie categorie;
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@JsonIgnore
	public Categorie getCategorie() {
		return categorie;
	}
	@JsonSetter
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(Long idProduit, String designation, double prix, String photo, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.prix = prix;
		this.photo = photo;
		this.categorie = categorie;
	}
	
	
	

}
