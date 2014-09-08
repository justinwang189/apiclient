package apiclient.common

import com.foursquare.fhttp.FHttpClient
import com.twitter.util._
import apiclient.twitter.api.Parser


trait HasClient
trait WithClient extends HasClient
trait NoClient extends HasClient

abstract class ApiRequest[C <: HasClient, M <: Model] { self: Parser[M]=>

  type Self <: ApiRequest[C, M]

  val endpoint: String
  val params: Map[String, String]
  val client: Option[Client]

  protected def addParam(key: String, value: String): Self = update(params ++ Map(key -> value))
  protected def update(newParams: Map[String, String]): Self

  def sendRequest(implicit ev: C =:= WithClient): Future[M] =  {
    client.get.apply(fullUrl).getFuture[String]().map { parseModel }
  }

  def fullUrl: String = {
    val end = params.map { case (k,v) => "&" + k + '=' + v}.foldLeft("") { (p, n) =>
      p + n
    }.replaceFirst("&", "?")
    endpoint + end
  }

}
