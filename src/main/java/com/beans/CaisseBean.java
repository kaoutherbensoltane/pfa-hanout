package com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.entities.Caisse;
import com.entities.Client;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.CaisseService;
import com.services.impl.CaisseServiceImpl;

@ManagedBean
@ViewScoped
public class CaisseBean implements Serializable {
	private Caisse caisse=new Caisse();
	@ManagedProperty(value="#{caisServ}")
	private CaisseService caisseService;
	private List<Caisse> list=new ArrayList<>();
	private boolean bntAdd=true, btnEdit=false;
	
	
		public void ajouter() {
			try {
				MessageResponse result =caisseService.save(caisse);
				
				if(result.isSuccess()) {
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
					
				}else {
					
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
					
				}
				caisse=new Caisse();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
				e.printStackTrace();
			}
				
			
		}
		
		
		
		public void supprimer() {
			try {
				MessageResponse result =caisseService.delete(caisse);
				
				if(result.isSuccess()) {
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
					
				}else {
					
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
					
				}
				caisse=new Caisse();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
				e.printStackTrace();
			}
				
			
		}
		
		
		
		
		public void modifier() {
			try {
				MessageResponse result =caisseService.update(caisse);
				
				if(result.isSuccess()) {
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
					
				}else {
					
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
					
				}
				caisse=new Caisse();
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
			caisse=new Caisse();
			
			bntAdd=true;
			btnEdit=false;
			
}
		
	


public void preparerAjout() {
    caisse = new Caisse();   // vide le formulaire
    bntAdd = true;           // active le bouton Ajouter
    btnEdit = false;         // désactive le bouton Modifier
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



	public Caisse getCaisse() {
		return caisse;
	}
	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}
	
	public List<Caisse> getList() {
		
		try {
			list=caisseService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void setList(List<Caisse> list) {
		this.list = list;
	}



	public CaisseService getCaisseService() {
		return caisseService;
	}



	public void setCaisseService(CaisseService caisseService) {
		this.caisseService = caisseService;
	}
	
	

}
