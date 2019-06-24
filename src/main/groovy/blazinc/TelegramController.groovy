package blazinc

import blazinc.telegramModel.Update
import groovy.util.logging.Log
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

import javax.inject.Inject

@Log
@Controller
class TelegramController {

    @Inject
    TelegramHandler telegramHandler

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        "I am alive!!"
    }

    @Post("/webhook")
    void webhook(@Body Update update) {
        telegramHandler.messageReceiver(update?.message?.text?.drop(1), update)
    }
}