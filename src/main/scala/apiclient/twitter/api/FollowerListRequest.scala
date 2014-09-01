package apiclient.twitter.api

import apiclient.common.{hasClient, Client}
import apiclient.twitter.model._
import com.twitter.util.Future
import apiclient.twitter._

class FollowerListRequest(
  userId: UserId,
  p: Map[String, String] = Map()
) extends ListRequest {

  type Self <: FollowerListRequest

  override val endpoint = "/1.1/followers/list.json"
  override val params = p ++ Map("id" -> userId.toString)

  override def update(params: Map[String, String]) = new FollowerListRequest(userId, params).asInstanceOf[Self]
  def withClient(client: Client) = new FollowerListRequestBuilt(userId, params, client)

}

class FollowerListRequestBuilt(userId: UserId, override val params: Map[String, String], val client: Client)
  extends FollowerListRequest(userId)
  with hasClient[UserList]
  with UserListParser
{
  type Self = FollowerListRequestBuilt

  override def sendRequest(): Future[UserList] = client(this.fullUrl).getFuture[String]()
  override def update(newParams: Map[String, String]) = new FollowerListRequestBuilt(userId, newParams, client)

}
