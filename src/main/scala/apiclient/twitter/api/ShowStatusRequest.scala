package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._
import com.twitter.util.Future


class ShowStatusRequest[C <: HasClient](
  val params: Map[String, String] = Map(),
  val client: Option[Client] = None
)
  extends TweetRequest[C, Tweet]
  with TweetParser
{
  type Self = ShowStatusRequest[C]
  override val endpoint = "/1.1/statuses/show.json"
  override def update(params: Map[String, String]) = new ShowStatusRequest[C](params, client).asInstanceOf[Self]
  def withClient(client: Client) = new ShowStatusRequest[WithClient](params, Some(client))
}

object ShowStatusRequest {
  def apply(tweetId: Long) = new ShowStatusRequest[NoClient].withTweetId(tweetId)
}