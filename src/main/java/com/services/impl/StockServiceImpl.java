package com.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dao.StockDao;
import com.dao.impl.StockDaoImpl;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.StockService;

public class StockServiceImpl implements StockService {
	private StockDao stockDao;

	@Override
	public MessageResponse save(Stock stock) throws Exception {
		
	Stock stk=stockDao.findById(stock.getLibellé());
			if(stk!=null) {
				return new MessageResponse(false,"Libéllée existant");
			
	}
		stockDao.save(stock);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public MessageResponse update(Stock stock) throws Exception {
		
		stockDao.upDate(stock);
		return new MessageResponse(true,"Opération effectué avec succ�s");	
	}

	@Override
	public MessageResponse delete(Stock stock) throws Exception {
		stockDao.delete(stock);
		return new MessageResponse(true,"Opération effectué avec succ�s");	
	}


	@Override
	public List<Stock> findAll() throws Exception {
		return stockDao.findAll();
		
	}

	public StockDao getStockDao() {
		return stockDao;
	}

	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}
	
	

}
