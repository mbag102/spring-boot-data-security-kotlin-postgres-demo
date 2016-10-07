package hello.spring

import org.springframework.security.core.AuthenticationException
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import javax.servlet.http.HttpServletRequest

/**
 * Created by mbagliojr on 10/6/16.
 */
class BasicAuthEntryPoint() : BasicAuthenticationEntryPoint() {
    companion object {
        @JvmField
        val REALM = "MY_TEST_REALM"
    }

    override fun commence(request : HttpServletRequest,
                          response : HttpServletResponse,
                          authException: AuthenticationException) {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + realmName + "");
    }

    override open fun afterPropertiesSet() {
        realmName = REALM
        super.afterPropertiesSet();
    }
}