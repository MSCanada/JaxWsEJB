package com.suhail.Inventory;


import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;

/**
 * Session Bean implementation class InventoryDB
 */
@WebService
@Stateless
@LocalBean
public class InventoryDB  {
@PersistenceContext(name="InventoryEJB") EntityManager em;
    /**
     * Default constructor. 
     */
    public InventoryDB() {
        
    	
    }


	public ListofPurchaseHistory GetAllInventory()  {
		System.out.println("Reached in Purchase");
		List<Object> result = (List<Object>)em.createNativeQuery("select * from purchase_history").getResultList();
		ListofPurchaseHistory LPH=new ListofPurchaseHistory();
	//	LPH.setPurchaseHistory(in);
		System.out.println(result.size());
		 
		Iterator itr = result.iterator();
		while(itr.hasNext()){
		   Object[] obj = (Object[]) itr.next();
		  
		   String nameItem= String.valueOf(obj[1]); 
		   Integer userID = Integer.parseInt(String.valueOf(obj[0])); 
		   Integer quantity = Integer.parseInt(String.valueOf(obj[2])); 
		   Integer totalCost = Integer.parseInt(String.valueOf(obj[3])); 
		   PurchaseHistory PH=new PurchaseHistory();
		   PH.setUserid(userID);
		   PH.setTotalCost(totalCost);
		   PH.setQuantity(quantity);
		   PH.setNameItem(nameItem);
		   LPH.getPurchaseHistory().add(PH);
		}
		
		return LPH;
		
	}


	public void InsertInventory(String name,int quantity,int price) {
		PurchaseHistory inv=new PurchaseHistory();
		inv.setNameItem(name);
		inv.setQuantity(quantity);
		inv.setTotalCost(price*quantity);
		em.persist(inv);
	}
	
	public String GetName(){
		return "Muhammad";
	}
	
	

}
