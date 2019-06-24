package blazinc

import blazinc.telegramModel.Update
import groovy.util.logging.Log

import javax.inject.Inject
import javax.inject.Singleton
import javax.validation.ValidationException

@Log
@Singleton
class TelegramHandler {

    @Inject
    MessageService messageService

    private static final def commands = ['start', 'help']

    void messageReceiver(String message, Update params) {
        log.info("message received $message")
        validateMessage(message)
        "$message"(params)
        // invokeMethod(message, params)
    }

    void validateMessage(String message) {
        if (!(message in commands)) {
            throw new ValidationException("the message is not a valid command")
        }
    }

    void start(Update params) {
        String chatID = params?.message?.getChat()?.getId()
        messageService.sendNotificationToTelegram("HelloWorld", chatID)
    }

    void help(Update params) {
        String chatID = params?.message?.getChat()?.getId()
        messageService.sendNotificationToTelegram("use /start to say hello world!", chatID)
    }
}

