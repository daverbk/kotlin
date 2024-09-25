package collections

fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {

    val groupsByLength = collection.groupBy { s -> s.length }

    val maximumSizeOfGroup = groupsByLength.values.maxOfOrNull { group -> group.size }

    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}
