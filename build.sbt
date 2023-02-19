ThisBuild / version := "1.0.1"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "application-config-util"
  )

libraryDependencies ++= Seq(
  //"com.oracle.database.jdbc" % "ojdbc8" % "21.3.0.0",
  "org.postgresql" % "postgresql" % "42.5.1",
  "com.github.tototoshi" %% "scala-csv" % "1.3.10",
  "com.typesafe" % "config" % "1.4.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
)