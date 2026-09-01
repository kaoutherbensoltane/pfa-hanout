package com.gc.utils;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.FournisseurDao;
import com.dao.impl.FournisseurDaoImpl;
import com.entities.Fournisseur;
import com.services.FournisseurService;
import com.services.impl.FournisseurServiceImpl;



public class Test {



	public static void main(String[] args) {
	//Personne personne=new Personne("444658996654", "ben soltane", "nnn", "7 RUE DE BIZERTe", "lamiabensoltane@gmail.com");
   //PersonneDao personneDao=new PersonneDaoImpl();
		
		Fournisseur fournisseur=new Fournisseur();
	ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");	
		FournisseurService fournisseurService=context.getBean(FournisseurServiceImpl.class);
		try {
			fournisseurService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
