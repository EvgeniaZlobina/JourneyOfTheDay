package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.Year;
import java.util.Locale;

import static java.lang.Math.random;
import static java.lang.String.format;

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
    return format("%02d", localDate.getMonthValue());}

    // Заполнение поля "Год"
    public static String getValidYear() {
        int yer = Integer.parseInt(format("%ty", Year.now()));
        int yer1 = yer + 1;
        return format("%ty", yer1);
    }
    // Заполнение поля "владелец"
    public static String getValidHolder() {
        return faker.name().firstName();
    }
    // Заполнение поля "код CVC/CVV"
    public static String getValidCodcvccvv() {
        double x = random()*1000;
        int result = (int)Math.ceil(x);
        return String.valueOf(result);
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


