# Step : cache maven dependencies
FROM maven:3.6.3-jdk-8 as target
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

RUN echo "building Quantum starter kit"
ARG skipTests=true
RUN /usr/bin/git clone https://github.com/Perfecto-Quantum/Quantum-Starter-Kit /tmp/quantum &&  cd /tmp/quantum && mvn clean install -DskipTests=${skipTests}