package com.auto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class QuickViewElements {
	
	
//		Quick view of the cart
//		======================
	
	@FindBy(id = "group_1")
	private WebElement sizeTab;
	
	public WebElement getSizeTab() {
		return sizeTab;
	}	
	
//	FIND OUTTTTTTTTTTTTTTTTT
	@FindBy(xpath = "")
	private WebElement medium;
	
	public WebElement getMedium() {
		return medium;
	}
		
//	FIND OUTTTTTTTTTTTTTTTTT
	@FindBy(xpath = "")
	private WebElement large;
	
	public WebElement getLarge() {
		return large;
	}
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")
	private WebElement addCart;
	
	public WebElement getAddCart() {
		return addCart;
	}
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	private WebElement continueShopping;
	
	public WebElement getContinue() {
		return continueShopping;
	}
	
	
//		Quick view of the item
//		======================
	
	//		Title
	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt[1]/div/div[1]/a")
	private WebElement cartTitle1;
	
	public WebElement getCartTitle1() {
		return cartTitle1;
	}
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt[2]/div/div[1]/a")
	private WebElement cartTitle2;
	
	public WebElement getCartTitle2() {
		return cartTitle2;
	}
	
	//		Cost
	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt[1]/div/span")
	private WebElement cartCost1;
	
	public WebElement getCartCost1() {
		return cartCost1;
	}
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt[2]/div/span")
	private WebElement cartCost2;
	
	public WebElement getCartCost2() {
		return cartCost2;
	}
	
	//		Shipping fee
	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/div/div[1]/span[1]")
	private WebElement cartShipping;
	
	public WebElement getCartShipping() {
		return cartShipping;
	}
	
	
	//		Total fee
	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/div/div[2]/span[1]")
	private WebElement cartTotal;
	
	public WebElement getCartTotal() {
		return cartTotal;
	}
	
}
