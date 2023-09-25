package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Paymentpage {

    private SelenideElement cardnumber = $(byText("Номер карты")).parent().$(".input__control");
    private SelenideElement month = $(byText("Месяц")).parent().$(".input__control");
    private SelenideElement year = $(byText("Год")).parent().$(".input__control");
    private SelenideElement owner = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cvccvv = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement continuebutton = $(byText("Продолжить"));
    private SelenideElement cardNumberError = $(byText("Номер карты")).parent().$(".input__sub");
    private SelenideElement monthError = $(byText("Месяц")).parent().$(".input__sub");
    private SelenideElement yearError = $(byText("Год")).parent().$(".input__sub");
    private SelenideElement expiredCardError = $(byText("Истек срок действия карты")).parent().$(".input__sub");
    private SelenideElement ownerError = $(byText("Владелец")).parent().$(".input__sub");
    private SelenideElement cvcError = $(byText("CVC/CVV")).parent().$(".input__sub");

    //заполнение формы
    public void fillingOutTheForm(DataHelper.CardInfo cardInfo) {
        cardnumber.setValue(cardInfo.getСardnumber());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        owner.setValue(cardInfo.getHolder());
        cvccvv.setValue(cardInfo.getCodcvccvv());
        continuebutton.click();
    }

    // не заполненная форма
    public void emptyform() {
        continuebutton.click();
        cardNumberError.shouldBe(visible);
        monthError.shouldBe(visible);
        yearError.shouldBe(visible);
        ownerError.shouldBe(visible);
        cvcError.shouldBe(visible);
    }

    // успешная оплата
    public void paymentSuccessful() {
        $(".notification_status_ok").shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public void declinedPayment() {
        $(byCssSelector("div.notification.notification_status_error.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

}
