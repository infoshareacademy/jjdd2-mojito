#FROM jboss/wildfly:10.1.0.Final
#
#MAINTAINER "InfoShare Academy"
#
#COPY target/MohitoBikeProject.war /opt/jboss/wildfly/standalone/deployments/
#
#RUN wildfly/bin/add-user.sh admin admin --silent
#
#EXPOSE 8080
#EXPOSE 9990
#
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

FROM jboss/wildfly:latest

ADD config /opt/jboss/wildfly/config/

COPY target/MohitoBikeProject.war /opt/jboss/wildfly/config/

CMD ["/opt/jboss/wildfly/config/execute.sh"]