package hello.repository

import hello.model.Role
import org.springframework.data.repository.CrudRepository

interface RoleRepository : CrudRepository<Role, Long> {

	fun findByName(name: String): Iterable<Role>
}
