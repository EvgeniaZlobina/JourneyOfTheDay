package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.Year;
import java.util.Locale;

public class DataHelper {
    public static final Faker faker = new Faker(new Locale("en"));

    // создание конструктора
    private DataHelper() {
    }
    // заполнение поля "Номер карты"
    public static String getApprovedCardNumber() {
        return ("4444 4444 4444 4441");
    }

    public static String getDeclinedCardNumber() {
        return ("4444 4444 4444 4442");
    }
// Заполнение поля "Месяц"
public static String getValidMonth() {
        LocalDate localDate = LocalDate.now();
    return String.format("%02d", localDate.getMonthValue());}

    // Заполнение поля "Год"
    public static String getValidYear() {
        return String.format("%ty", Year.now());
    }
    // Заполнение поля "владелец"
    public static String getValidHolder() {
        return faker.name().firstName();
    }
    // Заполнение поля "код CVC/CVV"
    public static String getValidCodcvccvv() {
        double x = Math.random()*100;
        return String.valueOf(x);
    }

// данные карты
    @Value
    public static class CardInfo {
        String сardnumber;
        String month;
        String year;
        String holder;
        String codcvccvv;
    }

}


