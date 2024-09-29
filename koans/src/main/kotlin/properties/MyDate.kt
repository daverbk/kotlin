package properties

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

fun MyDate.toMillis(): Long {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    return c.getTimeInMillis()
}

fun Long.toDate(): MyDate {
    val c = Calendar.getInstance()
    c.setTimeInMillis(this)
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
}
