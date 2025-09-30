import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NifflerTests {
    @Test
    void addSpendingTest() {
        Configuration.pageLoadStrategy="eager";
        open("https://auth.niffler.qa.guru/");
        $("#username").setValue("Demo1");
        $("#password").setValue("demo1");
        $("#login-button").click();
        $("header").$(byText("New spending")).click();
        $("#amount").setValue("55");
        sleep(3000);
//        $("#category").setValue("Milk");
        $("ul").$(byText("Milk")).click();
        $("#save").click();
        $("[placeholder=Search]").setValue("Milk").pressEnter();
        $("tbody").$("tr").shouldHave(text("Milk")).shouldHave(text("55"));
        $("td").$("[type=checkbox]").click();
        $("#delete").click();
        $("[role=dialog]").shouldHave(text("Delete spendings?"));
        $("[role=dialog]").$(byText("Delete")).click();
        sleep(3000);
    }
}
