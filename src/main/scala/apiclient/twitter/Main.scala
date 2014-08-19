package apiclient.twitter

import apiclient.common.connection._

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val connection = new Connection()
    println(connection.run.get)
    connection.client.release()
    Unit
  }
}
