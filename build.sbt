ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "data-extract-loading"
  )

libraryDependencies ++= Seq(
  //"com.oracle.database.jdbc" % "ojdbc8" % "21.3.0.0",
  "org.postgresql" % "postgresql" % "42.5.1",
  "com.github.tototoshi" %% "scala-csv" % "1.3.10"

)