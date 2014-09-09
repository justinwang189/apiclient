package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._


class HomeTimelineRequest[C <: HasClient](
  val params: Map[String, String] = Map(),
  val client: Option[Client] = None
)
  extends ApiRequest[C, Timeline]
  with TimelineParser
  with TimelineRequestOptions[C]
{
  type Self[D <: HasClient] = HomeTimelineRequest[D]
  override val endpoint = "/1.1/statuses/home_timeline.json"
  override def update[D <: HasClient](params: Map[String, String], client: Option[Client] = client) = new HomeTimelineRequest[D](params, client)
  //def withClient(client: Client) = new HomeTimelineRequest[WithClient](params, Some(client))
}

object HomeTimelineRequest {
  def apply() = new HomeTimelineRequest[NoClient]
}