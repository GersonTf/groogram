package blazinc.telegramModel

import groovy.transform.Canonical

@Canonical
class User {
    def id
    String first_name
    boolean is_bot
}

