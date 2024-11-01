package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {
    return allDrivers.filter { driver ->
        trips.none { it.driver == driver }
    }.toSet()
}
