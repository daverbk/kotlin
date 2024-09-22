package collections

fun Shop.getCustomerWithMaxOrders(): Customer? =
    customers.maxByOrNull { it.orders.size }

fun getMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.flatMap(Order::products).maxByOrNull(Product::price)
