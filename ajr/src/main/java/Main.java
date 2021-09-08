import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws TelegramApiRequestException, ParseException {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new Locatsiya());
        System.out.println("Bot Started!");
    }
}
