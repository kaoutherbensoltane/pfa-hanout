package com.services;

import java.util.List;

import com.entities.Stock;
import com.model.MessageResponse;

public interface StockService {
	public MessageResponse save(Stock stock) throws Exception;
	public MessageResponse update(Stock stock) throws Exception;
	public MessageResponse delete(Stock stock) throws Exception;
	public List<Stock> findAll() throws Exception;

}
      