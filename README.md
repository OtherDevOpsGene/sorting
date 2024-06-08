# Sorting example

This app just sorts a long list of words using various algorithms.


## Running the application

`mvn spring-boot:run`


## Gatling

https://gatling.io

The source code for the simulation is in `src/test/scala/dev/otherdevopsgene/example/simluation/RecordedSimulation.scala`.

### Running the Gatling UI

`mvn gatling:recorder`

### Running the Gatling tests

`mvn gatling:test`

Report will be listed at the end of the output, in `target/gatling/reports/sorting/recordedsimulation-xxxx/index.html`


## Apache JMeter

https://jmeter.apache.org

### Running the JMeter UI

`apache-jmeter-5.6.3\bin\jmeterw.cmd`

### Running the JMeter tests

`mvn jmeter:jmeter`

Report will be in `target/jmeter/reports/sorting/index.html`


## Unit Performance Tests

The unit test class that measures performance is in `src/test/java/dev/otherdevopsgene/example/sorting/SortingServicePerfTest.java`

