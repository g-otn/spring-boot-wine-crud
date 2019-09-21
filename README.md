# spring-boot-wine-crud
A wine crud made using Spring Boot. This is the project for the [AlgaWorks](https://www.algaworks.com/)'s Spring Boot course.

## Features
- Create, read and update of wine
- Login with hard-coded users and roles
- Wine image upload and storage with s3Ninja
<details>
  <summary>Click to show screenshots</summary>
  
![read page](https://user-images.githubusercontent.com/44736064/65379874-3a29a380-dca6-11e9-9363-3e17eab17dae.png)
![create page](https://user-images.githubusercontent.com/44736064/65379876-3a29a380-dca6-11e9-86c0-16214ce01d08.png)
![wine page](https://user-images.githubusercontent.com/44736064/65379878-3a29a380-dca6-11e9-9ee7-ea133b5d118e.png)
![wine page upload](https://user-images.githubusercontent.com/44736064/65379879-3ac23a00-dca6-11e9-89c5-3adcace4fc66.png)
</details>

## Installation
1. Setup your environment for Spring Framework and to open this project.
2. Install the Maven dependencies.
3. Install [MySQL](https://www.mysql.com/)
4. [Setup your MySQL](https://dev.mysql.com/doc/mysql-getting-started/en/#mysql-getting-started-connecting) 
to create your user and database.
5. In the project, change the `src/main/resources/application.properties` file to match your MySQL credentials and database URL.
6. (Optional) Go to `src/main/java/com/algaworks/vinho/config/SecurityConfig.java` to view the hard coded users and/or
add your own user and their role(s):
   - Available roles: `LISTAR_VINHO` (permission to read) and `CADASTRAR_VINHO` (permission to create/update).
```java
// ...
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("USERNAME_HERE").password("{noop}PASSWORD_HERE").roles("CADASTRAR_VINHO", "LISTAR_VINHO");
}
// ...
```
7. Download [s3Ninja](https://s3ninja.net/) (project developed with s3Ninja [version 2.7](https://oss.sonatype.org/content/groups/public/com/scireum/s3ninja/2.7/)).
8. Start s3Ninja by navigating to its folder and running the `IPL.class` file: `java IPL`.
9. (Likely to not be needed) In the project, go to the `src/main/java/com/algaworks/vinho/config/AmazonConfig.java` and change
the credentials to match the one specified by s3Ninja (displayed at `localhost:9444`).
```java
// ...
    AWSCredentials credentials = new BasicAWSCredentials("ACCESS KEY HERE", "SECRET KEY HERE");
    // ...
```
10. Build and run the project. By accessing http://localhost:8080, you should be redirected to the `/login` page.

PS: Flyway should create the necessary table automatically when you run the project. If not, use the SQL scripts located at 
`src/main/resources/db.migration`.

## Acknowledgements
[leluque](https://github.com/leluque) for assigning me this project's course.
