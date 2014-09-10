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

trait TweetRequestOptions[C <: HasClient] extends { self: ApiRequest[C, _] =>
  def withTweetId(tweetId: Long) = addParam("id", tweetId.toString )
}

trait ListRequestOptions[C <: HasClient] extends { self: ApiRequest[C, _] =>
  def withUserId(userId: Long) = addParam("id", userId.toString )
}
