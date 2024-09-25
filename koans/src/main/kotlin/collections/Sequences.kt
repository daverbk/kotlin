package collections

fun findMostExpensiveProductBySequence(customer: Customer): Product? =
    customer.orders
        .asSequence()
        .filter(Order::isDelivered)
        .flatMap(Order::products)
        .maxByOrNull(Product::price)

fun Shop.getNumberOfTimesProductWasOrderedSequence(product: Product): Int =
    customers
        .asSequence()
        .flatMap(Customer::getOrderedProductsSequence)
        .count { it == product }

fun Customer.getOrderedProductsSequence(): Sequence<Product> =
    orders
        .asSequence()
        .flatMap(Order::products)
