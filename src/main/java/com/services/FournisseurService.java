package com.services;

import java.util.List;

import com.entities.Fournisseur;
import com.model.MessageResponse;

public interface FournisseurService {
	public MessageResponse save(Fournisseur fournisseur) throws Exception;
	public MessageResponse update(Fournisseur fournisseur) throws Exception;
	public MessageResponse delete(Fournisseur fournisseur) throws Exception;
	public List<Fournisseur> findAll() throws Exception;
	
}
