package apiclient.twitter.api

import apiclient.common.{ApiRequest, hasClient, Client}
import apiclient.twitter.model._
import com.twitter.util.Future
import apiclient.twitter._

class UserLookupRequest(
  userId: UserId,
  p: Map[String, String] = Map()
) extends ApiRequest {

  type Self <: UserLookupRequest

  override val endpoint = "/1.1/users/lookup.json"
  override val params = p ++ Map("user_id" -> userId.toString)

  override def update(params: Map[String, String]) = new UserLookupRequest(userId, params).asInstanceOf[Self]
  def withClient(client: Client) = new UserLookupRequestBuilt(userId, params, client)

}

class UserLookupRequestBuilt(userId: UserId, override val params: Map[String, String], val client: Client)
  extends UserLookupRequest(userId)
  with hasClient[User]
  with UserParser
{
  type Self = UserLookupRequestBuilt

  override def sendRequest(): Future[User] = client(this.fullUrl).getFuture[String]()
  override def update(newParams: Map[String, String]) = new UserLookupRequestBuilt(userId, newParams, client)
}
