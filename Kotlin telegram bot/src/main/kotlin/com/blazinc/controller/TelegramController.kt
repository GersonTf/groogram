package com.blazinc.controller

import com.blazinc.model.domain.Update
import com.blazinc.service.TelegramHandler
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller
class TelegramController(val telegramHandler: TelegramHandler) {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String {
        return "I am alive!!"
    }

    /**
     * This endpoint will be the one that receive the messages from your bot through the webhook that you will configure:
     * https://core.telegram.org/bots/api#setwebhook (the url param that you have to send must point to this endpoint)
     **/
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/webhook")
    fun webhook(@Body update: Update) {
        telegramHandler.messageReceiver(update)
    }
}