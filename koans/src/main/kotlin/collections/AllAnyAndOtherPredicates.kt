package collections

fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
    customers.all { it.city == city }

fun Shop.hasCustomerFrom(city: City): Boolean =
    customers.any { it.city == city }

fun Shop.countCustomersFrom(city: City): Int =
    customers.count { it.city == city }

fun Shop.findCustomerFrom(city: City): Customer? =
    customers.find { it.city == city }
