package apiclient.common

import com.foursquare.fhttp.FHttpClient
import com.twitter.util._
import apiclient.twitter.api.Parser

abstract class ApiRequest[C <: HasClient, M <: Model] { self: ApiRequest[C,M] with Parser[M]=>

  type Self <: ApiRequest[C, M]

  val endpoint: String
  val params: Map[String, String]
  val client: Option[Client]
  //def parser: Parser[M]

  protected def addParam(key: String, value: String): Self = update(params ++ Map(key -> value))
  protected def update(newParams: Map[String, String]): Self

  //def sendRequest(implicit evidence: Future[String] => Future[M]): Future[M] =  {
  def sendRequest(): Future[M] =  {
    client.get.apply(fullUrl).getFuture[String]().map { parseModel }
  }

  def fullUrl: String = {
    val end = params.map { case (k,v) => "&" + k + '=' + v}.foldLeft("") { (p, n) =>
      p + n
    }.replaceFirst("&", "?")
    endpoint + end
  }

}

trait HasClient

trait WithClient extends HasClient
trait NoClient extends HasClient

/*
trait hasClient[T] {
  def client: Client
  def sendRequest(): Future[T]
}
*/
