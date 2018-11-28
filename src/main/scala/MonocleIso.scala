import monocle.Iso



//Iso converts elements of type S into elements of A without any loss.

object MonocleIso {

//Video is equivalent to Tuple(Int, String) and Tuple(Int, String) equivalent to Video
 val videoToTuple = Iso[Video, (Int, String)](v => (v.id, v.title)){case (id, title) => Video(id, title)}

  def listToVector[A] = Iso[List[A], Vector[A]](_.toVector)(_.toList)

  def vectorToList[A] = Iso[Vector[A], List[A]](_.toList)(_.toVector)


 def stringToList = Iso[String, List[Char]](_.toList)(_.mkString(""))



}

case class Video(id: Int, title: String)

case class MyString(name: String)

