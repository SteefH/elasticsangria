package petstore
object model {

  case class Pet(id: Int,
                 category: PetCategory,
                 name: String,
                 photoUrls: List[String],
                 tags: List[PetTag],
                 status: PetStatus)

  sealed trait PetStatus
  case object Available extends PetStatus
  case object Pending   extends PetStatus
  case object Sold      extends PetStatus

  case class PetCategory(id: Int, name: String)

  case class PetTag(id: Int, name: String)

}
