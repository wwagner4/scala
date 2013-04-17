version in ThisBuild := "1.0-SNAPSHOT"

organization in ThisBuild	:= "net.entelijan"

scalaVersion in ThisBuild	:= "2.10.1"

publishTo in ThisBuild := Some("entelijan-repo" at "http://entelijan.net/artifactory/repositories/libs-ivy-local/")

resolvers in ThisBuild ++= Seq(
	"typesafe" at "http://repo.typesafe.com/typesafe/releases/",
	"entelijan" at "http://entelijan.net/artifactory/repo/" )

libraryDependencies in ThisBuild ++= Seq(
  	"org.scalatest" %% "scalatest" % "1.9.1" % "test")

    
    
    
