# Usage

The project requires a database and a server. But the Maven profiles it includes allow running it locally for development.

## Run the project

To run the project locally in an embedded server just use the following Maven command for deploying to Jetty with an H2 in-memory database:

```
$ mvn jetty:run-war -P h2,jetty
```

An embedded Tomcat can be used through this other profile:

```
$ mvn tomcat7:run-war -P h2,tomcat7
```

With this the project will be accessible at [http://localhost:8080/${artifactId}/].

## Maven profiles

| Profile  | Database              |
|----------|-----------------------|
| h2       | H2 in-memory database |
| mysql    | MySQL database        |
| postgres | PostgreSQL database   |

| Profile  | Server                   |
|----------|--------------------------|
| jetty    | Jetty embedded server    |
| tomcat7  | Tomcat 7 embedded server |
