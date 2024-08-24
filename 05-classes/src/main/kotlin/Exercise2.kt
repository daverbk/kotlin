data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)
class Name(val firstName: String, val lastName: String)
class Address(val fullAddress: String, val city: City)
class City(val name: String, val country: String)

fun main() {
    val person = Person(
        Name("John", "Smith"),
        Address("123 Fake Street", City("Springfield", "US")),
        ownsAPet = false
    )
}