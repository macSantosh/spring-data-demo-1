Prerequisites:
  1. Maven
  2. Jboss / choice of your web server
  3. JDK 1.8
  
#1.Add QQAppRead datasource in jboss standalone.xml or edit application context file to specify datasource details

#2. go to ojdbc8.jar location on your machine and run below command to add jar file to mvn repo
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=10.2.0.3.0 -Dpackaging=jar -Dfile=ojdbc8.jar -DgeneratePom=true

#3.import this project as maven project and update maven repo. (right click on project->maven->update project)

#4.run project on jboss. 
