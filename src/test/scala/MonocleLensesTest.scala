import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import MonocleLenses._

class MonocleLensesTest extends FlatSpec {

  val video = Video(12, "Sql", Author(FirstName("mike")))

  "Lens" should "allow us to get title from video" in {
     titleLens.get(video) shouldBe "Sql"
  }

  "Lens" should "allow us to set title for video" in {
    titleLens.set("begining sql")(video) shouldBe Video(12, "begining sql", Author(FirstName("mike")))
  }

   "Lens" should "allow us to modify title for video" in {
     titleLens.modify(_.toUpperCase)(video) shouldBe Video(12, "SQL", Author(FirstName("mike")))
   }

  "Lens" should "allow us to modify author" in {
    newVL.modify(_.toUpperCase)(video) shouldBe Video(12, "Sql", Author(FirstName("MIKE")))
    videoLens.modify(_.toUpperCase)(video) shouldBe Video(12, "Sql", Author(FirstName("MIKE")))
  }


}
