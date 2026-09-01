package com.services;

import java.util.List;

import com.entities.Client;
import com.model.MessageResponse;

public interface ClientService {
	
	public MessageResponse save(Client client) throws Exception;
	public MessageResponse update(Client client) throws Exception;
	public MessageResponse delete(Client client) throws Exception;
	public List<Client> findAll() throws Exception;
	

}
