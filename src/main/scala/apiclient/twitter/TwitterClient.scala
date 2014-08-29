package apiclient.twitter

import apiclient.common._
import apiclient.twitter.api._
import com.twitter.util._
import apiclient.twitter.model._

class TwitterClient(cred: OauthCred) extends Client(cred) { self =>

  def makeHomeTimelineRequest() = new HomeTimelineRequest().withClient(self)

  def sendHomeTimelineRequest() = makeHomeTimelineRequest().sendRequest()

  def makeShowStatusRequest(tweetId: Long) = new ShowStatusRequest(tweetId).withClient(self)

  def sendShowStatusRequest(tweetId: Long): Future[Tweet] = makeShowStatusRequest(tweetId).sendRequest()


}
