package com.blazinc.model.domain

data class Message(
    var message_id: String?,
    var from: User?,
    var date: Int?,
    var chat: Chat,
    var text: String,
)
