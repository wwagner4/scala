import sbt._
import Keys._

object SumosimBuild extends Build {
    lazy val root = Project(id = "sun",
                            base = file(".")) aggregate(earth, saturn, mars, phobos, daemon)

    lazy val earth = Project(id = "earth",
                           base = file("earth"))

    lazy val saturn = Project(id = "saturn",
                           base = file("saturn"))

    lazy val mars = Project(id = "mars",
                           base = file("mars"))

    lazy val phobos = Project(id = "phobos",
                           base = file("mars/phobos"))

    lazy val daemon = Project(id = "daemon",
                           base = file("mars/daemon"))

}

