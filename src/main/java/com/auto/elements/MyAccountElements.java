package com.auto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountElements {

	//		Order History Button
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
	private WebElement orderHistoryBtn;
	
	public WebElement getOrderHistoryBtn() {
		return orderHistoryBtn;
	}
	
	//		Total Price
	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[3]/span")
	private WebElement totalPrice;
	
	public WebElement getTotalPrice() {
		return totalPrice;
	}
	
	//		Details tab
	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[7]/a[1]/span")
	private WebElement detailsTab;
	
	public WebElement getDetailsTab() {
		return detailsTab;
	}
	
	//		Add a message
	@FindBy(id = "//*[@id=\"sendOrderMessage\"]/p[3]/textarea")
	private WebElement textBox;
	
	@FindBy(id = "//*[@id=\"sendOrderMessage\"]/div/button/span")
	private WebElement sendBtn;
	
	public void addMsg(String text) { 
		textBox.sendKeys(text);
		sendBtn.submit();
	}
	
	//		Check a message
	@FindBy(xpath = "//*[@id=\"block-order-detail\"]/div[5]/table/tbody/tr/td[2]")
	private WebElement checkMsg;
	
	public WebElement getCheckMsg() {
		return checkMsg;
	}
}
