package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "billing_first_name") private WebElement billingFirstNameFld;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropDown;
    @FindBy(id = "billing_postcode") private WebElement billingZipFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;

    public CheckOutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckOutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckOutPage enterBillingAddress1(String billingAddress1){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddress1);
        return this;
    }

    public CheckOutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckOutPage enterBillingState(String stateDropDown){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        select.selectByVisibleText(stateDropDown);
        return this;
    }
    public CheckOutPage enterBillingZip(String zipCode){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(zipCode);
        return this;
    }
    public CheckOutPage enterBillingEmail(String email){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckOutPage placeAnOrder(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));
        e.click();
        return this;
    }
    public String checkMessage(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(noticeTxt));
        String message = e.getText();
        return message;
        //Assert.assertEquals("Thank you. Your order has been received.", message);

    }
    public CheckOutPage setBillingDetails(BillingDetails billingDetails){
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterBillingAddress1(billingDetails.getBillingAddressLine1()).
                enterBillingCity(billingDetails.getBillingCity()).
                enterBillingState(billingDetails.getBillingState()).
                enterBillingZip(billingDetails.getBillingZip()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }

}
