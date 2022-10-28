# Summary 

* Spring Boot provides some default configurations when you add Spring Security
  to the dependencies of the application.
* You implement the basic components for authentication and authorization:
  UserDetailsService, PasswordEncoder, and AuthenticationProvider.
* You can define users with the User class. A user should at least have a username,
  a password, and an authority. Authorities are actions that you allow a
  user to do in the context of the application.
* A simple implementation of a UserDetailsService that Spring Security provides
  is InMemoryUserDetailsManager. You can add users to such an instance
  of UserDetailsService to manage the user in the application’s memory.
* The NoOpPasswordEncoder is an implementation of the PasswordEncoder
  contract that uses passwords in cleartext. This implementation is good for
  learning examples and (maybe) proof of concepts, but not for productionready
  applications.
* You can use the AuthenticationProvider contract to implement custom
  authentication logic in the application.
* There are multiple ways to write configurations, but in a single application, you
  should choose and stick to one approach. This helps to make your code cleaner
  and easier to understand.