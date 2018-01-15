package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metier.entities.Categorie;
import metier.entities.Produit;

public  class CatalogueMetierImpl implements ICatalogueMetier {
	
	private Map<Long, Categorie> categories=new HashMap<Long, Categorie>();
	private Map<Long, Produit> produits=new HashMap<Long, Produit>();

	@Override
	public Categorie addCategorie(Categorie c) {
		categories.put(c.getIdCategorie(), c);
		return c;
	}

	@Override
	public Produit addProduit(Produit p) {
		p.setCategorie(getCategorie(p.getCategorie().getIdCategorie()));
		produits.put(p.getIdProduit(), p);
		return p;
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return new ArrayList<Categorie>(categories.values());
	}

	@Override
	public List<Produit> produitsParCat(Long idCat) {
		List<Produit> prods=new ArrayList<Produit>();
		for(Produit p: produits.values())
			if(p.getCategorie().getIdCategorie().equals(idCat))
				prods.add(p);
		
		return prods;
	}

	@Override
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		return new ArrayList<Produit>(produits.values());
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		List<Produit> prods=new ArrayList<Produit>();
		for(Produit p: produits.values())
			if(p.getDesignation().contains(mc))
				prods.add(p);
		
		return prods;
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		categories.put(c.getIdCategorie(), c);
		return c;
	}

	@Override
	public Produit updateProduit(Produit p) {
		produits.put(p.getIdProduit(), p);
		return p;
	}

	@Override
	public boolean deleteProduit(Long idProduit) {
		if(produits.get(idProduit)!=null){
			produits.remove(idProduit);
			return true;
		}else throw new RuntimeException("produit introuvable");		
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		// TODO Auto-generated method stub
		return categories.get(idCategorie);
	}

	@Override
	public Produit getProduit(Long idProduit) {
		// TODO Auto-generated method stub
		return produits.get(idProduit);
	}
	
	public void initialiserCatalogue(){
		
		addCategorie(new Categorie(1L, "Ordinateur", "Ordinateur.jpg"));
		addCategorie(new Categorie(2L, "Imprement", "Imprement.jpg"));
		addCategorie(new Categorie(3L, "Television", "Television.jpg"));

		produits.put(1L, new Produit(1L, "Hp pavillon Pc", 6500, "Ordi1.jpg",getCategorie(1L)));
		produits.put(2L, new Produit(2L, "Assus Pc", 4500, "Ordi2.jpg",getCategorie(1L)));
		produits.put(3L, new Produit(3L, "Hp Imprement", 6500, "Imp1.jpg",getCategorie(2L)));
		produits.put(4L, new Produit(4L, "Dell Imprement", 6500, "Imp2.jpg",getCategorie(2L)));
		produits.put(5L, new Produit(5L, "LG Television", 1287, "Teliv1.jpg",getCategorie(3L)));
		produits.put(6L, new Produit(6L, "Nec Television", 9780, "Teliv2.jpg",getCategorie(3L)));
	}

}
