package com.services;

import java.util.List;

import com.entities.Facture;
import com.model.MessageResponse;

public interface FactureService {
	public MessageResponse save(Facture facture) throws Exception;
	public MessageResponse update(Facture facture) throws Exception;
	public MessageResponse delete(Facture facture) throws Exception;
	public List<Facture> findAll() throws Exception;
	
	

}
