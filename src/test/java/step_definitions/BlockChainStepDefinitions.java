package step_definitions;

import config.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.BlockPage;

import java.util.ArrayList;
import java.util.List;

public class BlockChainStepDefinitions {
    private WebDriver driver;
    private BlockPage blockPage;
    private int initial_block_number;
    private String expected_prev_block;
    private String actual_prev_block;
    private final List<JSONObject> blocksInformation = new ArrayList<>();

    @Before
    public void beforeClass() {
        driver = Config.getDriver();
        blockPage = new BlockPage(driver);
    }

    @After
    public void afterClass() {
        driver.close();
        driver.quit();
    }

    @Given("the initial block number {int}")
    public void theInitialBlockNumber(int number) {
        initial_block_number = number;
        blockPage.goToPageBlock(initial_block_number);
        expected_prev_block = blockPage.getBlockFieldValue("hash");
    }

    @When("I check the next {int} blocks")
    public void iCheckTheNextBlocks(int blocks) {
        for (int i = initial_block_number + 1; i <= initial_block_number + blocks; i++) {
            blockPage.goToPageBlock(i);
            blocksInformation.add(blockPage.getBlockData());
        }
    }

    @Then("I should be able to follow the chain up to the initial block")
    public void iShouldBeAbleToFollowTheChainUpToTheInitialBlock() {
        for (JSONObject block:
             blocksInformation) {

            String block_number = blockPage.getBlockFieldValue(block, "height");
            String error_message = String.format("The prev_block for block number %s", block_number);

            actual_prev_block = blockPage.getBlockFieldValue(block, "prev_block");
            Assert.assertEquals(error_message, expected_prev_block, actual_prev_block);

            expected_prev_block = blockPage.getBlockFieldValue(block, "hash");
        }
    }
}
