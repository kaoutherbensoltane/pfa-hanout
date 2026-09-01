package com.services;

import java.util.List;

import com.entities.Epicier;
import com.model.MessageResponse;

public interface EpicierService {
	public MessageResponse save(Epicier epicier) throws Exception;
	public MessageResponse update(Epicier epicier) throws Exception;
	public MessageResponse delete(Epicier epicier) throws Exception;
	public List<Epicier> findAll() throws Exception;

	
	

}
