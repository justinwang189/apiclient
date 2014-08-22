package apiclient.twitter.api

import apiclient.common.ApiRequest

trait TimelineRequest extends ApiRequest {
  type Self <: TimelineRequest
  def withCount(count: Int): Self = addParam("count", count.toString)
  def excludeReplies(): Self = addParam("exclude_replies", "true")
}

trait TweetRequest extends ApiRequest {
  type Self <: TweetRequest
  def withTweetId(tweetId: Long): Self = addParam("id", tweetId.toString )
}
