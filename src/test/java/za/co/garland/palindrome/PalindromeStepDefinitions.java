package za.co.garland.palindrome;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class PalindromeStepDefinitions {

    @Autowired
    private MockMvc mockMvc;

    private String inputValue;

    @Given("a word {string}")
    public void setText(String value) {
        inputValue = value;
    }

    @When("I make a POST request to the palindrome endpoint")
    public void makePostRequest() throws Exception {
        String request = "{\"username\":\"\",\"text\":\""+inputValue+"\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/palindrome")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Then("the response should be {string} with status code {int}")
    public void verifyResponse(String expectedResponse, int expectedStatusCode) throws Exception {
        String response = "{\"text\":\""+inputValue+"\",\"palindrome\":"+expectedResponse+"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/palindrome")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(response))
                .andExpect(MockMvcResultMatchers.status().is(expectedStatusCode))
                .andExpect(MockMvcResultMatchers.content().string(response));
    }
}
