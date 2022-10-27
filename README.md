# Override the AuthenticationProvider implementation by creating CustomAuthenticationProvider 




```
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}

``` 


# Implement my own authenticationLogic 
```
package com.example.ssiach2ex1.configurations;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        // This condition generally calls
        //UserDetailsService and
        //PasswordEncoder to test the
        //username and password.
        if("chaker".equals(username) && "1234".equals(password)){
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        }
        else {
            throw new AuthenticationCredentialsNotFoundException("Error in authentication ! ");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
}
```
*In the configuration class, you can register the AuthenticationProvider in the
configure(AuthenticationManagerBuilder auth) method shown in the following
listing.
``` 
@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider ;

    @Override
    protected  void configure(AuthenticationManagerBuilder auth)throws Exception {
        auth.authenticationProvider(authenticationProvider);


    }
    @Override

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests().anyRequest().authenticated();
    }


        }
```


