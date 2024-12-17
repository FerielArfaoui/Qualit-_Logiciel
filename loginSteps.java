package stepsDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.time.Duration;

public class loginSteps {

    static WebDriver driver;

    @Given("user navigates to the My Tek homepage")
    public void user_navigates_to_the_mytek_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mytek.tn/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))); // Attendre que la barre de recherche soit visible
    }

    @When("user searches for an article")
    public void user_searches_for_an_article() {
        try {
            WebElement searchBar = driver.findElement(By.name("q"));
            searchBar.sendKeys("Lave Linge Top SAMSUNG WA19CG6745BVRQ 19Kg - Noir");
            searchBar.submit(); // Soumettre la recherche
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-item"))); // Attendre les résultats
        } catch (Exception e) {
            System.err.println("Error: Unable to perform search. " + e.getMessage());
        }
    }

    @And("user clicks on the article")
    public void user_clicks_on_the_article() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement articleLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Lave Linge Top SAMSUNG WA19CG6745BVRQ 19Kg - Noir')]")));
            articleLink.click(); // Cliquer sur l'article
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.product-title"))); // Attendre que le titre de l'article s'affiche
        } catch (Exception e) {
            System.err.println("Error: Unable to locate or click on the article. " + e.getMessage());
        }
    }

    @And("user clicks on the 'Ajouter au panier' button")
    public void user_clicks_on_the_ajouter_au_panier_button() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // Localiser le bouton avec le texte exact "Ajouter au panier"
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space()='Ajouter au panier']")));
            addToCartButton.click(); // Cliquer sur "Ajouter au panier"
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-icon"))); // Vérifier la mise à jour du panier
        } catch (Exception e) {
            System.err.println("Error: Unable to locate or click on the 'Ajouter au panier' button. " + e.getMessage());
        }
    }

    @And("user clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // Localiser l'icône du panier ou le lien menant à la page du panier
            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.mytek.tn/checkout/cart/']")));
            cartIcon.click();
            System.out.println("Cart icon clicked successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to locate or click on the cart icon. " + e.getMessage());
        }
    }

    @And("user clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // Localiser et cliquer sur le bouton "PASSER À LA CAISSE" en majuscules
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'PASSER À LA CAISSE')]"))); // Texte en majuscules
            checkoutButton.click();
            System.out.println("Checkout button 'PASSER À LA CAISSE' clicked successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to locate or click on the 'PASSER À LA CAISSE' button. " + e.getMessage());
        }
    }

    @Then("the user should be directed to the checkout page")
    public void the_user_should_be_directed_to_the_checkout_page() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // Vérifier que l'utilisateur est redirigé vers la page de paiement
            wait.until(ExpectedConditions.urlContains("checkout")); // Vérifier que l'URL contient "checkout"
            System.out.println("User successfully directed to the checkout page.");
        } catch (Exception e) {
            System.err.println("Error: Unable to verify the redirection to the checkout page. " + e.getMessage());
        }
    }
    @Given("user is on the checkout page")
    public void user_is_on_the_checkout_page() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // Vérifier que l'utilisateur est sur la page de paiement en vérifiant l'URL ou un élément spécifique à cette page
            wait.until(ExpectedConditions.urlContains("checkout"));
            System.out.println("User is on the checkout page.");
        } catch (Exception e) {
            System.err.println("Error: User is not on the checkout page. " + e.getMessage());
        }
    }
    @And("user enters their email \"arfaouiferiel10@gmail.com\" in the email field")
    public void user_enters_their_email_in_the_email_field() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            // Localiser la zone de texte par son attribut ID
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("customer-email")));
            emailField.sendKeys("arfaouiferiel10@gmail.com");
            System.out.println("Email entered successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to enter email. " + e.getMessage());
        }
    }

    @And("user enters their password \"fsegt2023\" in the password field")
    public void user_enters_their_password_in_the_password_field() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            // Localiser la deuxième zone de texte pour le mot de passe
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@type='password'])[1]"))); // Sélectionner le champ mot de passe
            passwordField.clear(); // Assurez-vous que la zone est vide avant de saisir le mot de passe
            passwordField.sendKeys("fsegt2023");
            System.out.println("Password entered successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to enter password. " + e.getMessage());
        }
    }

    @And("user clicks on the \"Connexion\" button")
    public void user_clicks_on_the_Connexion_button() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Localiser le bouton "Connexion" avec l'ID "send2"
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("send2")));
            loginButton.click();
            System.out.println("Login button 'Connexion' clicked successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to click the login button. " + e.getMessage());
        }
    }
    @And("user chooses the delivery option")
    public void user_chooses_the_delivery_option() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

            // Localiser le bouton radio pour le mode de livraison spécifique (flatrate_flatrate)
            WebElement deliveryOptionRadioButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//input[@type='radio' and @value='flatrate_flatrate']")));

            // Faire défiler jusqu'à l'élément pour s'assurer qu'il est visible
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deliveryOptionRadioButton);

            // Cliquer sur le bouton radio une fois qu'il est cliquable
            wait.until(ExpectedConditions.elementToBeClickable(deliveryOptionRadioButton));
            deliveryOptionRadioButton.click();

            System.out.println("Delivery option selected successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to select the delivery option. " + e.getMessage());
        }
    }
    @And("user clicks on the \"Suivant\" button")
    public void user_clicks_on_the_suivant_button() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

            // Wait for the "Suivant" button to be clickable using XPath
            WebElement suivantButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@data-role='opc-continue'][@type='submit']//span[text()='Suivant']")));

            // Click the "Suivant" button
            suivantButton.click();
            System.out.println("'Suivant' button clicked successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to click the 'Suivant' button: " + e.getMessage());
        }

    }
    @And("user selects the payment method")
    public void user_selects_the_payment_method() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait for the payment method radio button to be clickable
            WebElement paymentMethodRadio = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("sample_gateway"))); // Using the ID of the radio button

            // Click the radio button
            paymentMethodRadio.click();
            System.out.println("Payment method selected successfully.");
        } catch (Exception e) {
            System.err.println("Error: Unable to select the payment method. " + e.getMessage());
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {
        try {
            // Wait for 10 seconds
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Error during wait: " + e.getMessage());
        }

        // Close the browser
        driver.quit();
    }
}
