package apiclient.twitter

import apiclient.common._
import apiclient.twitter.api._
import apiclient.twitter.model._
import com.twitter.util._
import apiclient.twitter.model._


class TwitterClient(cred: OauthCred) extends Client(cred) { self =>

  def makeHomeTimelineRequest() = HomeTimelineRequest().withClient(self)

  def getHomeTimeline(): Future[Timeline] = makeHomeTimelineRequest().sendRequest

  def makeShowStatusRequest(tweetId: TweetId) = ShowStatusRequest(tweetId).withClient(self)

  def getStatus(tweetId: TweetId): Future[Tweet] = makeShowStatusRequest(tweetId).sendRequest

  def makeFollowerListRequest(userId: UserId) = FollowerListRequest(userId).withClient(self)

  def getFollowerList(userId: UserId): Future[UserList] = makeFollowerListRequest(userId).sendRequest

  /*

  def makeUserTimelineRequest(userId: UserId) = UserTimelineRequest(userId).withClient(self)

  def getUserTimeline(userId: UserId): Future[Timeline] = makeUserTimelineRequest(userId).sendRequest
  */

  /*



  def makeUserLookupRequest(userId: UserId) = UserLookupRequest(userId).withClient(self)

  def lookupUsers(userId: UserId): Future[User] = makeUserLookupRequest(userId).sendRequest

  */


}
