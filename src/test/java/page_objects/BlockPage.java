package page_objects;

import config.Config;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlockPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By json_selector = By.cssSelector("body pre");

    public BlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void goToPageBlock(int block_number) {
        String page_url = Config.getBaseUrl() + block_number;
        driver.get(page_url);
    }

    public JSONObject getBlockData() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(json_selector));
        String json = driver.findElement(json_selector).getText();
        return new JSONObject(json);
    }

    public String getBlockFieldValue(String field_name) {
        JSONObject block = getBlockData();
        return getBlockFieldValue(block, field_name);
    }

    public String getBlockFieldValue(JSONObject block, String field_name) {
        return block.get(field_name).toString();
    }
}
