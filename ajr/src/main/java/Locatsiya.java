import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.text.ParseException;


public class Locatsiya extends TelegramLongPollingBot {
    static String botName = "bokadahashar_bot";
    static String botToken = "1977571737:AAG0lpy1b03srC61OR0jIea4WMzTqMN669g";
    public TelegramServiceImpl telegramServiceImpl = new TelegramServiceImpl();


    public static long chatId = 0;

    public Locatsiya() throws ParseException {
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String text = update.getMessage().getText();
            if (text.equals("/start")) {
                execute(telegramServiceImpl.welcome(update));
                execute(telegramServiceImpl.getLocationWeather(update));
                execute(telegramServiceImpl.lokatsiyayuborish(update));
            }
        }
    }
}

