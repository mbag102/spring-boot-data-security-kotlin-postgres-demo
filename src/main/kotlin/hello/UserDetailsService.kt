package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by mbagliojr on 10/5/16.
 */

@Service
class UserDetailsService @Autowired constructor(val repository: UserRepository) : org.springframework.security.core.userdetails.UserDetailsService {

    @Transactional
    override fun loadUserByUsername(username: String?): UserDetails? {
        if(username != null) {
            val results = repository.findByUsernameIgnoreCase(username!!)
            return results?.firstOrNull()?.asUserDetails()
        }

        return null

    }

}