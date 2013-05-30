name := "akka-client-tryout"

organization := "net.entelijan"

version := "1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.10.0"

libraryDependencies in ThisBuild  ++= Seq(
	"com.typesafe.akka" %% "akka-remote" % "2.1.4",
	"net.entelijan" %% "akka-server-tryout" % "1.0-SNAPSHOT",
	"org.scalatest" %% "scalatest" % "1.9.1" % "test -> default" )

//scalacOptions += "-feature"
