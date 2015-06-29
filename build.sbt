name := "JMXTest"

version := "1.0"

lazy val `jmxtest` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws )

libraryDependencies ++= Seq(
  "org.jmxtrans.embedded" % "embedded-jmxtrans" % "1.0.15+"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  