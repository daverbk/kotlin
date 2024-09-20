package collections

fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter {
        val (delivered, undelivered) = it.orders.partition { it.isDelivered }
        undelivered.size > delivered.size
    }.toSet()
