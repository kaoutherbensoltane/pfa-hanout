package com.beans;


import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.entities.Client;
import com.entities.Commande;
import com.entities.Produit;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.StockService;
import com.services.impl.StockServiceImpl;
@ManagedBean
@ViewScoped
public class StockBean implements Serializable{
	private Stock stock=new Stock();
	@ManagedProperty(value="#{stkServ}")
	private StockService stockService;
	private List<Stock>list=new ArrayList<>();
	private boolean bntAdd=true, btnEdit=false;
	
	
	
	
	public void ajouter() {
		try {
			MessageResponse result =stockService.save(stock);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			
			stock=new Stock();
	
	        stock.setProduit(new Produit()); // initialisation produit
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	public void clickEdit() {
		bntAdd=false;
		btnEdit=true;
	}
	
	
	public void modifier() {
			try {
				MessageResponse result =stockService.update(stock);
				
				if(result.isSuccess()) {
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
					
				}else {
					
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
					
				}
				stock=new Stock();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
				e.printStackTrace();
			}
				
			
		}
	public void supprimer() {
		try {
			MessageResponse result =stockService.delete(stock);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			stock=new Stock();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
		public void annuler() {
			
			stock=new Stock();
			
			bntAdd=true;
			btnEdit=false;
			
			
			
		}
		
		
		public void preparerAjout() {
		    stock = new Stock();   // vide le formulaire
		    bntAdd = true;           // active le bouton Ajouter
		    btnEdit = false;         // désactive le bouton Modifier
		}
	



	public Stock getStock() {
		
	
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Stock> getList() {
		try {
			list=stockService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void setList(List<Stock> list) {
		this.list = list;
	}


	public boolean isBntAdd() {
		return bntAdd;
	}


	public void setBntAdd(boolean bntAdd) {
		this.bntAdd = bntAdd;
	}


	public boolean isBtnEdit() {
		return btnEdit;
	}


	public void setBtnEdit(boolean btnEdit) {
		this.btnEdit = btnEdit;
	}


	public StockService getStockService() {
		return stockService;
	}


	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}
	

	
}
