kafka-storm-implementation
==========================

A simple Kafka Storm implementation using Kafka 0.8.1.1 and Storm 0.9.2. It uses storm kafka extrenal connector.


Since, oracle jars are not part of maven repository, download the following jars and install it in your server

mvn install:install-file -Dfile=jms-1.1.jar -DgroupId=javax.jms -DartifactId=jms -Dversion=1.1 -Dpackaging=jar

mvn install:install-file -Dfile=jmxtools-1.2.1.jar -DgroupId=com.sun.jdmk -DartifactId=jmxtools -Dversion=1.2.1 -Dpackaging=jar

mvn install:install-file -Dfile=jmxri-1.2.1.jar -DgroupId=com.sun.jmx -DartifactId=jmxri -Dversion=1.2.1 -Dpackaging=jar