package blazinc

import blazinc.telegramModel.Update
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Specification

import javax.inject.Inject


@MicronautTest
class TelegramControllerSpec extends Specification {

    @Inject
    EmbeddedServer embeddedServer

    @AutoCleanup @Inject @Client("/")
    RxHttpClient client



    void "test index"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/")

        expect:
        response.status == HttpStatus.OK
    }

    void "test webhook"() {
        given:
        //HttpResponse response = client.toBlocking().exchange("/webhook")
        Update update = new Update(update_id: 123)
        HttpRequest request = HttpRequest.POST('/webhook', update)

        expect:
        true
    }

}
