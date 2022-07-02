name := "event-hub-example-app"

version := "0.1"

scalaVersion := "2.13.8"
val AkkaVersion = "2.6.12"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream-kafka" % "2.1.1",
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion
)
