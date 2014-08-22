package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._
import com.twitter.util.Future


class HomeTimelineRequest(
  override val params: Map[String, String] = Map()
) extends TimelineRequest {

  type Self <: HomeTimelineRequest

  override val endpoint = "/1.1/statuses/home_timeline.json"
  override def update(params: Map[String, String]) = new HomeTimelineRequest(params).asInstanceOf[Self]
  def withClient(client: Client) = new HomeTimelineRequestBuilt(params, client)

}

class HomeTimelineRequestBuilt(override val params: Map[String, String], val client: Client)
  extends HomeTimelineRequest
  with hasClient[Timeline]
  with TimelineParser
{
  type Self = HomeTimelineRequestBuilt

  override def sendRequest(): Future[Timeline] = client(this.fullUrl).getFuture[String]()
  override def update(newParams: Map[String, String]) = new HomeTimelineRequestBuilt(newParams, client)

}

class ShowStatusRequest(
  override val params: Map[String, String] = Map()
) extends TweetRequest {

  type Self <: ShowStatusRequest

  override val endpoint = "/1.1/statuses/show.json"
  override def update(params: Map[String, String]) = new ShowStatusRequest(params).asInstanceOf[Self]
  def withClient(client: Client) = new ShowStatusRequestBuilt(params, client)
}

class ShowStatusRequestBuilt(override val params: Map[String, String], val client: Client)
  extends ShowStatusRequest
  with hasClient[Tweet]
  with TweetParser
{

  type Self = ShowStatusRequestBuilt

  override def sendRequest(): Future[Tweet] = client(this.fullUrl).getFuture[String]()
  override def update(newParams: Map[String, String]) = new ShowStatusRequestBuilt(newParams, client)

}
