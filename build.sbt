name := "JMXTest"

version := "1.0"

lazy val `jmxtest` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws )

libraryDependencies ++= Seq(
  "io.kamon" %% "kamon-core" % "0.4.0+",
  "io.kamon" %% "kamon-system-metrics" % "0.4.0+",
  "io.kamon" %% "kamon-statsd" % "0.4.0+"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  