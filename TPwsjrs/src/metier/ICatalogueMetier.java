package metier;
import java.util.List;
import metier.entities.Categorie;
import metier.entities.Produit;

public interface ICatalogueMetier {
	
  public Categorie addCategorie(Categorie c);
  public Produit addProduit(Produit p);
  public List<Categorie> listCategories();
  public List<Produit> produitsParCat(Long idCat);
  public List<Produit> listProduits();
  public List<Produit> produitsParMC(String mc);
  public Categorie updateCategorie(Categorie c);
  public Produit updateProduit(Produit p);
  public boolean deleteProduit(Long idProduit);
  public Categorie getCategorie(Long idCategorie);
  public Produit getProduit(Long idProduit);
}
