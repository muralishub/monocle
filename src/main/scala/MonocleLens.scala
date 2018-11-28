import monocle.Lens
import monocle.macros.GenLens


object MonocleLens {



  val personObject: Person = Person(Address(2, "test"), "name")

  val modifyPerson: Person = personObject.copy(address = personObject.address.copy(stNo = 3))

  //Lens is an optic used to zoom inside Product eg: case class, Tuple, HList, or even Map

  //Lens take 2 type parameters S and A. S is product and A is element


  val address = Address(1, "canon st")

  val streetNo = Lens[Address, Int](_.stNo)(n => a => a.copy(stNo = n))

  val person = Lens[Person, Address](_.address)(a => p => p.copy(address = a))




  val newPerson = GenLens[Person](_.address)









}


case class Address(stNo: Int, streetName: String)
case class Person(address: Address, name: String)