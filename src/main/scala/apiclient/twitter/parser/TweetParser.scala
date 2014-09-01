package apiclient.twitter.api

import apiclient.twitter.model._
import apiclient.twitter.parser._
import org.json4s._
import org.json4s.native.JsonMethods
import com.twitter.util._


trait Parser[T] {
  implicit val formats = DefaultFormats
  def parse(json: String): T = parse(JsonMethods.parse(json))
  def parse(node: JValue): T
}

trait TweetParser extends Parser[ParseTweet]{

  override def parse(node: JValue) = {
    node.extract[ParseTweet]
  }
  implicit def json2Tweet(s: String): Tweet=  parse(s).toModel
  implicit def json2TweetF(f: Future[String]): Future[Tweet] =  f.map { parse(_).toModel }
}

trait TimelineParser extends Parser[ParseTimeline] {

  val tweetParser = new TweetParser{}

  override def parse(node: JValue): ParseTimeline = {
    val jsonSeq = node.children.toSeq
    ParseTimeline()
      .copy(tweets = jsonSeq.map {n => tweetParser.parse(n) })
  }

  implicit def json2Timeline(s: String): Timeline =  parse(s).toModel
  implicit def json2TimelineF(f: Future[String]): Future[Timeline] =  f.map { parse(_).toModel }
}

trait UserParser extends Parser[ParseUser] {
  override def parse(node: JValue) = node.extract[ParseUser]

  implicit def json2Tweet(s: String): User=  parse(s).toModel
  implicit def json2TweetF(f: Future[String]): Future[User] =  f.map { parse(_).toModel }
}

trait UserListParser extends Parser[ParseUserList] {

  override def parse(node: JValue): ParseUserList =  node.extract[ParseUserList]

  implicit def json2UserLIst(s: String): UserList =  parse(s).toModel
  implicit def json2UserListF(f: Future[String]): Future[UserList] = f.map { parse(_).toModel }
}

