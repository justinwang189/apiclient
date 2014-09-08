package apiclient.twitter.api

import apiclient.common._
import apiclient.twitter.model._

/*
class UserLookupRequest[C <: HasClient](
  val params: Map[String, String] = Map(),
  val client: Option[Client] = None
)
  extends ListRequest[C, UserList]
  with UserListParser
{
  type Self = UserLookupRequest[C]
  override val endpoint = "/1.1/users/lookup.json"
  override def update(params: Map[String, String]) = new UserLookupRequest[C](params, client).asInstanceOf[Self]
  def withClient(client: Client) = new UserLookupRequest[WithClient](params, Some(client))
}

object UserLookupRequest {
  def apply(userId: Long) = new UserLookupRequest[NoClient].withUserId(userId)
}
*/
