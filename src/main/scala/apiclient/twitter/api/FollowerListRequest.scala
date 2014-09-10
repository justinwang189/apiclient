package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._
import com.twitter.util.Future
import apiclient.twitter._
import apiclient.twitter.model.UserList

class FollowerListRequest[C <: HasClient](
  val params: Map[String, String] = Map(),
  val client: Option[Client] = None
)
  extends ApiRequest[C, UserList]
  with UserListParser
  with ListRequestOptions[C]
{
  type Self[D <: HasClient] = FollowerListRequest[D]
  override val endpoint = "/1.1/followers/list.json"
  override def update[D <: HasClient](params: Map[String, String], client: Option[Client] = client) = new FollowerListRequest[D](params, client)

}

object FollowerListRequest{
  def apply(userId: Long) = new FollowerListRequest[NoClient].withUserId(userId)
}
