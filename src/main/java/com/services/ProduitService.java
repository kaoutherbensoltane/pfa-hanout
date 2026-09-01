package com.services;

import java.util.List;

import com.entities.Produit;
import com.model.MessageResponse;

public interface ProduitService {
	public MessageResponse save(Produit produit) throws Exception;
	public MessageResponse update(Produit produit) throws Exception;
	public MessageResponse delete(Produit produit) throws Exception;
	public List<Produit> findAll() throws Exception;
}
