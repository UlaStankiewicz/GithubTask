package com.github.pages;

import com.github.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    @FindBy(partialLinkText = "TestRepository")
    private WebElement text_testRepository;

    @FindBy(xpath = "//span[contains(text(), 'Issues')]")
    private WebElement issuesSection;

    private Helpers helpers;

    public HomePage (WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.helpers = new Helpers(driver);

    }

    public void assertLoginProcessOutcome () {

        Assert.assertTrue(text_testRepository.isDisplayed(), "Targert repository is not displayed");
    }

    public void goToTargetRepository () {

        text_testRepository.click();
    }

    public void goToIssuesSection () {

        helpers.waitForElementToBeDisplayed(issuesSection);
        issuesSection.click();
    }


}
