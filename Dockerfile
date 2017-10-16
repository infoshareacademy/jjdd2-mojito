FROM jboss/wildfly:10.1.0.Final

MAINTAINER "InfoShare Academy"

COPY target/MohitoBikeProject.war wildfly/standalone/deployments/