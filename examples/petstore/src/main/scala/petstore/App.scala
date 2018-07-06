package petstore

import cats.effect.IO
import fs2.{Stream, StreamApp}
import fs2.StreamApp.ExitCode
import org.http4s.server.blaze._
import petstore.services.{GraphQLService, StaticFileService}

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends StreamApp[IO] {
  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8888, "localhost")
      .mountService(StaticFileService.service, "/")
      .mountService(GraphQLService.service, "/graphql")
      .serve
}
