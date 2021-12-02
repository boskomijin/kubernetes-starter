# Getting Started

### Spring boot application

Spring boot application is developed as starter application which uses:
* Java 17,
* Spring boot, version 2.6.0
* Added static analyzers (checkstyle, pmd, spotbugs)
* Added jacoco code coverage

### Build tools
* Application is realized with gradle build tool over the gradle wrapper with version 7.3.0.

### Containers
* Application is containerized over the jib plugin.

### Kubernetes
Application is prepared for microk8s kubernetes version.
Prerequisites for microk8s:
* microk8s is installed on host system,
* registry is enabled,
* dns is enabled.

Note: The application ca be run locally in kubernetes over the skaffold from the terminal, or over the cloud code (idea plugin) directly from ide. Also, application can be run without kubernetes as every spring boot application.