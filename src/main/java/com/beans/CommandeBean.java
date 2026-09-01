package com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.entities.Client;
import com.entities.Commande;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.CommandeService;
import com.services.impl.CommandeServiceImpl;
@ManagedBean
@ViewScoped
public class CommandeBean implements Serializable {
	private Commande commande=new Commande();
	@ManagedProperty(value="#{cmdServ}")
	private CommandeService commandeService;
	private List<Commande> list=new ArrayList<>();
	private boolean bntAdd=true, btnEdit=false;
	
	
	
	public void ajouter() {
		try {
			MessageResponse result =commandeService.save(commande);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			commande=new Commande();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	public void supprimer() {
		try {
			MessageResponse result =commandeService.delete(commande);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			commande=new Commande();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	public void modifier() {
		try {
			MessageResponse result =commandeService.update(commande);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			commande=new Commande();
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
		
		commande=new Commande();
		
		bntAdd=true;
		btnEdit=false;
	}
		public void preparerAjout() {
		    commande = new Commande();   // vide le formulaire
		    bntAdd = true;           // active le bouton Ajouter
		    btnEdit = false;         // désactive le bouton Modifier
		}


		
	
	
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public List<Commande> getList() {
		
		try {
			list=commandeService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void setList(List<Commande> list) {
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


	public CommandeService getCommandeService() {
		return commandeService;
	}


	public void setCommandeService(CommandeService commandeService) {
		this.commandeService = commandeService;
	}
	
	
	
}
