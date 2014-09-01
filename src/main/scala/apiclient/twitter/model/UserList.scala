package apiclient.twitter.model

case class UserList (
  users: Seq[User],
  cursor: Option[Cursor] = None
)

class Cursor
