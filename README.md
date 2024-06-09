# Sorting example

This app just sorts a long list of words using various algorithms.


## Running the application

`mvn spring-boot:run`


## Gatling

https://gatling.io

The source code for the simulation is in
`src/test/scala/dev/otherdevopsgene/example/simluation/SortingSimulation.scala`. 

### Running the Gatling UI

`mvn gatling:recorder`

### Running the Gatling tests

Start the application in one window (`mvn spring-boot:run`).

In another window, run the Gatling tests with `mvn gatling:test`. They take
about 3 minutes to run.

Report will be listed at the end of the output, in
`target/gatling/reports/sorting/sortingsimulation-xxxx/index.html`. 


## Apache JMeter

https://jmeter.apache.org

### Running the JMeter UI

`mvn jmeter:configure jmeter:gui`

### Running the JMeter tests

Start the application in one window (`mvn spring-boot:run`).

In another window, run the JMeter tests with `mvn jmeter:jmeter`. They take
about 2 minutes to run.

Report will be in `target/jmeter/reports/sorting/index.html`


## Unit Performance Tests

The unit test class that measures performance is in
`src/test/java/dev/otherdevopsgene/example/sorting/SortingServicePerfTest.java`.

The tests are run with `mvn install`. They take about a minute to run.
