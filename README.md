# Spring-Security-MyWay

## First way of configuration the authentication and authorization process in Spring Security 

### Step1 

* Override the default implementation provided by spring security by changing the implementation of the two compnent UserDetailsService 

```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter  {


    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();
        var user = User.withUsername("chaker").password("1234")
                .authorities("read").build();

        userDetailsService.createUser(user);
        return userDetailsService ;

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests().anyRequest().authenticated();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
        }
   ``` 
        
  As the code example show we override the default implementation by adding a new ProjectConfig class annoted with @Configuration to tell spring that he should take this class as configuration Bean in the applicationContext file
  , then we add a userDetailService method annoted with @Bean that return a new UserDetailsService object responsible for managing the user details then we instiate a object userDetailsService of type MemortUserDetailsManager() to store user credentials 
  in Memory we shouldn't use this approach for production we should persist the credentials in database but the purpose of this code demo to show how to override the default configuration of spring then we create a new User calling the User object provided by spring and assigned it to a user object and adding a username , password , and authorites to the user we call the user Details service to create the user desired . If we change the default UserDetailsService we should alse change the PasswordEncoder also implementation in this cas we call NoOpPassword.getInstance() to prevent spring from hashing the password again this shouldn't applied to production but just a code example and Finally we override the authorization process by telling spring every endpoint in the project require autehntification to be accessed . 
  
  
  
  





