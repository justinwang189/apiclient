package apiclient.common.connection

import com.twitter.util._
import com.foursquare.fhttp._
import com.twitter.conversions.time._
import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.http.Http


class Connection {

  val client =
    new FHttpClient("justin", "api.twitter.com:443",
      ClientBuilder()
        .codec(Http())
        .tls("api.twitter.com")
        .tcpConnectTimeout(1.second)
        .hostConnectionLimit(1)
        .retries(0)
    )

  val oauthSigner = new OauthSigner()

  def run: Future[String] = {
    oauthSigner.signRequest(client("/1.1/statuses/home_timeline.json")).getFuture()
  }

}

class OauthSigner(cred: OauthCred = Example.defaultOauth) {




  val consumer = Token(cred.consumerKey, cred.consumerSecret)
  val access = Token(cred.accessToken, cred.accessTokenSecret)

  def signRequest(request: FHttpRequest) = request.oauth(consumer, access)

}


object Example {

  val defaultOauth = OauthCred(
    consumerKey = "0iCxqEqnRo0KliJ6bGxzk73nU",
    consumerSecret = "1A16jx0p4minxFLIDpH3uGSVrdvcYOLehn1ho3B4xMmV3lmIHj",
    accessToken = "1703340792-bbfJcYGrOq7gf6pwQEiLBSFETu0uWWfwS1RIvyd",
    accessTokenSecret = "3AEhWtRgFpzS91FxeCwrfyzTCAQFmZnVH37MvyxwhNFxw"

  )

}



case class OauthCred (
  consumerKey: String,
  consumerSecret: String,
  accessToken: String,
  accessTokenSecret: String
)
