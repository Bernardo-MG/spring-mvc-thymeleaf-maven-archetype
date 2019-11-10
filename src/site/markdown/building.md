# Building

## Environment Flags

Setting the ENVIRONMENT_MODE environmental flag to 'production' will load the production profile.

Setting the DATABASE_SYSTEM environmental flag to 'mysql' or 'postgres' will load the correct profile for that database.

## Maven Properties

Setting the database.auth.source property to 'properties' or 'env' will change the source for the DB authentication data.

## Database

### Profiles

Check the Maven profiles first of all, as some of these are used to set up the database.

### Production Authentication

By default the project only supports development authentication credentials, taken from a properties file.

To change this set the database.auth.source Maven profile to 'env', and this will allow loading the data from the environment. Using this profile the following environmental variables can be used:

| Variable     | Usage                 |
|--------------|-----------------------|
| DATABASE_URL | Access URL for the DB |
