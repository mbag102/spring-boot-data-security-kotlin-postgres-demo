package hello

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by mbagliojr on 10/5/16.
 */

@Entity
class Role(var name: String = "",
           @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
           var id: Long = 0) : GrantedAuthority {
    override fun getAuthority(): String {
        return name
    }

}