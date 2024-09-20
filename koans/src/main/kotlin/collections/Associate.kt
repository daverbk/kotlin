package collections

fun Shop.nameToCustomerMap(): Map<String, Customer> =
    customers.associateBy { it.name }

fun Shop.customerToCityMap(): Map<Customer, City> =
    customers.associateWith { it.city }

fun Shop.customerNameToCityMap(): Map<String, City> =
    customers.associate { it.name to it.city }
