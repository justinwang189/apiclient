package apiclient.twitter

import apiclient.common._
import apiclient.twitter.api._
import com.twitter.util._
import apiclient.twitter.model._

class TwitterClient(cred: OauthCred) extends Client(cred) { self =>

  def makeHomeTimelineRequest() = new HomeTimelineRequest().withClient(self)

  def sendHomeTimelineRequest() = makeHomeTimelineRequest().sendRequest()

  def makeShowStatusRequest(tweetId: TweetId) = new ShowStatusRequest(tweetId).withClient(self)

  def sendShowStatusRequest(tweetId: TweetId): Future[Tweet] = makeShowStatusRequest(tweetId).sendRequest()

  def makeUserTimelineRequest(userId: UserId) = new UserTimelineRequest(userId).withClient(self)

  def sendUserTimelineRequest(userId: UserId): Future[Timeline] = makeUserTimelineRequest(userId).sendRequest()

  def makeFollowerListRequest(userId: UserId) = new FollowerListRequest(userId).withClient(self)

  def sendFollowerListRequest(userId: UserId): Future[UserList] = makeFollowerListRequest(userId).sendRequest()

  def makeUserLookupRequest(userId: UserId) = new UserLookupRequest(userId).withClient(self)

  def sendUserLookupRequest(userId: UserId): Future[User] = makeUserLookupRequest(userId).sendRequest()


}
