package apiclient.twitter.parser

import apiclient.twitter.model._

case class ParseTweet(
  id_str: String,
  text: String,
  in_reply_to_status_id_str: Option[String]
) {
  def toModel = new Tweet(text)
}

case class ParseTimeline(
  tweets: Seq[ParseTweet] = Seq.empty
) {
  def toModel = new Timeline(tweets.map { _.toModel })
}

class ParseUser {

}
