package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._
import com.twitter.util.Future


class ShowStatusRequest[C <: HasClient](
  val params: Map[String, String] = Map(),
  val client: Option[Client] = None
)
  extends ApiRequest[C, Tweet]
  with TweetParser
  with TweetRequestOptions[C]
{
  type Self[D <: HasClient]  = ShowStatusRequest[D]
  override val endpoint = "/1.1/statuses/show.json"
  override def update[D <: HasClient](params: Map[String, String], client: Option[Client] = client) = new ShowStatusRequest[D](params, client)
}

object ShowStatusRequest {
  def apply(tweetId: Long) = new ShowStatusRequest[NoClient].withTweetId(tweetId)
}