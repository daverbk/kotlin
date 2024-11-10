package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {
    return allDrivers.filter { driver ->
        trips.none { it.driver == driver }
    }.toSet()
}

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    allPassengers.filter { passenger ->
        trips.count { it.passengers.contains(passenger) } >= minTrips
    }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    allPassengers.filter { passenger ->
        trips.count { it.driver == driver && it.passengers.contains(passenger) } > 1
    }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    allPassengers.filter { passenger ->
        val tripsWithAndWithoutDiscount = trips.filter { it.passengers.contains(passenger) }
            .partition { it.discount != null }
        return@filter tripsWithAndWithoutDiscount.first.size > tripsWithAndWithoutDiscount.second.size
    }.toSet()
