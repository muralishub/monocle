


import org.scalatest.FlatSpec
import MonocleIso._
import org.scalatest.Matchers._

class MonocleIsoTest extends FlatSpec {

  "An ISO" should "make a Tuple(Int,  String) to Vidoe(id: Int, title: String)" in {
    assert(videoToTuple.get(Video(20, "Sql")) == (20, "Sql"))
    assert(videoToTuple((20, "Sql")) == Video(20, "Sql"))
    assert(videoToTuple.reverseGet((20, "Sql")) == Video(20, "Sql"))
  }

  "An Iso" should "make list to vector and vector to list" in {
    assert(listToVector.get(List(1, 2)) == Vector(1, 2))
    assert(listToVector(Vector(1, 2)) == List(1, 2))
    assert(listToVector.reverseGet(Vector(1, 2)) == List(1, 2))
  }


  "An Iso" should "make string to list" in {
    assert(stringToList.get("test") == List('t', 'e', 's', 't'))
    assert(stringToList(List('t', 'e', 's', 't')) == "test")

    stringToList.modify(_.tail)("test") should be("est")

  }






}
