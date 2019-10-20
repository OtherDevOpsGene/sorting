package com.coveros.example.simluation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .inferHtmlResources(BlackList(""".*\.css""", """.*\.js""", """.*\.ico"""), WhiteList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0")

  val scn = scenario("RecordedSimulation")
    .exec(http("Homepage")
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

  setUp(scn.inject(rampUsers(2) during (10)).protocols(httpProtocol))
}