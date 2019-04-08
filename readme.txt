#got to ojdbc8.jar location and run below command to add jar file to mvn repo
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=10.2.0.3.0 -Dpackaging=jar -Dfile=ojdbc8.jar -DgeneratePom=true
