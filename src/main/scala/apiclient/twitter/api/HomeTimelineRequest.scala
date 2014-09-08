package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._


class HomeTimelineRequest[C <: HasClient](
  val params: Map[String, String] = Map(),
  val client: Option[Client] = None
)
  extends TimelineRequest[C, Timeline]
  with TimelineParser
{
  type Self = HomeTimelineRequest[C]
  override val endpoint = "/1.1/statuses/home_timeline.json"
  override def update(params: Map[String, String]) = new HomeTimelineRequest[C](params, client).asInstanceOf[Self]
  def withClient(client: Client) = new HomeTimelineRequest[WithClient](params, Some(client))
}

object HomeTimelineRequest {
  def apply() = new HomeTimelineRequest[NoClient]
}