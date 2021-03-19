# linux-common

[![Maven
Central](https://maven-badges.herokuapp.com/maven-central/io.helins/linux-common/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.helins/linux-common)

[![Javadoc](https://javadoc.io/badge2/io.helins/linux-common/javadoc.svg)](https://javadoc.io/doc/io.helins/linux-common)

![CircleCI](https://circleci.com/gh/helins/linux-common.java.svg?style=shield)

This java library aims to provide generic tooling for interfacing with Linux
utilities via [Java Native Access](https://github.com/java-native-access/jna).
It is meant to build more specific libraries. New classes and functionalities
will be added as specific libraries uncover general patterns and needs.

It serves as a foundations for more useful libraries such as:

- [io.helins/linux-epoll](https://github.com/helins/linux-epoll.java), using Linux's Epoll
- [io.helins/linux-i2c](https://github.com/helins/linux-i2c.java), using the I2C protocol
- [io.helins/linux-gpio](https://github.com/helins/linux-gpio.java), using the Linux GPIO utilities

## Usage

Everything is described in the [javadoc](https://javadoc.io/doc/io.helins/linux-common).

## License

Copyright © 2018 Adam Helinski

Licensed under the term of the Mozilla Public License 2.0, see LICENSE.
