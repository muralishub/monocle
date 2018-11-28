import org.scalatest.FunSuite

import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import MonocleLens._

class MonocleLensTest extends FlatSpec {



  "World without Lens" should "be hard to modify values if nested deep" in {
    address.copy(stNo = 2, "canon st") shouldBe(Address(2, "canon st"))
    modifyPerson shouldBe(Person(Address(3, "test"), "name"))
  }

  "A Lens" should "modify product" in {

    streetNo.get(Address(2, "canon st")) shouldBe(2)
    streetNo.set(3)(Address(2, "canon st")) shouldBe(Address(3, "canon st"))

    person.get(Person(Address(2, "c"), "c")) shouldBe(Address(2, "c"))

    person.set(Address(3, "new"))(Person(Address(2, "s"), "name")) shouldBe(Person(Address(3, "new"), "name"))


    newPerson.set(Address(5, "new"))(Person(Address(2, "s"), "name")) shouldBe(Person(Address(5, "new"), "name"))




  }


}
