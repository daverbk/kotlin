package conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        return this.year.compareTo(other.year) +
                this.month.compareTo(other.month) +
                this.dayOfMonth.compareTo(other.dayOfMonth)
    }
}

fun test(date1: MyDate, date2: MyDate) {
    println(date1 < date2)
}