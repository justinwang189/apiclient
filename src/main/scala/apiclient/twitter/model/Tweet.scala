package apiclient.twitter.model

import apiclient.twitter._

case class Tweet(
  id: TweetId,
  text: String,
  user: User,
  inReplyToUserId: Option[UserId],
  favoriteCount: Long,
  retweetCount: Long,
  source: Option[String]
)

case class Timeline(
 tweets: Seq[Tweet]
)
