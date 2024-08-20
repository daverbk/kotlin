plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "kotlin"
include("00-helloworld")
include("01-basictypes")
include("02-collections")
include("03-controlflow")
include("04-functions")
