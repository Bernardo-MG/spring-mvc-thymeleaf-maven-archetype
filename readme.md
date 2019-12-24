# Spring MVC with Thymeleaf Maven Archetype

A [Maven Archetype][maven-archetype] for generating a Spring MVC project using Thymeleaf for the frontend.

[![Maven Central](https://img.shields.io/maven-central/v/com.bernardomg.maven.archetypes/spring-mvc-thymeleaf-archetype.svg)][maven-repo]
[![Bintray](https://api.bintray.com/packages/bernardo-mg/maven/spring-mvc-thymeleaf-maven-archetype/images/download.svg)][bintray-repo]

[![Release docs](https://img.shields.io/badge/docs-release-blue.svg)][site-release]
[![Development docs](https://img.shields.io/badge/docs-develop-blue.svg)][site-develop]

## Features

- Creates the base for a [Spring MVC][spring-mvc] project.
- Initial sample project including working persistence and exception handling
- Integrates with [Thymeleaf][thymeleaf] for the view templates.
- Using [Bootstrap][bootstrap] for the UI.
- Using [Liquibase][liquibase] for database versioning.
- Integrates with [Jasper Reports][jasper] for generating PDFs.
- Fully configured POM, extending from [bernardomg's Base POM][base-pom], including features such as build validation, changes report or manifest configuration.
- Prepared for continuous integration with [Github][github], [Travis][travis] and [Bintray][bintray]. Making a distinction between releases and development versions.
- Prepared for unit and integration tests suites. Created with [JUnit][junit] and ready to be run with [Surefire][surefire] and [Failsafe][failsafe].
- A Maven site, using the [Docs Maven Skin][docs-skin], for sharing the project's documentation along the Javadocs and various reports which range from code quality to changes log.
- Includes basic files such as readme, gitignore and license.

## Sample project

A [sample project][sample-project] shows what this Archetype is capable of creating.

## Documentation

Documentation is always generated for the latest release, kept in the 'master' branch:

- The [latest release documentation page][site-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [latest snapshot documentation page][site-develop].

The documentation site is actually a Maven site, and its sources are included in the project. If required it can be generated by using the following Maven command:

```
$ mvn verify site
```

The verify phase is required, otherwise some of the reports won't be generated.

## Usage

The application is coded in Java, using Maven to manage the project.

It is a Maven Archetype, and can be used through command line or an IDE as long as it is included in the local repository.

### Prerequisites

The project has been tested on the following Java versions:
* JDK 8

All other dependencies are handled through Maven, and noted in the included POM file.

### Installing

The best way to install the Archetype is by downloading it from the [Bintray repository][bintray-repo]. It can be acquired from the [Maven Central Repository][maven-repo] too, but it is not recommended.

The Maven coordinates and URL for it are:

```
Group ID: com.bernardomg.maven.archetypes
Artifact ID: spring-mvc-thymeleaf-maven-archetype
Version: (Check POM or badges)
URL: https://dl.bintray.com/bernardo-mg/maven/
```

For example, to use it through command line type the following:

```
$ mvn archetype:generate -DarchetypeGroupId=com.bernardomg.maven.archetypes -DarchetypeArtifactId=spring-mvc-thymeleaf-maven-archetype -DarchetypeVersion=1.0.0 -DarchetypeRepository=https://dl.bintray.com/bernardo-mg/maven/
```

If using an IDE check its documentation to find out how to use Maven Archetypes, and how to add these to the local repository.

As an alternative, it is always possible to download the project from Github, and then install it using the usual Maven command:

```
$ mvn install
```

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues management

Issues are managed at the GitHub [project issues tracker][issues], where any Github user may report bugs or ask for new features.

### Getting the code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License
The project has been released under the [MIT License][license].

[bintray-repo]: https://bintray.com/bernardo-mg/maven/spring-mvc-thymeleaf-maven-archetype/view
[maven-repo]: https://mvnrepository.com/artifact/com.bernardomg.maven.archetypes/spring-mvc-thymeleaf-archetype
[junit]: https://junit.org
[issues]: https://github.com/Bernardo-MG/spring-mvc-thymeleaf-maven-archetype/issues
[license]: https://www.opensource.org/licenses/mit-license.php
[scm]: https://github.com/Bernardo-MG/spring-mvc-thymeleaf-maven-archetype
[site-develop]: https://docs.bernardomg.com/development/maven/spring-mvc-thymeleaf-maven-archetype
[site-release]: https://docs.bernardomg.com/maven/spring-mvc-thymeleaf-maven-archetype

[maven-archetype]: https://maven.apache.org/guides/introduction/introduction-to-archetypes.html

[sample-project]: https://github.com/Bernardo-MG/spring-mvc-thymeleaf-maven-archetype-example

[spring-mvc]: httpss://spring.io/
[thymeleaf]: https://www.thymeleaf.org/

[jasper]: https://community.jaspersoft.com/

[liquibase]: https://www.liquibase.org/

[docs-skin]: https://github.com/Bernardo-MG/docs-maven-skin
[base-pom]: https://github.com/Bernardo-MG/base-pom

[github]: https://github.com/
[bintray]: https://bintray.com/
[bootstrap]: https://getbootstrap.com/
[travis]: https://travis-ci.org

[surefire]: https://maven.apache.org/surefire/maven-surefire-plugin/
[failsafe]: https://maven.apache.org/surefire/maven-failsafe-plugin/
