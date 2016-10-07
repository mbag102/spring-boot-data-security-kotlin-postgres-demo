package hello.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Customer(
		var firstName: String = "",
		var lastName: String = "",
		@Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
		var id: Long = 0
)
