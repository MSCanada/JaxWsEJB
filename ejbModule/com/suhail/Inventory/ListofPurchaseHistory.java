package com.suhail.Inventory;

import java.util.ArrayList;
import java.util.List;




import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListofPurchaseHistory
{
  
    private List<PurchaseHistory> purchaseHistory = new ArrayList<PurchaseHistory>() ;

	public List<PurchaseHistory> getPurchaseHistory() {
		return purchaseHistory;
	}

	public void setPurchaseHistory(List<PurchaseHistory> purchase_History) {
		this.purchaseHistory = purchase_History;
	}
 
    
}