import sbt._
import Keys._

object SumosimBuild extends Build {
    lazy val saturn = Project(id = "saturn",
                            base = file(".")) aggregate(pan, pandora, janus)

    lazy val pan = Project(id = "pan",
                           base = file("pan"))

    lazy val pandora = Project(id = "pandora",
                           base = file("pandora"))

    lazy val janus = Project(id = "janus",
                           base = file("janus"))


}

