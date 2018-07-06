package petstore.services

import cats.effect._
import org.http4s._
import org.http4s.dsl.io._

object StaticFileService {

  private def static(file: String, request: Request[IO]) =
    StaticFile.fromResource("/static-assets/" + file, Some(request)).getOrElseF(NotFound())

  val service: HttpService[IO] = HttpService[IO] {
    case request @ GET -> Root / path if List(".js", ".css", ".map", ".html", ".webm").exists(path.endsWith) =>
      static(path, request)
    case request @ GET -> Root => static("index.html", request)
  }
}
