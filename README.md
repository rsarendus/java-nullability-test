# Java nullability test project

A project for testing [JSpecify](https://jspecify.dev/docs/start-here/) annotations:

* IDE behavior
* Static analysis tools

The project requires JDK 25 because of various issues with older versions of Java.
See [here](https://github.com/jspecify/jspecify/issues/365) and [here](https://spring.io/blog/2025/11/12/null-safe-applications-with-spring-boot-4#null-safe-applications).

The project can be built using either of the following Maven profiles to enforce nullness checks during compile phase:

* **`nullaway-via-compiler-plugin`** - uses [NullAway](https://github.com/uber/NullAway) via `maven-compiler-plugin`
* **`nullability-plugin`** - uses [nullability-maven-plugin](https://github.com/making/nullability-maven-plugin) that configures NullAway itself
* **`checker-framework-eisop`** - uses the [EISOP fork](https://eisop.github.io/cf/manual/manual.html#maven) of the Checker Framework
