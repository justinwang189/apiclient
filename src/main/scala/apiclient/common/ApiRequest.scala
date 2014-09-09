package apiclient.common

import com.foursquare.fhttp.FHttpClient
import com.twitter.util._
import apiclient.common._


trait HasClient
trait WithClient extends HasClient
trait NoClient extends HasClient

abstract class ApiRequest[C <: HasClient, M <: Model] { self: Parser[M]=>

  type Self[D <: HasClient] <: ApiRequest[D, M]

  val endpoint: String
  val params: Map[String, String]
  val client: Option[Client]

   def addParam(key: String, value: String): Self[C] = update[C](params ++ Map(key -> value))

   def update[D <: HasClient](newParams: Map[String, String], client: Option[Client] = client): Self[D]

  def sendRequest(implicit ev: C =:= WithClient): Future[M] =  {
    client.get.apply(fullUrl).getFuture[String]().map { parseModel }
  }

  def withClient(client: Client) = update[WithClient](params, Some(client))

  def fullUrl: String = {
    val end = params.map { case (k,v) => "&" + k + '=' + v}.foldLeft("") { (p, n) =>
      p + n
    }.replaceFirst("&", "?")
    endpoint + end
  }

}
