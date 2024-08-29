plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "kotlin"
include("tour")
include("tour:00-helloworld")
include("tour:01-basictypes")
include("tour:02-collections")
include("tour:03-controlflow")
include("tour:04-functions")
include("tour:05-classes")
include("tour:06-nullsafety")
include("koans")
