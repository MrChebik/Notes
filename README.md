# Notes
Notes can help you to create notes.

The technologies, that are used:
- Servlet
- JSP, JS, CSS
- Maven
- Tomcat
- JUnit, Mockito
- Hibernate
- Spring MVC

## Running
1. Configure war for deploy with necessaries libraries (i.e. _.idea/artifacts/Notes_Web_exploded.xml_)
2. If you can configure Tomcat:
 - Setting _tomcat-users.xml_:
 ```
 <role rolename="manager-script"/>
 <user username="admin" password="password" roles="manager-script" />
 ```
 - `mvn tomcat7:deploy`

else
 - `mvn tomcat7:run`
 - Follow to the link: [_http://localhost:8080/_](http://localhost:8080")

## Goals for the future
- [ ] encoding UTF-8
- [ ] support Spring Security