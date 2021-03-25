package com.github.stepdefs;

import com.github.helpers.DriverFactory;
import com.github.helpers.Helpers;
import com.github.helpers.NoSuchDriverException;
import com.github.helpers.PropertyLoader;
import com.github.pages.HomePage;
import com.github.pages.IssuesPage;
import com.github.pages.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class Steps {

    protected WebDriver driver;

    @Before
    public void setUp () throws NoSuchDriverException {

        driver = DriverFactory.getDriver(PropertyLoader.givePropertValue("driver"));

    }

    @Given("^User is on the login page$")
    public void user_is_on_the_login_page() {

        driver.get(PropertyLoader.givePropertValue("env"));

    }

    @When("^User fills the form with \"([^\"]*)\" and \"([^\"]*)\" and clicks 'Sign In' button$")
    public void user_fills_the_form_with_and_and_clicks_Sign_In_button(String login, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.setLoginCredentials(login, password);
        loginPage.submitLoginProcess();

    }

    @Then("^User is able to see his home page$")
    public void userIsAbleToSeeHisHomePage() {

        HomePage homePage = new HomePage(driver);

        homePage.assertLoginProcessOutcome();
    }

    @And("^User goes to target repository$")
    public void userGoesToTargetRepository() {

        HomePage homePage = new HomePage(driver);

        homePage.goToTargetRepository();
    }

    @Then("^User goes to issues section$")
    public void userGoesToIssuesSection() {

        HomePage homePage = new HomePage(driver);

        homePage.goToIssuesSection();
    }

    @When("^User creates a new issue and fills input fields with data \"([^\"]*)\" , \"([^\"]*)\" and submits new issue$")
    public void userCreatesANewIssueAndFillsInputFieldsWithDataAndSubmitsNewIssue(String issueTitle, String issueBody) {

        IssuesPage issuesPage = new IssuesPage(driver);

        issuesPage.createNewIssue(issueTitle,issueBody);
    }

    @Then("^New issue is displayed and title is equal to \"([^\"]*)\"$")
    public void newIssueIsDisplayedAndTitleIsEqualTo(String expectedIssueTitle)  {

        IssuesPage issuesPage = new IssuesPage(driver);

        issuesPage.assertNewIssueTitle(expectedIssueTitle);

    }

    @When("^User clicks edit button, changes title with \"([^\"]*)\" and submits the change$")
    public void userClicksEditButtonChangesTitleWithAndSubmitsTheChange(String titleAfterUpdate)  {

        IssuesPage issuesPage = new IssuesPage(driver);

        issuesPage.updateCurrentIssue(titleAfterUpdate);

    }

    @When("^User goes to pinned issue$")
    public void userGoesToPinnedIssue() {

        IssuesPage issuesPage = new IssuesPage(driver);

        issuesPage.goToPinnedIssue();

    }

    @And("^User assigns himself to the issue$")
    public void userAssignsHimselfToTheIssue() {

        IssuesPage issuesPage = new IssuesPage(driver);

        issuesPage.assignUserToIssue();
    }



    @And("^User unassigns himself form issue$")
    public void userUnsignesHimselfFormIssue() {


        IssuesPage issuesPage = new IssuesPage(driver);

        issuesPage.unassignUserFromIssue();

    }

    @Then("^Button assign yourself is displayed again$")
    public void buttonAssignYourselfIsDisplayedAgain() {

        IssuesPage issuesPage = new IssuesPage(driver);

        issuesPage.assertAssignYourselfIsVisable();


    }


    @After
    public void tearDown (Scenario scenario) {

        if (scenario.isFailed()){
            Helpers.takeScreenshot(driver);
        }

        driver.quit();
        DriverFactory.resetDriver();

    }
}
