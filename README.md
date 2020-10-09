<img src="https://github.com/Perfecto-Quantum/Quantum-Starter-Kit/blob/master/DOC/image/perfecto.jpg" height="75" width="300"/>


# Quantum Starter Kit
This Quantum starter kit is designed to get you up and running using the Quantum framework (sponsored by [Perfecto](https://www.perfecto.io) and powered by [QAF](https://github.com/qmetry/qaf)) within few simple steps, and enable you to start writing your tests using simple [Cucumber] (https://cucumber.io/).

Begin with installing the dependencies below, and continue with the Getting Started procedure below.

### Dependencies
There are several prerequisite dependencies you should install on your machine prior to starting to work with Quantum:

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

* An IDE to write your tests on - [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr) or [IntelliJ](https://www.jetbrains.com/idea/download/#)

* [Maven](https://maven.apache.org/)

Eclipse users should also install:

1. [Maven Plugin](http://marketplace.eclipse.org/content/m2e-connector-maven-dependency-plugin)

2. [TestNG Plugin](http://testng.org/doc/download.html)

3. [QAF Cucumber Plugin](https://marketplace.eclipse.org/content/qaf-bdd-editors). Or go to  install new software option in eclipse, and download from https://qmetry.github.io/qaf/editor/bdd/eclipse/

IntelliJ IDEA users should also install:

1. [Maven Plugin for IDEA](https://plugins.jetbrains.com/plugin/1166)

2. [Cucumber Plugin (Community version only)](https://plugins.jetbrains.com/plugin/7212)

TestNG Plugin is built-in in the IntelliJ IDEA, from version 7 onwards.
 
#### Optional Installations
* For source control management, you can install [git](https://git-scm.com/downloads).
* To be able to interact with a real device from Perfecto cloud directly from your IDE, and use Perfecto Reporting, install [Perfecto CQ Lab Plugin](https://www.perfectomobile.com/ni/resources/downloads/add-ins-plugins-and-extensions) for your IDE.

## Downloading the Quantum Project

[Download](https://github.com/Project-Quantum/Quantum-Starter-Kit/archive/master.zip) the Quantum-Started-Kit repository.

After downloading and unzipping the project to your computer, open it from your IDE by choosing the folder containing the pom.xml file (_Quantum-Starter-Kit-master_, you might consider renaming it).

Look [here](https://github.com/PerfectoCode/Quantum/wiki/Project%20Layout) to understand the project layout, and find your way in it.

**********************
# Getting Started

<a target="_blank" href="https://youtu.be/FOHrWCuNPWI"><img src="https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/img/QuantumIntroThumbnail.png" alt="Quantum Framework Introduction and Getting Started"/></a>

Follow Quantum Starter Kit readme and run the POM.xml with the below goals:

clean install -B -Dremote.server=https://<<CLOUD NAME>>.perfectomobile.com/nexperience/perfectomobile/wd/hub/fast  -Dperfecto.capabilities.securityToken=<<SECURITY TOKEN>> -Dapplitools_key=<<APPLITOOLS KEY>>
