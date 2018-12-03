

name := "monocle"



scalaVersion := "2.12.7"
val monocleVersion = "1.5.0" // 1.5.0-cats based on cats 1.0.x

libraryDependencies ++= Seq(
  "com.github.julien-truffaut" %%  "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %%  "monocle-macro" % monocleVersion,
  "com.github.julien-truffaut" %%  "monocle-law"   % monocleVersion % "test",
"org.scalatest" %% "scalatest" % "3.0.5" % "test")