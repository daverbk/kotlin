package introduction

fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { num -> num % 2 == 0 }