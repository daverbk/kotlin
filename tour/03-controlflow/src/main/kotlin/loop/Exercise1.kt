package loop

fun main() {
    var pizzaSlices = 0

    while (pizzaSlices < 8) {
        println("There's $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    }

    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}