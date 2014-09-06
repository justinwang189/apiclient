package apiclient.twitter.model

case class Timeline(val tweets: Seq[Tweet]) extends TwitterModel
