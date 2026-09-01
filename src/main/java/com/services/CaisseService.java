package com.services;

import java.util.List;

import com.entities.Caisse;
import com.model.MessageResponse;

public interface CaisseService {
	public MessageResponse save(Caisse caisse) throws Exception;
	public MessageResponse update(Caisse caisse) throws Exception;
	public MessageResponse delete(Caisse caisse) throws Exception;
	public List<Caisse> findAll() throws Exception;
	

}
