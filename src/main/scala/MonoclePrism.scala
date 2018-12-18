import monocle.Prism
import monocle.macros.{GenIso, GenPrism}

object MonoclePrism {


 // getOption: S => Option[A]
 // reverseGet: A => S


//  val stringPrism: Prism[Json, String] = Prism[Json, String]{
//    case JStr(v) => Some(v)
//    case _ => None
//  }(str => JStr(str))

 val stringPrism: Prism[Json, String] = Prism.partial[Json, String]{case JStr(v) => v}(JStr)

 val sP: Prism[Json, JStr] = GenPrism[Json, JStr]


val sPFull = GenPrism[Json, JStr].composeIso(GenIso[JStr,String])

}






sealed trait Json
case object JNull extends Json
case class JStr(v: String) extends Json
case class JNum(v: Double) extends Json


