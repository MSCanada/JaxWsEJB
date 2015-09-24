package com.suhail.Inventory;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the purchase_history database table.
 * 
 */
@Entity
@Table(name="purchase_history")
@NamedQuery(name="PurchaseHistory.findAll", query="SELECT p FROM PurchaseHistory p")
@XmlRootElement
public class PurchaseHistory {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;

	private String nameItem;

	private int quantity;

	private int totalCost;

	public PurchaseHistory() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getNameItem() {
		return this.nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

}