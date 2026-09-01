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
import com.entities.Fournisseur;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.FournisseurService;
import com.services.impl.FournisseurServiceImpl;


@ManagedBean
@ViewScoped
public class FournisseurBean implements Serializable {
	private Fournisseur fournisseur=new Fournisseur();
	@ManagedProperty(value="#{fsrServ}")
	private FournisseurService fournisseurService;
	private List<Fournisseur> list=new ArrayList<>();
	private boolean bntAdd=true, btnEdit=false;
	
	
		
		
	
	public void ajouter() {
		try {
			MessageResponse result =fournisseurService.save(fournisseur);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			fournisseur=new Fournisseur();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	
	public void supprimer() {
		try {
			MessageResponse result =fournisseurService.delete(fournisseur);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			fournisseur=new Fournisseur();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	
	public void modifier() {
		try {
			MessageResponse result =fournisseurService.update(fournisseur);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			fournisseur=new Fournisseur();
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
			
			fournisseur=new Fournisseur();
			
			bntAdd=true;
			btnEdit=false;
			
			
			
		}
		
		
		public void preparerAjout() {
		    fournisseur = new Fournisseur();   // vide le formulaire
		    bntAdd = true;           // active le bouton Ajouter
		    btnEdit = false;         // désactive le bouton Modifier
		}
	
	public Fournisseur getFournisseur() {
			return fournisseur;
		}
		public void setFournisseur(Fournisseur fournisseur) {
			this.fournisseur = fournisseur;
		}
		
	
	public List<Fournisseur> getList() {
		
		try {
			list=fournisseurService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return list;
		}
		public void setList(List<Fournisseur> list) {
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



		public FournisseurService getFournisseurService() {
			return fournisseurService;
		}



		public void setFournisseurService(FournisseurService fournisseurService) {
			this.fournisseurService = fournisseurService;
		}
		
	
	
}