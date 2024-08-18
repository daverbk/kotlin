package org.studies

fun main() {
    val supported = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in supported
    println("Support for $requested: $isSupported")
}