# Store service
This is the service for stores features

## Five closest Jumbo
This is a feature which returns five closest Jumbo stores to the give coordinate as meter.

## Run tests
`mvn test` can be used to run all unit tests

## build application
`mvn clean install` can be used to build the project.

## Open api
To be able to use application interface and documentation in:
### Localhost
`http://localhost:8081/swagger-ui/index.html#/`

### Test

### Acc

## Datasource
Jumbo stores information are feed by json file.

# distance calculation 
Distance calculation for given coordinate from stores is based on The haversine formula.
More info in [this link](http://www.movable-type.co.uk/scripts/latlong.html)

