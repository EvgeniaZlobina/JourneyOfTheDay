package test;

import data.DataHelper;
import data.SQLHelper;
//import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.Paymentpage;
import page.Purchasepage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    @BeforeEach
    public void openSource() {
        open("http://localhost:8080");
        SQLHelper.deleteTable();
    }

    @Test
    @DisplayName("Shuld successful card payment approved")
    void theCardPaymentMustBeApproved() {
        var cardinfo = new DataHelper.CardInfo(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidHolder(), getValidCodcvccvv());
        var purchasepage = new Purchasepage();
        var payment = purchasepage.BuyCard();// купить
         var form = new Paymentpage();
         form.fillingOutTheForm(cardinfo);
         form.paymentSuccessfull();
         assertEquals("APPROVED", SQLHelper.getPaymentStatus());
    }
    @Test
    @DisplayName("Shuld successful card payment declined")
    void theCardPaymentMustBeDeclined() {
        var cardinfo = new DataHelper.CardInfo(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidHolder(), getValidCodcvccvv());
        var purchasepage = new Purchasepage();
        var payment = purchasepage.BuyCreditCard();// купить в кредит
        var form = new Paymentpage();
        form.fillingOutTheForm(cardinfo);
        form.paymentSuccessfull();
        assertEquals("DECLINED", SQLHelper.getPaymentStatus());
    }
}
