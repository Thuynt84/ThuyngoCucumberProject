package awesomecucumber.Steps;

import awesomecucumber.customtype.CustomDataTableType;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckOutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {
    private WebDriver driver;
    //private CheckOutPage checkOutPage;
    private BillingDetails billingDetails;
    
    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        driver = DriverFactory.getDriver();
        System.out.println("DRIVER----------" + driver);
        StorePage storePage = new StorePage(driver);
        storePage.load("https://askomdch.com/store");

    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String productName) {
        new StorePage(driver).addToCart(productName);

        /*//System.out.println("PRODUCT NAME = " + productName.getName());
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCartBtn).click();
        Thread.sleep(5000);
        By viewCart = By.cssSelector("a[title = 'View cart']");
        driver.findElement(viewCart).click();
        Thread.sleep(4000);*/
    }

    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(int quantity, String productName) throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        /*
        //System.out.println("PRODUCT NAME = " + product.getName());
        By productNameFld = By.cssSelector("td[class='product-name']");
        String actualProductName = driver.findElement(productNameFld).getText();
        By productQuantityFLd = By.cssSelector("input[type=\"number\"]");
        String actualQuantity = driver.findElement(productQuantityFLd).getAttribute("value");
        Thread.sleep(3000);*/
        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        driver = DriverFactory.getDriver();
        System.out.println("DRIVER----------" + driver);
        StorePage storePage = new StorePage(driver);
        storePage.load("https://askomdch.com/store");
        /*ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store");*/
    }
    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        new StorePage(driver).addToCart("Blue Shoes");
        /*//driver.get("https://askomdch.com/store");
        By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
        driver.findElement(addToCartBtn).click();
        Thread.sleep(5000);
        By viewCart = By.cssSelector("a[title = 'View cart']");
        driver.findElement(viewCart).click();*/
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        new CartPage(driver).checkOut();
       /* By proceedToCheckoutBtn = By.cssSelector(".checkout-button");
        driver.findElement(proceedToCheckoutBtn).click();*/
    }



    @When("I provide billing details")
    public void iProvideBillingDetails() throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.setBillingDetails(billingDetails);
//        checkOutPage.enterBillingFirstName(billingDetails.get(0).get("firstname"));
//        checkOutPage.enterBillingLastName(billingDetails.get(0).get("lastname"));
//        checkOutPage.enterBillingAddress1(billingDetails.get(0).get("address_line1"));
//        checkOutPage.enterBillingCity(billingDetails.get(0).get("city"));
//        checkOutPage.enterBillingState(billingDetails.get(0).get("state"));
//        checkOutPage.enterBillingZip(billingDetails.get(0).get("zip"));
//        checkOutPage.enterBillingEmail(billingDetails.get(0).get("email"));
       /* By billingFirstNameFld = By.id("billing_first_name")
        By billingLastNameFld = By.id("billing_last_name");
        By billingAddressOneFld = By.id("billing_address_1");
        By billingCityFld = By.id("billing_city");
        By billingStateDropDown = By.id("billing_state");
        By billingZipFld = By.id("billing_postcode");
        By billingEmailFld = By.id("billing_email");

        driver.findElement(billingFirstNameFld).clear();
        driver.findElement(billingFirstNameFld).sendKeys(billingDetails.get(0).get("firstname"));
        driver.findElement(billingLastNameFld).clear();
        driver.findElement(billingLastNameFld).sendKeys(billingDetails.get(0).get("lastname"));
        driver.findElement(billingAddressOneFld).clear();
        driver.findElement(billingAddressOneFld).sendKeys(billingDetails.get(0).get("address_line1"));
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(billingDetails.get(0).get("city"));
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(billingStateDropDown));
        System.out.println("Select dropdown " + select.toString());
        System.out.println("Select dropdown 2222222222 " + billingDetails.get(0).get("state"));
        select.selectByVisibleText(billingDetails.get(0).get("state"));
        driver.findElement(billingZipFld).clear();
        driver.findElement(billingZipFld).sendKeys(billingDetails.get(0).get("zip"));
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(billingDetails.get(0).get("email"));*/

    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.placeAnOrder();
        /*By placeOrderBtn = By.id("place_order");
        driver.findElement(placeOrderBtn).click();
        Thread.sleep(3000);*/
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertEquals("Thank you. Your order has been received.", checkOutPage.checkMessage());
       /* By noticeTxt = By.cssSelector(".woocommerce-notice");
        String actualNoticeMsg = driver.findElement(noticeTxt).getText();
        Assert.assertEquals("Thank you. Your order has been received.", actualNoticeMsg);*/

    }


}
