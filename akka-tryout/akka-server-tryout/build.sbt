name := "akka-server-tryout"

organization := "net.entelijan"

version := "1.0-SNAPSHOT"

scalaVersion in ThisBuild	:= "2.10.1"

libraryDependencies in ThisBuild  ++= Seq(
  "com.typesafe.akka" %% "akka-remote" % "2.1.4",
	"org.scalatest" %% "scalatest" % "1.9.1" % "test -> default" )

EclipseKeys.createSrc in ThisBuild := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.withSource in ThisBuild := true


