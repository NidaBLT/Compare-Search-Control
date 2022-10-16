//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;

import org.example.SearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public By searchTextLocator = By.xpath("//*[@title=\"Ara\"]");
    public By yandexSearchTextLocator = By.id("text");
    public By searchButtonLocator = By.name("btnK");
    public By yandexSearchButtonLocator = By.className("button_theme_search");
    public By googleTitleLocator = By.xpath("//*[contains(@class,'LC20lb MBeuO DKV0Md')]");
    public By yandexTitleLocator = By.xpath("//*[contains(@class,'OrganicTitleContentSpan organic__title')]");
    public By googleUrlLocator = By.xpath("//*[contains(@class,'TbwUpd NJjxre')]");
    public By yandexUrlLocator = By.xpath("//*[contains(@class,'Link Link_theme_outer Path-Item link path__item link')]");
    public By googleDescriptionLocator = By.xpath("//*[contains(@class,'VwiC3b yXK7lf')]");
    public By yandexDescriptionLocator = By.xpath("//*[contains(@class,'OrganicTextContentSpan')]");
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void searchGoogle(String text) {
        this.type(this.searchTextLocator, text);
        this.click(this.searchButtonLocator);
    }

    public void searchYandex(String text) {
        this.type(this.yandexSearchTextLocator, text);
        this.click(this.yandexSearchButtonLocator);
    }

    public SearchResult[] parseResultDivListGoogle() {
        List<WebElement> titleElements = this.findAll(this.googleTitleLocator);
        List<WebElement> urlElements = this.findAll(this.googleUrlLocator);
        List<WebElement> descriptionElements = this.findAll(this.googleDescriptionLocator);

        SearchResult[] searchResults = new SearchResult[titleElements.size()];


        for (int i = 0; i < titleElements.size(); i++) {
            WebElement titleElement = titleElements.get(i);
            WebElement urlElement = urlElements.get(i);
            WebElement descriptionElement = descriptionElements.get(i);

            SearchResult searchResult = new SearchResult();

            searchResult.setTitle(titleElement.getText());
            searchResult.setUrl(urlElement.getText());
            searchResult.setDescription(descriptionElement.getText());

            searchResults[i] = searchResult;

        }
        return searchResults;
    }

    public SearchResult[] parseResultDivListYandex() {
        List<WebElement> titleElements = this.findAll(this.yandexTitleLocator);
        List<WebElement> urlElements = this.findAll(this.yandexUrlLocator);
        List<WebElement> descriptionElements = this.findAll(this.yandexDescriptionLocator);

        SearchResult[] searchResults = new SearchResult[titleElements.size()];

        for (int i = 0; i < titleElements.size(); i++) {
            SearchResult searchResult = new SearchResult();
            WebElement titleElement = titleElements.get(i);
            WebElement urlElement = urlElements.get(i);
             if (i<descriptionElements.size()){
                 WebElement descriptionElement =descriptionElements.get(i);
                 searchResult.setDescription(descriptionElement.getText());
             }
            searchResult.setTitle(titleElement.getText());
            searchResult.setUrl(urlElement.getText().replace("›","/"));

            searchResults[i] = searchResult;

        }
        return searchResults;

    }

}
