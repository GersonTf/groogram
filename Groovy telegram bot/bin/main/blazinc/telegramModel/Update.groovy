package blazinc.telegramModel

import groovy.transform.Canonical

@Canonical
class Update {

    def update_id
    Message message
}
