name := "JMXTest"

version := "1.0"

lazy val `jmxtest` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws )

libraryDependencies ++= Seq(
  "org.jmxtrans.embedded" % "embedded-jmxtrans" % "1.0.15+",
  "com.kenshoo" %% "metrics-play" % "2.3.0_0.1.9"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  