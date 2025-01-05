# [Kotlin Roadmap](../roadmap.pdf)

Kotlin is compiled to Java bytecode, which provides the backward compatability. When wishing to see Kotlin in real-life use J2K converter can be used to convert part of source code into Kotlin. Another way is to start writing unit tests in Kotlin.

Kotlin standard library is just Java standard library and a bunch of [extensions](#extentions) that provides very smooth interoperability between Java code and Kotlin code.

# `class` / `object` members

## Functions

### Constructors

## Properties

# Exceptions

In Kotlin, there is no difference between checked and unchecked exceptions. There are no checked exceptions in Kotlin so there is no need to specify this function throws at this exception. Kotlin library still has a `@Throws` annotation. When we throw a checked exception from Java point of view in Kotlin and want to later handle it in Java, we need to add this annotation.

Java code calling `foo()` won't compile.

```kotlin
fun foo() { throw IOException() }
```

Java code calling `bar()` will compile.

```kotlin
@Throws(IOException::class)
fun bar() { throw IOException() }
```

# Functions and Lambdas

## Extensions

## Inline functions

# Nullability

# Collections and Sequences