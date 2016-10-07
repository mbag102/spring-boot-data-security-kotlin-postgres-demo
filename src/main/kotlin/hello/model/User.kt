package hello.model

import hello.model.Role
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

/**
 * Created by mbagliojr on 10/5/16.
 */

@Entity(name = "t_user")
class User(@Column(unique = true) var username: String? = "",
           var password: String? = "",
           @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.PERSIST), targetEntity = Role::class)
                 @JoinTable(name = "user_role",
                         joinColumns = kotlin.arrayOf(JoinColumn(name = "user_id")),
                         inverseJoinColumns = arrayOf(JoinColumn(name = "role_id")))
                 var authorities: MutableSet<Role>? = mutableSetOf(),
           @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
                 var id: Long = 0) {

    fun asUserDetails() : UserDetails {
        return User(username, password, authorities)
    }
}
