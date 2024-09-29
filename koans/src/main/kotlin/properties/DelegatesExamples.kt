package properties

class LazyProperty2(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}
