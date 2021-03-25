package com.github.pages;

import com.github.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "login_field")
    private WebElement input_login;

    @FindBy(id = "password")
    private WebElement input_password;

    @FindBy(css = ".btn.btn-primary")
    private WebElement button_signIn;


    private Helpers helpers;

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.helpers = new Helpers(driver);

    }

    public void setLoginCredentials (String login, String password) {

        helpers.waitForElementToBeDisplayed(input_login);
        input_login.sendKeys(login);
        input_password.sendKeys(password);

    }

    public void submitLoginProcess () {

        button_signIn.click();
    }



}
