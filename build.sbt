lazy val commonSettings = Seq(
  scalaVersion := "2.10.4"
)

lazy val appSettings = Seq(
  organization := "com.example",
  name := "scala-p1",
  version := "0.1.0"
)

// Versions
lazy val scalaCheckVersion = "1.12.2"
lazy val scalaTestVersion = "2.2.4"
lazy val javaVersion = "1.7"
lazy val sparkVersion = "1.4.0"

lazy val sparkLibs = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-hive" % sparkVersion % "provided" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided" withSources() withJavadoc()
)

lazy val scalaAuxLibs = Seq(
  "org.scalacheck" %% "scalacheck" % scalaCheckVersion % Test withSources() withJavadoc(),
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test withSources() withJavadoc()
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(appSettings: _*).
  settings(
    libraryDependencies ++= sparkLibs,
    libraryDependencies ++= scalaAuxLibs
  )
