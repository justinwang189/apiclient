package apiclient.common

import org.json4s._
import apiclient.twitter.parser.ParseModel
import org.json4s.native.JsonMethods

trait Parser[M <: Model] {
  implicit val formats = DefaultFormats

  def parseModel(json: String): M = parse(json).toModel
  def parse(json: String): ParseModel[M] = parse(JsonMethods.parse(json))
  def parse(node: JValue): ParseModel[M]
}
