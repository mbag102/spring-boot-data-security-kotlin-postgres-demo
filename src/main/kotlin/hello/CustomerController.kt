package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController @Autowired constructor(val repository: CustomerRepository) {

	@RequestMapping("/public")
	fun findAll() = repository.findAll()

	@RequestMapping("/{name}")
	fun findByLastName(@PathVariable name : String)
			= repository.findByFirstNameOrLastNameAllIgnoreCase(name, name)
}