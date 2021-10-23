package blazinc.telegramModel

import groovy.transform.Canonical

@Canonical
class Chat {

    def id
    String type
    String title
    String username
}
