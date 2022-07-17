package com.pattern.gof.chapter2

interface EmailSender {
    val emailSetting: EmailSetting
    fun sendEmail(emailMessage: EmailMessage)
}

interface EmailSetting {
    val host: String
}

data class EmailMessage(val from: String, val to: String, val content: String)
class SampleEmailSetting(override val host: String) : EmailSetting {
}

class SampleEmailSender(override val emailSetting: EmailSetting) : EmailSender {
    override fun sendEmail(emailMessage: EmailMessage) {
        println(emailMessage.toString())
    }
}

fun main() {
    val emailSetting = SampleEmailSetting("우리집")
    val emailSender = SampleEmailSender(emailSetting)
    val emailMessage = EmailMessage("프로", "튜", "콘테느")

    emailSender.sendEmail(emailMessage)
}
