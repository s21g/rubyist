import sbt._

class RubyistProject(info: ProjectInfo) extends DefaultProject(info) {
  val scalaTest = "org.scalatest" % "scalatest" % "1.2"
  val commonsIO = "commons-io" % "commons-io" % "2.0"
}

