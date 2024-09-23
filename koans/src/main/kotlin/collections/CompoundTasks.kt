package collections

fun findMostExpensiveProductBy(customer: Customer): Product? = customer.orders
    .filter(Order::isDelivered)
    .flatMap(Order::products)
    .maxByOrNull { it.price }

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
    customers.flatMap(Customer::getOrderedProducts).count { it == product }
