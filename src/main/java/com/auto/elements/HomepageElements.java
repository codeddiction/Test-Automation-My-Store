package com.auto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomepageElements {
	
	
//		Navigation bar
//		==============
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement lastTab;
	
	public WebElement getLastTab() {
		return lastTab;
	}
	
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	private WebElement secondToLastTab;
	
	public WebElement getSecondToLastTab() {
		return secondToLastTab;
	}
	
	
	
//		Cart
//		====

	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	private WebElement cart;
	
	public WebElement getCart() {
		return cart;
	}
	
	
//		Item 1
//		======
	@FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img")
	private WebElement item1;
	
	public WebElement getItem1() {
		return item1;
	}
	
	
//		Item 2
//		======
	@FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[2]/div/div[1]/div/a[1]/img")
	private WebElement item2;
	
	public WebElement getItem2() {
		return item2;
	}
}
