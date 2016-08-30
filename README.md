# Notes
Notes can help you to create notes.

The technologies, that are used:
- JSP, JS, CSS, JQuery (Ajax)
- Maven
- Tomcat
- JUnit, Mockito
- Hibernate, MySQL
- Spring MVC
- Shell

## Running
1. Configure war for deploy with necessaries libraries (i.e. _.idea/artifacts/Notes_Web_exploded.xml_)
2. Configure user of tomcat (i.e. _target/tomcat/conf/tomcat_users.xml_)
3. Create DB 'NotesWeb' (i.e. _NotesWeb-DDL.txt_)
> If you use Linux, you can execute _createDB.sh_

> If 'username' and 'password' aren't 'root', you must change this parameters on _src/main/resources/hibernate.cgf.xml_
4. `mvn tomcat7:run`
5. Follow to the link: [_http://localhost:8080/_](http://localhost:8080")

## Goals
- [X] encoding UTF-8
- [ ] support Spring Security
- [ ] add log
- [ ] add properties