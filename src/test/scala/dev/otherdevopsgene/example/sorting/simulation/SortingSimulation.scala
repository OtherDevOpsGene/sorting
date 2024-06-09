package dev.otherdevopsgene.example.sorting.simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SortingSimulation extends Simulation {

  val sorts = exec(http("Homepage")
      .get("/"))
    .pause(1)
    .repeat(10) {
      exec(http("unsorted")
        .get("/words"))
        .pause(1)
        .exec(http("bubble")
          .get("/words?sort=bubble"))
        .pause(1)
        .exec(http("insertion")
          .get("/words?sort=insertion"))
        .pause(1)
        .exec(http("merge")
          .get("/words?sort=merge"))
        .pause(1)
        .exec(http("heap")
          .get("/words?sort=heap"))
        .pause(1)
        .exec(http("quick")
          .get("/words?sort=quick"))
        .pause(1)
        .exec(http("java")
          .get("/words?sort=java"))
    }

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader(
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/119.0"
      )

  val sorting = scenario("SortingSimulation").exec(sorts)

  setUp(
    sorting.inject(rampUsers(2).during (10))
  ).protocols(httpProtocol)
}