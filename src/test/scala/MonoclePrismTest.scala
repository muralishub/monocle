import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import MonoclePrism._


class MonoclePrismTest extends  FlatSpec {

  "Prism" should "revel optional value using getOption" in {
   stringPrism.getOption(JStr("Sql")) shouldBe(Some("Sql"))
   sP.getOption(JStr("Sql")) shouldBe(Some(JStr("Sql")))
   sPFull.getOption(JStr("Sql")) shouldBe(Some("Sql"))
  }

  "Prism" should "revel Jstr using reverse get" in {
    stringPrism.reverseGet("Sql") shouldBe(JStr("Sql"))
    sP.reverseGet(JStr("Sql")) shouldBe(JStr("Sql"))
  }

  "Prism" should "allow us to modify" in {
    stringPrism.modify(_.toUpperCase)(JStr("Sql")) shouldBe(JStr("SQL"))
  }

  "Prism" should "allow us to use modifyOption" in {
    stringPrism.modifyOption(_.toUpperCase)(JStr("Sql")) shouldBe(Some(JStr("SQL")))
    stringPrism.modifyOption(_.toUpperCase)(JNum(2.0)) shouldBe(None)
  }

}
