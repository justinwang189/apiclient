package apiclient.twitter.api

import apiclient.common.ApiRequest
import apiclient.twitter._

trait TimelineRequest extends ApiRequest {
  type Self <: TimelineRequest
  def withCount(count: Int): Self = addParam("count", count.toString)
  def excludeReplies(): Self = addParam("exclude_replies", "true")
  def excludeRetweets(): Self = addParam("include_rts", "false")
  def withSinceId(id: TweetId) = addParam("since_id", id.toString)
  def withMaxId(id: TweetId) = addParam("max_id", id.toString)
}

trait TweetRequest extends ApiRequest {

  type Self <: TweetRequest
  def withTweetId(tweetId: Long): Self = addParam("id", tweetId.toString )
}

trait ListRequest extends ApiRequest {
  type self <: ListRequest
}