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
import com.entities.Fournisseur;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.ClientService;
import com.services.FournisseurService;
import com.services.impl.ClientServiceImpl;
import com.services.impl.FournisseurServiceImpl;

@ManagedBean
@ViewScoped
public class ClientBean implements Serializable {
	private Client client=new Client();
	@ManagedProperty(value="#{cltServ}")
	private ClientService clientService;
	private List<Client> list=new ArrayList<>();
	private boolean bntAdd=true, btnEdit=false;
	

	public void ajouter() {
		try {
			MessageResponse result =clientService.save(client);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			client=new Client();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	public void supprimer() {
		try {
			MessageResponse result =clientService.delete(client);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			client=new Client();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Op�ration non effectu�e"));
			e.printStackTrace();
		}
			
		
	}
	
	
	public void modifier() {
		try {
			MessageResponse result =clientService.update(client);
			
			if(result.isSuccess()) {
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));
				
			}else {
				
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention:", result.getMessage()));
				
			}
			client=new Client();
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
			
			client=new Client();
			
			bntAdd=true;
			btnEdit=false;
			
			
			
		}
		
		
		
		public void preparerAjout() {
		    client = new Client();   // vide le formulaire
		    bntAdd = true;           // active le bouton Ajouter
		    btnEdit = false;         // désactive le bouton Modifier
		}


		
	

		public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	


		
		public List<Client> getList() {
			
			try {
				list=clientService.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}


	public void setList(List<Client> list) {
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


		public ClientService getClientService() {
			return clientService;
		}


		public void setClientService(ClientService clientService) {
			this.clientService = clientService;
		}
	
	
	
}
