package properties

class PropertyExample() {
    private var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            field = value
            counter++;
        }
}
