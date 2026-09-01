package com.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.entities.Commande;
import com.entities.Produit;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.ProduitService;
import com.services.impl.ProduitServiceImpl;
@ManagedBean
@ViewScoped
public class ProduitBean implements Serializable {
	private Produit produit=new Produit();
	@ManagedProperty(value="#{pdtServ}")
	private ProduitService produitService;
	private List<Produit> list=new ArrayList<>();
	private boolean bntAdd=true, btnEdit=false;
	
	
	public void ajouter() {
		try {
			MessageResponse result =produitService.save(produit);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			produit=new Produit();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	public void modifier() {
		try {
			MessageResponse result =produitService.update(produit);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			produit=new Produit();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	public void supprimer() {
		try {
			MessageResponse result =produitService.delete(produit);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			produit=new Produit();
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
	
		public void annuler() {
			
			produit=new Produit();
			
			bntAdd=true;
			btnEdit=false;
			
			
			
		}
		
		public void preparerAjout() {
		    produit = new Produit();   // vide le formulaire
		    bntAdd = true;           // active le bouton Ajouter
		    btnEdit = false;         // désactive le bouton Modifier
		}
		
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public List<Produit> getList() {
		try {
			list=produitService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public void setList(List<Produit> list) {
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

	public ProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}
	
	
}
