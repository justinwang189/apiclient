package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._
import com.twitter.util.Future

class ShowStatusRequest(
  val tweetId: Long,
  p: Map[String, String] = Map()
) extends TweetRequest {

  override val params = p ++ Map("id" -> tweetId.toString)
  type Self <: ShowStatusRequest

  override val endpoint = "/1.1/statuses/show.json"
  override def update(params: Map[String, String]) = new ShowStatusRequest(tweetId, params).asInstanceOf[Self]
  def withClient(client: Client) = new ShowStatusRequestBuilt(tweetId, params, client)
}

class ShowStatusRequestBuilt(tweetId: Long, override val params: Map[String, String], val client: Client)
  extends ShowStatusRequest(tweetId)
  with hasClient[Tweet]
  with TweetParser
{

  type Self = ShowStatusRequestBuilt

  override def sendRequest(): Future[Tweet] = client(this.fullUrl).getFuture[String]()
  override def update(newParams: Map[String, String]) = new ShowStatusRequestBuilt(tweetId, newParams, client)
}
