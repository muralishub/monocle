import monocle.{Lens, PLens}
import VideoLenses._
import monocle.macros.GenLens

object MonocleLenses {

val video = Video(12, "Sql", Author(FirstName("mike")))

val modifiedVideo = video.copy(author = video.author.copy(firstName = video.author.firstName.copy("new name")))

// get(s: S): A
// S represents product and A is element inside product
// set(a: A): S => S

val titleLens = Lens[Video, String](video => video.title)(newTitle => video => video.copy(title = newTitle))



val videoLens: Lens[Video, String] = authorLens.composeLens(firstNameLens).composeLens(nameLens)

  val newVL = authorL.composeLens(firstNameL).composeLens(nameL)

}

object VideoLenses {

  val nameL: Lens[FirstName, String] = GenLens[FirstName](_.name)
  val firstNameL: Lens[Author, FirstName] = GenLens[Author](_.firstName)
  val authorL: Lens[Video, Author] = GenLens[Video](_.author)

  val authorLens = Lens[Video, Author](video => video.author)(newAuthor => video => video.copy(author = newAuthor))

  val firstNameLens = Lens[Author, FirstName](author => author.firstName)(newFirstName => author => author.copy(firstName = newFirstName))

  val nameLens: Lens[FirstName, String] = Lens[FirstName, String](firstName => firstName.name)(newFirstName => firstName => firstName.copy(name = newFirstName))

}




case class FirstName(name: String)
case class Author(firstName: FirstName)
case class Video(id: Int, title: String, author: Author)