package com.services;

import java.util.List;

import com.entities.Commande;
import com.model.MessageResponse;

public interface CommandeService {
	public MessageResponse save(Commande commande) throws Exception;
	public MessageResponse update(Commande commande) throws Exception;
	public MessageResponse delete(Commande commande) throws Exception;
	public List<Commande> findAll() throws Exception;
	
	

}
