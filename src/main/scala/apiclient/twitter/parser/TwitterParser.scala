package apiclient.twitter.api

import apiclient.twitter.model._
import apiclient.twitter.parser._
import org.json4s._
import org.json4s.native.JsonMethods
import com.twitter.util._
import apiclient.common._


trait TweetParser extends Parser[Tweet]{
  override def parse(node: JValue): ParseTweet = node.extract[ParseTweet]
}

trait TimelineParser extends Parser[Timeline] {

  val tweetParser = new TweetParser{}

  override def parse(node: JValue): ParseTimeline = {
    val jsonSeq = node.children.toSeq
    ParseTimeline()
      .copy(tweets = jsonSeq.map {n => tweetParser.parse(n) })
  }
}

trait UserParser extends Parser[User] {
  override def parse(node: JValue) = node.extract[ParseUser]
}

trait UserListParser extends Parser[UserList] {
  override def parse(node: JValue): ParseUserList =  node.extract[ParseUserList]
}

