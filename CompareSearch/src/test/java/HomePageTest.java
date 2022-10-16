//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Logging.Log4j;
import org.example.SearchResult;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomePageTest extends BasePageTest {
    HomePage homePage;
    SearchResult [] googleSearchResults;
    SearchResult [] yandexSearchResults;


    public HomePageTest() {

    }
    @Test(
            priority = 1
    )
    public void searchGoogle() throws InterruptedException {
        this.driver.get("https://www.google.com.tr/search?q=hepsiburada&sxsrf=ALiCzsb7iPEc6fAE8PgJSX9QsTA-2G8uCg%3A1665924223530&source=hp&ei=f_xLY7DxHLHAxc8P5oGCsA4&iflsig=AJiK0e8AAAAAY0wKjxPB0BKj-sS1WHabaFyKIXLNlTEE&oq=heps&gs_lcp=Cgdnd3Mtd2l6EAMYADIECCMQJzIECCMQJzIECCMQJzIECAAQQzIHCAAQsQMQQzIFCAAQsQMyBAgAEEMyCAgAEIAEELEDMgsIABCABBCxAxCDATIICAAQgAQQsQM6CgguELEDENQCEEM6CwguEIAEEMcBEK8BOgUIABCABDoHCAAQgAQQCjoJCAAQgAQQChATOggIABAeEAoQEzoGCAAQHhATUABY3RRggB5oAnAAeACAAfILiAHfG5IBCzAuMi4xLjctMS4xmAEAoAEB&sclient=gws-wiz");
        Thread.sleep(3000);
        //HomePage homePage = new HomePage(this.driver);
        //homePage.searchGoogle("hepsiburada");
        Log4j.searchGoogle("");
    }
    @Test(
            priority = 2
    )
    public void parseGooglePage() throws InterruptedException {
        Thread.sleep(5000);
        this.homePage = new HomePage(this.driver);
        googleSearchResults=this.homePage.parseResultDivListGoogle();
        Log4j.parseGooglePage("");
    }
    @Test(
            priority = 3
    )
    public void searchYandex() throws InterruptedException {
        this.driver.get("https://www.yandex.com/");
        Thread.sleep(3000);
        HomePage homePage = new HomePage(this.driver);
        homePage.searchYandex("hepsiburada");
        Log4j.searchYandex("");
    }
    @Test(
            priority = 4
    )
    public void parseYandexPage() throws InterruptedException {
        Thread.sleep(5000);
        this.homePage = new HomePage(this.driver);
        yandexSearchResults=this.homePage.parseResultDivListYandex();
        Log4j.parseYandexPage("");
    }

    @Test(
            priority = 5
    )
    public void  compareSearchResults (){
        List <SearchResult> sameResults= new ArrayList<>();
        for (int i = 0; i < googleSearchResults.length; i++) {
            SearchResult googleSearchResult=googleSearchResults[i];
            for (int j = 0; j < yandexSearchResults.length ; j++) {
                SearchResult yandexSearchResult=yandexSearchResults[j];
                if (googleSearchResult.getUrl().contains(yandexSearchResult.getUrl())){
                    sameResults.add(googleSearchResult);
                    System.out.println(googleSearchResult);

                } else if (yandexSearchResult.getTitle().contains(googleSearchResult.getUrl())) {
                    sameResults.add(googleSearchResult);
                    System.out.println(googleSearchResult);
                }
            }
        }
        Log4j.compareSearchResults("");
    }
}
