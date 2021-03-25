package com.github.pages;

import com.github.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IssuesPage {

    @FindBy(xpath = "//span[contains(text(), 'New issue')]")
    private WebElement button_newIssue;

    @FindBy(id = "issue_title")
    private WebElement input_issueTitle;

    @FindBy(id = "issue_body")
    private WebElement input_issueBody;

    @FindBy(xpath = "//button[contains(text(), 'Submit new issue')]")
    private WebElement button_submitIssue;

    @FindBy(css = ".js-issue-title.markdown-title")
    private WebElement newIssueTitle;

    @FindBy(css = ".btn.btn-sm.js-details-target.d-inline-block")
    private WebElement button_currentIssueEdit;

    @FindBy(css = ".btn.mr-2")
    private WebElement getButton_submitIssueUpdate;

    @FindBy(xpath ="//span[contains(text(), 'AssigningTest')]" )
    private WebElement pinnedIssue;

    @FindBy(css = ".text-bold.discussion-sidebar-heading.discussion-sidebar-toggle.hx_rsm-trigger")
    private WebElement assigmentLabel;

    @FindBy(xpath ="//button[contains(text(), 'assign yourself')]" )
    private WebElement button_assignYourself;

    @FindBy(xpath = "//button[@aria-label='Clear assignee']")
    private WebElement cancelAssigment;



    private Helpers helpers;

    public IssuesPage (WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.helpers = new Helpers(driver);

    }

    public void createNewIssue (String titleText, String bodyText) {

        helpers.waitForElementToBeDisplayed(button_newIssue);
        button_newIssue.click();
        input_issueTitle.sendKeys(titleText);
        input_issueBody.sendKeys(bodyText);
        button_submitIssue.click();

    }

    public void assertNewIssueTitle (String expectedIssueTitle) {

        helpers.waitForElementToBeDisplayed(newIssueTitle);
        Assert.assertEquals(newIssueTitle.getText(), expectedIssueTitle, "Titles are not equal");

    }

    public void updateCurrentIssue (String issueNameAfterUpdate) {

        helpers.waitForElementToBeDisplayed(button_currentIssueEdit);
        button_currentIssueEdit.click();
        input_issueTitle.sendKeys(issueNameAfterUpdate);
        getButton_submitIssueUpdate.click();

    }

    public void goToPinnedIssue () {

        helpers.waitForElementToBeDisplayed(pinnedIssue);
        pinnedIssue.click();

    }

    public void assignUserToIssue () {

        helpers.waitForElementToBeDisplayed(button_assignYourself);
        button_assignYourself.click();


    }

    public void unassignUserFromIssue () {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assigmentLabel.click();
        cancelAssigment.click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //this is awful (Thread.sleep) but i didn't find different way to do this

    }

    public void assertAssignYourselfIsVisable () {

        Assert.assertTrue(button_assignYourself.isDisplayed(), "Button assignYourself is not displayed");


    }






}
