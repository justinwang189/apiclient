package apiclient.twitter

import apiclient.common._
import apiclient.twitter.api._
import com.foursquare.fhttp.FHttpClient
import com.twitter.util._
import apiclient.twitter.model._

class TwitterClient(cred: OauthCred) extends Client(cred) { self =>

  def makeHomeTimelineRequest() = {
    new HomeTimelineRequest().withClient(self)
  }


}
