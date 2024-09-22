package collections

fun Shop.getProductsOrderedByAll(): Set<Product> =
    customers.map(Customer::getOrderedProductsToSet)
        .reduce { orderedByAll, customerOrders -> orderedByAll.intersect(customerOrders) }

fun Customer.getOrderedProductsToSet(): Set<Product> =
    orders.flatMap(Order::products).toSet()
