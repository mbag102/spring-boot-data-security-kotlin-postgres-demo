package hello

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {

	fun findByFirstNameOrLastNameAllIgnoreCase(firstName: String, lastName: String): Iterable<Customer>
}
