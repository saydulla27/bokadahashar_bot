
import model.Response;
import model.WeatherItem;
import org.checkerframework.checker.i18nformatter.I18nFormatUtil;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pogoda.WeatherUtil;
import sun.util.resources.cldr.CalendarData;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TelegramServiceImpl implements TelegramService {


    @Override
    public SendMessage welcome(Update update) {
        String firstname = update.getMessage().getFrom().getFirstName();
        String lastname = update.getMessage().getFrom().getLastName();
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId());
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setText("Assalom aleykum " + firstname + " " + lastname);
        return sendMessage;
    }

    @Override
    public SendMessage getLocationWeather(Update update) throws IOException {
        String icon = null;
        String malumot = null;

        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId());

        Response response = WeatherUtil.getWeatherFromLocation();

        for (WeatherItem weatherItem : response.getWeather()) {
            icon = weatherItem.getDescription();
        }

        switch (icon) {
            case "clear sky":
                malumot = "Ochiq havo ☀️";
                break;
            case "few clouds":
                malumot = "Kam bulutli \uD83C\uDF24";
                break;
            case "scattered clouds":
                malumot = "Bulutli  ☁";
                break;
            case "broken clouds":
                malumot = "Tarqoq bulutli ⛅";
                break;
            case "shower rain":
                malumot = "Kam yomg`irli   \uD83C\uDF26 ";
                break;
            case "rain":
                malumot = "Yomg`ir    ☔️ ";
                break;
            case "thunderstorm":
                malumot = "Chaqmoqli havo   \uD83C\uDF29 ";
                break;
            case "snow":
                malumot = "Qor   \uD83C\uDF28 ";
                break;
            case "mist":
                malumot = "Tumanli havo   \uD83C\uDF2B ";
                break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        double gradus = response.getMain().getTemp() - 273;
        stringBuilder
                .append("Bu joyda boy ham kambag’al ham, mashxur ham oddiy ko’chadan kelgan bir notanish inson ham birday, birday Alloh oldida holis hizmatda☝\uD83C\uDFFB Har Yakshanba bo’lgan siz kutgan Hashar endi har kuni. Endi hohlagan kuningiz kelib “Jannatdagi Qasrlar” ga hissa qo’shing\uD83D\uDD4C☝\uD83C\uDFFB.")
                .append("\n")
                .append("\n")
                .append("Qo’shimcha barcha ma’lumot +99893-390-83-83 ")
                .append("\n")
                .append("\n")
                .append("Bugun " + response.getName() + " tumanimzdagi  havo harorati  ")
                .append(Math.ceil(gradus) + "° ")
                .append(malumot)
                .append("\n")
                .append("\n")
                .append("Manzilimiz \uD83D\uDC47\uD83C\uDFFB\uD83D\uDC47\uD83C\uDFFB\uD83D\uDC47\uD83C\uDFFB");

        sendMessage.setText(String.valueOf(stringBuilder));
        return sendMessage;
    }


    @Override
    public SendLocation lokatsiyayuborish(Update update) {
        SendLocation sendLocation = new SendLocation();
        sendLocation.setLatitude((float) 40.805798);
        sendLocation.setLongitude((float) 69.18389);
        sendLocation.setChatId(update.getMessage().getChatId());
        return sendLocation;
    }


}


