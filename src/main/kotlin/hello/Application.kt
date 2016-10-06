package hello

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
open class Application {

	private val log = LoggerFactory.getLogger(Application::class.java)

	@Bean
	open fun objectMapperBuilder()
		= Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())

	@Bean
	open fun init(customerRepository: CustomerRepository, roleRepository: RoleRepository, userRepository: UserRepository) = CommandLineRunner {
		// save a couple of customers
		customerRepository.save(Customer("Jack", "Bauer"))
		customerRepository.save(Customer("Chloe", "O'Brian"))
		customerRepository.save(Customer("Kim", "Bauer"))
		customerRepository.save(Customer("David", "Palmer"))
		customerRepository.save(Customer("Michelle", "Dessler"))

		//Rely on cascade to populate Roles
		userRepository.save(User("admin", "admin", mutableSetOf(Role("ROLE_ADMIN"))))
		userRepository.save(User("user", "user", mutableSetOf(Role("ROLE_USER"))))
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args)
}
