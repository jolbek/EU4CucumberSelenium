package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String UserType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));

        // based on input enter that user info
        String username = null;
        String password = null;

        if(UserType.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if (UserType.equals("sales manager")){
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        }else if (UserType.equals("store manager")){
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }

        //send username and password and login
        new LoginPage().login(username,password);
    }


    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        System.out.println(menuOptions.size());
        System.out.println(menuOptions);

        //get the list of webelement and convert them to list of string and assert
        BrowserUtils.waitFor(5);
        List<String>  actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println(menuOptions);
        System.out.println(actualOptions);

    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> userInfo) {
        System.out.println(userInfo);

        //use map info to login and also verify firstname and lastname

        //login with map info
        new LoginPage().login(userInfo.get("username"), userInfo.get("password"));

        //verify it
        String actualName = new DashboardPage().getUserName();
        String expectedName = userInfo.get("firstname")+" " + userInfo.get("lastname");

        Assert.assertEquals(expectedName, actualName);
        System.out.println("expectedName = " + expectedName);
        System.out.println("actualName = " + actualName);

    }
}