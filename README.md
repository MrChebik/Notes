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
1. `mvn tomcat7:run`
2. Follow to the link: [_http://localhost:8080/_](http://localhost:8080")

## Info about running
* Of course, if you want to run, you must create _'artifact'_ or setting exists for run `mvn tomcat7:run`. I save settings of my artifacts in _.idea/artifacts/**_. You can find that, whats libraries was used.
* Files, from the _target/tomcat/conf/**_ are temp files, which can help you to run Tomcat7.
* I not recommend execute `mvn clean` or `mvn tomcat7:deploy`, because I can't to settings Tomcat for the server (I'm try /etc/tomcat, /usr/share/tomcat, and path, where was tomcat for IntelliJ IDEA). So, if you make `mvn clean`, you can execute `mvn tomcat7:run-war` then setting again _tomat-users.xml_ or make revert from git.
>Example _tomcat-users.xml_:
>```
><tomcat-users>
>   <role rolename="manager-script"/>
>   <user username="admin" password="password" roles="manager-script" />
></tomcat-users>
>```