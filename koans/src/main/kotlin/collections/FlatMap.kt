package collections

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap(Order::products)

fun Shop.getOrderedProducts(): Set<Product> =
    customers.flatMap(Customer::getOrderedProducts).toSet()
