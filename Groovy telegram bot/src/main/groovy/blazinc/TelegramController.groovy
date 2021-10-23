package blazinc

import blazinc.telegramModel.Update
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

import javax.inject.Inject

@Controller
class TelegramController {

    @Inject
    TelegramHandler telegramHandler

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        "I am alive!!"
    }

    /**
    * This endpoint will be the one that receive the messages from your bot trhough the webhook that you will be configured: 
    * https://core.telegram.org/bots/api#setwebhook (the url param that you have to send must point to this endpoint)
    **/
    @Post("/webhook")
    void webhook(@Body Update update) {
        telegramHandler.messageReceiver(update)
    }
}
