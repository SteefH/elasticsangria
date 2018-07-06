import sbt._
import Keys._
object Dependencies {
  object Versions {
    val elastic4s = "6.3.2"
    val http4s    = "0.18.14"
  }

  val elastic4s = libraryDependencies ++= Seq(
    "com.sksamuel.elastic4s" %% "elastic4s-core" % Versions.elastic4s,
    "com.sksamuel.elastic4s" %% "elastic4s-http" % Versions.elastic4s
  )

  val elastic4sEmbedded = libraryDependencies += "com.sksamuel.elastic4s" %% "elastic4s-embedded" % Versions.elastic4s

  val http4s = libraryDependencies ++= Seq(
    "org.http4s" %% "http4s-blaze-server" % Versions.http4s,
    "org.http4s" %% "http4s-circe"        % Versions.http4s,
    "org.http4s" %% "http4s-dsl"          % Versions.http4s
  )
}
