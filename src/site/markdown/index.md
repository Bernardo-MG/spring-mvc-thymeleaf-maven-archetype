# An Archetype for Libraries

Archetypes act as templates for new Maven projects, taking care of the most tedious and repetitive tasks for the user, who can just begin coding a pre-configured project.

In this case this Archetype creates a generic Maven-based library which includes various common and useful plugins and utilities, and also comes ready for a full development cycle including CI, where each change to the code is checked before performing automatic releases.

## Features

- Creates the base for a [Spring MVC][spring-mvc] project.
- Integrates with [Thymeleaf][thymeleaf] for the view templates.
- [Wandrell's Base POM][base-pom] used as parent POM.
- [Unit and integration test][tests] suites are run separatedly with the use of [TestNG][testng].
- [Maven site for the project][site], using the [Docs Maven Skin][docs-skin], for creating a small documentation site.
- [Javadocs][site-javadoc] included in the Maven site.
- [Several useful reports][site-reports] added to the Maven site.
- [Changes log][changes] added to the Maven site.
- [Ready to make use of Travis CI][travis] for testing and deployment.
- The artifact manifest is fully configured.
- A basic readme template.
- .gitignore and .gitattributes files prepared for common uses.
- [MIT License][license].

## Example project

For a quick taste, there is an [example project][example-project] showing what can be created with the use of this Archetype.

## Commands for the new project

From the first moment the a new project is created all the usual Maven commands can be used, but due to the nature of the project some will require additional configuration.

This configuration is for the database and the deployment server, and the easiest way to handle them is by using embedded dependencies, which will be set up with the 'h2' and 'jetty' or 'tomcat7' profiles.

### Site generation

The verify phase is required for generating all the reports, and this means that the integration tests will be run, which require all the dependencies.

```
$ mvn verify site -P h2,jetty
```

### Running the project locally

The project can be run locally by using an embedded database and Jetty or Tomcat 7.

Use the following command to run the project using Jetty:

```
$ mvn jetty:run-war -P h2,jetty
```

Or this one for Tomcat:

```
$ mvn tomcat7:run-war -P h2,tomcat7
```


[base-pom]: https://github.com/Bernardo-MG/base-pom
[docs-skin]: https://github.com/Bernardo-MG/docs-maven-skin
[example-project]: https://github.com/Bernardo-MG/library-maven-archetype-example

[spring-mvc]: https://spring.io/
[testng]: http://testng.org/
[thymeleaf]: http://www.thymeleaf.org/

[license]: ./license.html

[changes]: ./changes.html
[site]: ./site.html
[site-javadoc]: ./site.html#javadocs
[site-reports]: ./site.html#reports
[tests]: ./tests.html
[travis]: ./travis.html
