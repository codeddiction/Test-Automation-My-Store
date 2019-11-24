package com.auto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInElements {

	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
	private WebElement signInBtn;
	
	public void signIn(String em, String pass) { 
		email.sendKeys(em);
		password.sendKeys(pass);
		signInBtn.click();
	}
}
