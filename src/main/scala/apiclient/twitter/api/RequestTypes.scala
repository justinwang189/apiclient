package apiclient.twitter.api

import apiclient.common.{HasClient, Model, ApiRequest, Parser}
import apiclient.twitter._


trait TimelineRequestOptions[C <: HasClient] extends { self: ApiRequest[C, _] =>
  def withCount(count: Int) = addParam("count", count.toString)
  def excludeReplies()  = addParam("exclude_replies", "true")
  def excludeRetweets() = addParam("include_rts", "false")
  def withSinceId(id: TweetId) = addParam("since_id", id.toString)
  def withMaxId(id: TweetId) = addParam("max_id", id.toString)
}


/*
trait TweetRequest[C <: HasClient, M <: Model] extends ApiRequest[C, M] { self: Parser[M] =>
  type Self <: TweetRequest[C, M]
  def withTweetId(tweetId: Long): Self = addParam("id", tweetId.toString )
}

trait ListRequest[C <: HasClient, M <: Model] extends ApiRequest[C, M] { self: Parser[M] =>
  type self <: ListRequest[C, M]
  def withUserId(userId: Long): Self = addParam("id", userId.toString )
}
*/