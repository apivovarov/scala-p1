lazy val commonSettings = Seq(
  scalaVersion := "2.10.4"
)

lazy val appSettings = Seq(
  organization := "com.example",
  name := "scala-p1",
  version := "0.1.0"
)

// Dependency versions
lazy val javaVersion = "1.7"
lazy val scalaCheckVersion = "1.12.2"
lazy val scalaTestVersion = "2.2.4"
lazy val sparkVersion = "1.4.0"

lazy val sparkLib = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-hive" % sparkVersion % "provided" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided" withSources() withJavadoc()
)

lazy val testLib = Seq(
  "org.scalacheck" %% "scalacheck" % scalaCheckVersion % Test withSources() withJavadoc(),
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test withSources() withJavadoc()
)

lazy val javaOpts = Seq("-source", javaVersion)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(appSettings: _*).
  settings(
    libraryDependencies ++= sparkLib,
    libraryDependencies ++= testLib,
    javacOptions ++= javaOpts
  )
