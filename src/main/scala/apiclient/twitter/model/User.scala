package apiclient.twitter.model

import apiclient.twitter._


case class User (
  id: UserId,
  name: Option[String],
  screenName: String,
  description: Option[String],
  url: Option[String],
  followerCount: Long,
  followingCount: Long,
  isVerified: Boolean,
  tweetCount: Long,
  mediaCount: Long,
  language: String
) extends TwitterModel
