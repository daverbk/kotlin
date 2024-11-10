package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {
    return allDrivers.filter { driver ->
        trips.none { it.driver == driver }
    }.toSet()

// or allDrivers - trips.map { it.driver }
}

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    allPassengers.filter { passenger ->
        trips.count { passenger in it.passengers } >= minTrips
    }.toSet()

// or trips.flatMap(Trip::passengers)
//        .groupBy { passenger -> passenger }
//        .filterValues { group -> group.size >= minTrips }
//        .keys

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    allPassengers.filter { passenger ->
        trips.count { it.driver == driver && passenger in it.passengers } > 1
    }.toSet()

// or trips.filter { trip -> trip.driver == driver }
//        .flatMap(Trip::passengers)
//        .groupBy { passenger -> passenger }
//        .filterValues { group -> group.size > 1 }
//        .keys

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val (tripsWithDiscount, tripsWithoutDiscount) = trips.partition { it.discount != null }

    return allPassengers.filter { passenger ->
        tripsWithDiscount.count { passenger in it.passengers } >
                tripsWithoutDiscount.count { passenger in it.passengers }
    }.toSet()
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val maxDuration = trips.maxOfOrNull { it.duration }
    if (maxDuration == null || maxDuration < 0) return null

    // build periods
    val periods = mutableListOf<IntRange>()
    var curr = 0..9
    val step = 10
    periods.add(curr)

    while (maxDuration !in curr) {
        val from = curr.first + step
        val to = curr.last + step
        curr = from..to
        periods.add(curr)
    }

    // search for the most frequent
    return periods.maxByOrNull { period ->
        trips.count { it.duration in period }
    }

// or
//    return trips
//        .groupBy {
//            val start = it.duration / 10 * 10
//            val end = start + 9
//            start..end
//        }
//        .maxBy { (_, group) -> group.size }
//        ?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) return false

    val totalIncome = trips.sumOf { it.cost }
    val countOf20PercentDrivers = allDrivers.size * 0.2

    val incomeOf20PercentTopPerformantDrivers = allDrivers.map { driver ->
        trips.filter { it.driver == driver }.sumOf { it.cost }
    }.sortedDescending()
        .take(countOf20PercentDrivers.toInt())
        .sum()

    return (incomeOf20PercentTopPerformantDrivers / totalIncome) >= 0.8

// or
//    if (trips.isEmpty()) return false
//
//    val totalIncome = trips.sumByDouble { it.cost }
//    val sortedDriversIncome: List<Double> = trips
//        .groupBy(Trip::driver)
//        .map { (_, tripsByDriver) -> tripsByDriver.sumByDouble { it.cost } }
//        .sortedDescending()
//
//    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
//    val incomeByTopDrivers = sortedDriversIncome
//        .take(numberOfTopDrivers)
//        .sum()
//
//    return incomeByTopDrivers >= 0.8 * totalIncome
}
