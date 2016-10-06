package hello

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

	fun findByUsernameIgnoreCase(username: String): Iterable<User>
}
