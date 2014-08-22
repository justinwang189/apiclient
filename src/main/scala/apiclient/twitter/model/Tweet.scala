package apiclient.twitter.model

class Tweet(text: String) {
  override def toString = "Tweet( text = " + text + ")"
}

class Timeline(tweets: Seq[Tweet]) {
  override def toString = "Timeline(" + tweets.map { _.toString }.mkString(", ") + ")"

}