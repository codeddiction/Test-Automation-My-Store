package com.auto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckOutElements {
	
	
//		Address
//		=======

	//		Checkout
	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
	private WebElement addressCheckout;
	
	public WebElement getAddressCheckout() {
		return addressCheckout;
	}
	
	
//		Shipping
//		========
	
	//		Terms of service
	@FindBy(id = "cgv")
	private WebElement tickTerms;
	
	public WebElement getTickTerms() {
		return tickTerms;
	}

	//		Checkout
	@FindBy(xpath = "///*[@id=\"form\"]/p/button/span")
	private WebElement shipCheckout;
	
	public WebElement getShipCheckout() {
		return shipCheckout;
	}
	
	
//		Before payment
//		==============

	//		Pay by bank wire
	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	private WebElement bankWire;
	
	public WebElement getBankWire() {
		return bankWire;
	}
	

//		During Payment
//		=======

	//		Confirm order
	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
	private WebElement confirmOrder;
	
	public WebElement getConfirmOrder() {
		return confirmOrder;
	}
	
	
//		Confirmation
//		============

	//		Message
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
	private WebElement message;
	
	public WebElement getMessage() {
		return message;
	}
	
	//		Cost
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/span/strong")
	private WebElement totalCost;
	
	public WebElement getTotalCost() {
		return totalCost;
	}
}
