# An Archetype for React Web Projects

Archetypes act as templates for new Maven projects, taking care of the most tedious and repetitive tasks for the user, who can just begin coding a pre-configured project.

In this case this Archetype creates a [Spring MVC][spring-mvc] application, using [React][react] + [Redux][redux] for the views. It also comes ready for a full development cycle using [Github Workflow](https://docs.github.com/en/actions/configuring-and-managing-workflows) for CI, [Github](https://github.com/) for SCM, and [Bintray](https://bintray.com/) as the code repository.

## Features

- Creates the base for a [Spring MVC][spring-mvc] project.
- [React][react] and [Redux][redux] for the backend.
- Using [Liquibase][liquibase] for database versioning.
- [bernardomg's Base POM][base-pom] used as parent POM.
- [Unit and integration test][tests] suites are run separatedly with the use of [JUnit][junit].
- [Maven site for the project][site], using the [Docs Maven Skin][docs-skin], for creating a small documentation site.
- [Javadocs][site-javadoc] included in the Maven site.
- [Several useful reports][site-reports] added to the Maven site.
- [Changes log][changes] added to the Maven site.
- [Ready to make use of Github Workflow][github-workflow] for testing and deployment.
- The artifact manifest is fully configured.
- A basic readme template.
- .gitignore and .gitattributes files prepared for common uses.
- [MIT License][license].

## Example project

For a quick taste, there is an [example project][example-project] showing what can be created with the use of this Archetype.

## Commands for the new project

From the first moment the a new project is created all the usual Maven commands can be used, but due to the nature of the project some will require additional configuration.

This configuration is for the database, and the easiest way to handle it is by using embedded dependencies, which will be set up with the 'h2' profile.

### Site generation

The verify phase is required for generating all the reports, and this means that the integration tests will be run, which require all the dependencies.

```
$ mvn verify site -P h2,development
```

### Running the project locally

To run the project locally use the following Maven command:

```
mvn spring-boot:run -P h2,development
```


[base-pom]: https://github.com/Bernardo-MG/base-pom
[docs-skin]: https://github.com/Bernardo-MG/docs-maven-skin
[example-project]: https://github.com/Bernardo-MG/spring-mvc-react-archetype-example

[liquibase]: http://www.liquibase.org/
[spring-mvc]: https://spring.io/
[junit]: http://junit.org

[react]: https://reactjs.org/
[redux]: https://redux.js.org/

[license]: ./license.html

[changes]: ./changes.html
[site]: ./site.html
[site-javadoc]: ./site.html#javadocs
[site-reports]: ./site.html#reports
[tests]: ./tests.html
[github-workflow]: ./ghworkflow.html
