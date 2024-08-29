package introduction

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val email = client?.personalInfo?.email
    if (message == null || email == null) return
    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}