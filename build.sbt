name := "raisapp"

version := "1.0"

scalaVersion := "2.11.8"



val sprayVersion = "1.3.3"

val json4snVersion = "3.4.1"

libraryDependencies += "io.spray" % "spray-can_2.11" % sprayVersion

libraryDependencies ++=
  Seq("io.spray" % "spray-httpx_2.11" % sprayVersion
        exclude("org.scala-lang.modules","scala-xml_2.11_1.0.3")
   )


libraryDependencies += "io.spray" % "spray-routing_2.11" % sprayVersion

libraryDependencies += "io.spray" % "spray-testkit_2.11" % sprayVersion % "test"

val akkaVersion = "2.4.10"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % akkaVersion

libraryDependencies += "org.json4s" % "json4s-native_2.11" % json4snVersion

libraryDependencies += "org.json4s" % "json4s-jackson_2.11" % json4snVersion

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"

libraryDependencies += "com.typesafe.slick" % "slick_2.11" % "3.1.1"

libraryDependencies += "com.typesafe.slick" % "slick-codegen_2.11" % "3.1.1"

libraryDependencies += "com.typesafe.slick" % "slick-hikaricp_2.11" % "3.1.1"

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.18"

libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.5.8"

libraryDependencies += "com.typesafe.akka" % "akka-http-experimental_2.11" % "2.4.11"

libraryDependencies += "com.typesafe.akka" % "akka-http-core_2.11" % "2.4.11"

libraryDependencies += "com.typesafe.akka" % "akka-stream_2.11" % "2.4.11"

libraryDependencies += "com.typesafe.akka" % "akka-http-spray-json-experimental_2.11" % "2.4.11"


