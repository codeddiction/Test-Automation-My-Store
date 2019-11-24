package com.auto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CartSummaryElements {
	
	//		Title
	@FindBy(xpath = "//*[@id=\"product_1_1_0_0\"]/td[2]/p/a")
	private WebElement cartTitle1;
	
	public WebElement getCartTitle1() {
		return cartTitle1;
	}
	
	@FindBy(xpath = "//*[@id=\"product_2_7_0_0\"]/td[2]/p/a")
	private WebElement cartTitle2;
	
	public WebElement getCartTitle2() {
		return cartTitle2;
	}
	
	//		Cost
	@FindBy(id = "total_product_price_1_1_0")
	private WebElement cartCost1;
	
	public WebElement getCartCost1() {
		return cartCost1;
	}
	
	@FindBy(id = "total_product_price_2_7_0")
	private WebElement cartCost2;
	
	public WebElement getCartCost2() {
		return cartCost2;
	}
	
	//		Total products
	@FindBy(id = "total_product")
	private WebElement totalProducts;
	
	public WebElement getProducts() {
		return totalProducts;
	}
	
	//		Total shipping
	@FindBy(id = "total_shipping")
	private WebElement totalShipping;
	
	public WebElement getTotalShipping() {
		return totalShipping;
	}
		
	//		TotalBeforeTax
	@FindBy(id = "total_price_without_tax")
	private WebElement totalBeforeTax;
	
	public WebElement getTotalBeforeTax() {
		return totalBeforeTax;
	}	
	
	//		TotalAfterTax
	@FindBy(id = "total_price")
	private WebElement totalAfterTax;
	
	public WebElement getTotalAfterTax() {
		return totalAfterTax;
	}
	
	//		Checkout
	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	private WebElement summaryCheckout;
	
	public WebElement getSummaryCheckout() {
		return summaryCheckout;
	}
}
