package apiclient.common

import com.foursquare.fhttp.FHttpClient
import com.twitter.util._

abstract class ApiRequest {
  type Self <: ApiRequest

  val endpoint: String
  val params: Map[String, String]

  protected def addParam(key: String, value: String): Self = update(params ++ Map(key -> value))
  protected def update(newParams: Map[String, String]): Self

  def fullUrl: String = {
    val end = params.map { case (k,v) => "&" + k + '=' + v}.foldLeft("") { (p, n) =>
      p + n
    }.replaceFirst("&", "?")
    endpoint + end
  }

}

trait hasClient[T] {
  def client: Client
  def sendRequest(): Future[T]
}
