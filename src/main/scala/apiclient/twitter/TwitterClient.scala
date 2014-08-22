package apiclient.twitter

import apiclient.common._
import apiclient.twitter.api._

class TwitterClient(cred: OauthCred) extends Client(cred) { self =>

  def makeHomeTimelineRequest() = new HomeTimelineRequest().withClient(self)

  def makeShowStatusRequest() = new ShowStatusRequest().withClient(self)


}
