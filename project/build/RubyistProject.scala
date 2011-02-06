import sbt._

class RubyistProject(info: ProjectInfo) extends ProguardProject(info) {
  val scalaTest = "org.scalatest" % "scalatest" % "1.2"
  val commonsIO = "commons-io" % "commons-io" % "2.0"

  def keepMainClass = """
    -keepclasseswithmembers public class * {
      public static void main(java.lang.String[]);
    }
    """
  override def proguardDefaultArgs = "-dontwarn" :: "-dontoptimize" ::
    "-dontobfuscate" :: keepMainClass  ::  proguardOptions
}

