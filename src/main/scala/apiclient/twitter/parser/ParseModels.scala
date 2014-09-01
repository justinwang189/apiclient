package apiclient.twitter.parser

import apiclient.twitter.model._

case class ParseTweet(
  id_str: String,
  text: String,
  user: ParseUser,
  in_reply_to_user_id_str: Option[String],
  favorite_count: Long,
  retweet_count: Long,
  in_reply_to_screen_name: Option[String],
  source: Option[String]
) {
  def toModel = {
    new Tweet(
      id = id_str.toLong,
      text = text,
      user = user.toModel,
      inReplyToUserId = in_reply_to_user_id_str.map { _.toLong},
      favoriteCount = favorite_count,
      retweetCount = retweet_count,
      source = source
    )
  }
}

case class ParseUser (
  id_str: String,
  name: Option[String],
  screen_name: Option[String],
  location: String,
  description: Option[String],
  url: Option[String],
  followers_count: Long,
  friends_count: Long,
  verified: Boolean,
  statuses_count: Long,
  media_count: Option[Long],
  lang: String
) {
  def toModel = {
    new User(
      id = id_str.toLong,
      name = name,
      screenName = screen_name.getOrElse(""),
      description = description,
      url = url,
      followerCount = followers_count,
      followingCount = friends_count,
      isVerified = verified,
      tweetCount = statuses_count,
      mediaCount = media_count.getOrElse(0L),
      language = lang
    )
  }
}

case class ParseUserList(
  users: Seq[ParseUser],
  previous_cursor_str: String,
  next_cursor: String
)  {
  def toModel: UserList = UserList(users.map { _.toModel })
}

case class ParseTimeline(
  tweets: Seq[ParseTweet] = Seq.empty
) {
  def toModel = new Timeline(tweets.map { _.toModel })
}