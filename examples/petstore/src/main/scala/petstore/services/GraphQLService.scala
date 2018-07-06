package petstore.services

import cats.effect._
import org.http4s._
import org.http4s.dsl.io._

object GraphQLService {

  val service: HttpService[IO] = HttpService[IO] {
    case GET -> Root =>
      Forbidden()
    case POST -> Root =>
      Forbidden()
  }
}
