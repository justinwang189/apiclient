package apiclient.twitter

import apiclient.common._
import apiclient.twitter.api._

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val client = new TwitterClient(Example.defaultOauth)
    val response = client.makeHomeTimelineRequest().withCount(4).withCount(3).sendRequest()
    println(response.get)
    client.release
    Unit
  }
}