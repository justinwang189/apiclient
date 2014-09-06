package apiclient.twitter.api

import apiclient.twitter.model._
import apiclient.twitter.parser._
import org.json4s._
import org.json4s.native.JsonMethods
import com.twitter.util._
import apiclient.common.Model


trait Parser[M <: Model] {
  implicit val formats = DefaultFormats

  def parseModel(json: String): M = parse(json).toModel
  def parse(json: String): ParseModel[M] = parse(JsonMethods.parse(json))
  def parse(node: JValue): ParseModel[M]
}

trait TweetParser extends Parser[Tweet]{

  //def parse(json: String): ParseTweet = parse(json)
  override def parse(node: JValue): ParseTweet = node.extract[ParseTweet]
  //implicit def json2Tweet(s: String): Tweet=  parse(s).toModel
  //implicit def json2TweetF(f: Future[String]): Future[Tweet] =  f.map { parse(_).toModel }
}

trait TimelineParser extends Parser[Timeline] {

  val tweetParser = new TweetParser{}

  override def parse(node: JValue): ParseTimeline = {
    val jsonSeq = node.children.toSeq
    ParseTimeline()
      .copy(tweets = jsonSeq.map {n => tweetParser.parse(n) })
  }

  //implicit def json2Timeline(s: String): Timeline =  parse(s).toModel
  //implicit def json2TimelineF(f: Future[String]): Future[Timeline] =  f.map { parse(_).toModel }
}

trait UserParser extends Parser[User] {
  override def parse(node: JValue) = node.extract[ParseUser]

  //implicit def json2Tweet(s: String): User=  parse(s).toModel
  //implicit def json2TweetF(f: Future[String]): Future[User] =  f.map { parse(_).toModel }
}

/*
trait UserListParser extends Parser[ParseUserList] {

  override def parse(node: JValue): ParseUserList =  node.extract[ParseUserList]

  //implicit def json2UserLIst(s: String): UserList =  parse(s).toModel
  //implicit def json2UserListF(f: Future[String]): Future[UserList] = f.map { parse(_).toModel }
}
*/

