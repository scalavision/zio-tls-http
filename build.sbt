//val ZioVersion    = "1.0.3"
val ZioVersion    = "1.0.3+114-b9a22815-SNAPSHOT"

// val Specs2Version = "4.7.0"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

lazy val root = (project in file("."))
  .settings(
    organization := "ZIO",
    name := "zio-tls-http",
    version := "0.0.1",
    scalaVersion := "3.0.0-M2",
    maxErrors := 3,
    retrieveManaged := true,
    libraryDependencies ++= Seq(
      "dev.zio"    %% "zio"         % ZioVersion,
      "io.argonaut" %% "argonaut" % "6.3.3",
      "com.lihaoyi" % "upickle_3.0.0-M2" % "1.2.2",
      // "dev.zio" %% "zio-json" % "0.0.1",
      "dev.zio" %% "zio-test" % ZioVersion % Test,
      "dev.zio" %% "zio-test-sbt" % ZioVersion % Test
    ),
     testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )

// Refine scalac params from tpolecat
scalacOptions --= Seq(
  "-Xfatal-warnings"
)

//addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("chk", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
