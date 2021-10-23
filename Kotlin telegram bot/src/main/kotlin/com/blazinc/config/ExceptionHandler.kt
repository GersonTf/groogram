package com.blazinc.config

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton
import mu.KotlinLogging


@Produces
@Singleton
@Requires(classes = [Exception::class, ExceptionHandler::class])
class GlobalExceptionHandler : ExceptionHandler<Exception, HttpResponse<*>> {

    private val logger = KotlinLogging.logger {}

    override fun handle(request: HttpRequest<*>?, exception: Exception): HttpResponse<*> {
        logger.info(exception.message)
        return HttpResponse.ok(0)
    }
}

