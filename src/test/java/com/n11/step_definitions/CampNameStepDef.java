package com.n11.step_definitions;


import com.n11.pages.CampaignsPage;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;


public class CampNameStepDef {

    WebDriver driver = Driver.get();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 15);
    //GetCampaignUrls getCampaignUrls = new GetCampaignUrls();
    CampaignsPage campaignsPage = new CampaignsPage();

    @Given("User opens the browser and goes to the campaigns page")
    public void user_opens_the_browser_and_goes_to_the_campaigns_page() {
        //Goes to the given url
        driver.get(ConfigurationReader.get("url"));
        //Confirmation that expected url equals current url
        Assert.assertEquals(ConfigurationReader.get("url"),driver.getCurrentUrl());
        //Wait until close cookies button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(campaignsPage.closeCookie));
        //Close cookies into the page
        campaignsPage.closeCookies();
    }

    @When("User clicks on each category one by one")
    public void user_clicks_on_each_category_one_by_one() {
        //Click each category one by one and get campaign urls in the n11 campaigns page
        campaignsPage.getCampaignUrls();
    }

    @Then("User imports each campaign urls in categories to excel file")
    public void user_imports_each_campaign_urls_in_categories_to_excel_file() throws IOException {
        //Import all urls which pulled from categories and write to the Excel
        campaignsPage.importToExcel();
    }
}
