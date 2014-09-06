package apiclient.twitter.api

import apiclient.common.{hasClient, Client}
import apiclient.twitter.model.Timeline
import com.twitter.util.Future
import apiclient.twitter._

/*
class UserTimelineRequest(
  userId: UserId,
  p: Map[String, String] = Map()
) extends TimelineRequest {

  type Self <: UserTimelineRequest

  override val endpoint = "/1.1/statuses/user_timeline.json"
  override val params = p ++ Map("id" -> userId.toString)

  override def update(params: Map[String, String]) = new UserTimelineRequest(userId, params).asInstanceOf[Self]
  def withClient(client: Client) = new UserTimelineRequestBuilt(userId, params, client)

}

class UserTimelineRequestBuilt(userId: UserId, override val params: Map[String, String], val client: Client)
  extends UserTimelineRequest(userId)
  with hasClient[Timeline]
  with TimelineParser
{
  type Self = UserTimelineRequestBuilt

  override def sendRequest(): Future[Timeline] = client(this.fullUrl).getFuture[String]()
  override def update(newParams: Map[String, String]) = new UserTimelineRequestBuilt(userId, newParams, client)

}
*/
