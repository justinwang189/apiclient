package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._
import com.twitter.util.Future


class HomeTimelineRequest[C <: HasClient](
  val params: Map[String, String] = Map(),
  val client: Option[Client] = None
)
  extends ApiRequest[C, Timeline]
  with TimelineParser
{

  type Self = HomeTimelineRequest[C]

  override val endpoint = "/1.1/statuses/home_timeline.json"

  override def update(params: Map[String, String]) = new HomeTimelineRequest[C](params).asInstanceOf[Self]
  def withClient(client: Client) = new HomeTimelineRequest[WithClient](params, Some(client))

}

object HomeTimelineRequest {
  def apply() = new HomeTimelineRequest[NoClient]
}
/*

class HomeTimelineRequestBuilt(override val params: Map[String, String], val client: Client)
  extends HomeTimelineRequest
  with hasClient[Timeline]
  with TimelineParser
{
  type Self = HomeTimelineRequestBuilt

  override def sendRequest(): Future[Timeline] = client(this.fullUrl).getFuture[String]()
  override def update(newParams: Map[String, String]) = new HomeTimelineRequestBuilt(newParams, client)

}
*/

