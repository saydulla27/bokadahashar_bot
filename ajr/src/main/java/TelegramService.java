import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public interface TelegramService {
    SendMessage welcome(Update update);

    SendMessage getLocationWeather(Update update) throws IOException;

    SendLocation lokatsiyayuborish(Update update);



}
