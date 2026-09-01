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
import com.entities.Facture;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.FactureService;
import com.services.impl.FactureServiceImpl;
@ManagedBean
@ViewScoped
public class FactureBean implements Serializable {
	private Facture facture=new Facture();
	@ManagedProperty(value="#{fctrServ}")
	private FactureService factureService;
	private List<Facture> list=new ArrayList<>();
	private boolean bntAdd=true, btnEdit=false;
	public void ajouter() {
		try {
			MessageResponse result =factureService.save(facture);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			facture=new Facture();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	
	public void supprimer() {
		try {
			MessageResponse result =factureService.delete(facture);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			facture=new Facture();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	public void modifier() {
		try {
			MessageResponse result =factureService.update(facture);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			facture=new Facture();
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
		
		facture=new Facture();
		
		bntAdd=true;
		btnEdit=false;
		
		
		
	}
	
	
	public void preparerAjout() {
	    facture = new Facture();   // vide le formulaire
	    bntAdd = true;           // active le bouton Ajouter
	    btnEdit = false;         // désactive le bouton Modifier
	}
	
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public List<Facture> getList() {
		
		try {
			list=factureService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	public void setList(List<Facture> list) {
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



	public FactureService getFactureService() {
		return factureService;
	}



	public void setFactureService(FactureService factureService) {
		this.factureService = factureService;
	}
	
	
	
	
}




