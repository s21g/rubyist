organization := "s21g"

name := "rubyist"

version := "0.1.7"

libraryDependencies <+= scalaVersion( "org.scala-lang" % "scala-compiler" % _ )
libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-lang3" % "3.1",
  "commons-io" % "commons-io" % "2.4"
)
