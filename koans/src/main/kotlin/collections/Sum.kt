package collections

fun moneySpentBy(customer: Customer): Double =
    customer.orders
        .flatMap(Order::products)
        .sumOf(Product::price)
