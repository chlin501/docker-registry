name := "registry"

organization := "suse"

version := "0.1"

scalaVersion := "2.11.8"

resolvers ++= Seq (
  "Apache repo" at "https://repository.apache.org/content/repositories/releases"
)

libraryDependencies ++= Seq (
  "com.google.code.findbugs" % "jsr305" % "3.0.0", 
  "com.github.docker-java" % "docker-java" % "3.0.0-RC3", 
  "org.slf4j" % "slf4j-log4j12" % "1.7.21",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
