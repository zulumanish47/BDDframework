package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs
{
    @Given("^when user log in$")
    public void when_user_log_in() {
        // Write code here that turns the phrase above into concrete actions
        System.out.print("sais");
    }

    @When("^when user clicks$")
    public void when_clicks() {
        // Write code here that turns the phrase above into concrete actions
        System.out.print("sais click");
    }


}
