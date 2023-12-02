# JtProject_SpringBoot_SQE

JtProject_SpringBoot_SQE is a Java application that an E-Commerce Application, cloned from GitHub.

## Table of Contents

- [Introduction](#introduction)
- [How to Use](#how-to-use)
- [Members](#Members)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The goal of this project is to determine quality of software produced.


## How to Use

1. Clone the repository to your local machine.
  
2. Download MySQL and make connection.

3. Download Dbeaver and connect it with MySQL.

4. Open the Project, from the pom.xml file.

5. In the application.properties file, change the password to accurate password.

6. In the AdminController.java, change the "execute" to "executeQuery" in Line # 240.

7. Click The Run Button, and open Local Host on Machine.
  
## Contributing

Contributions to this project are welcome. If you have ideas for improvements or new features, please open an issue or submit a pull request.

## Members

The Members of Group for this project are : 

1. Harris Khalid (21L-5808)
2. Javaria Shabbir (21L-6053)
3. Azma Amir (21L-6105)
4. Hadia Ahmad (21L-6104)

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Running JUnit Tests

To run JUnit tests, you can use Maven. Make sure you have Maven installed on your machine. Steps are : 

1. Add Maven Surefire Plugin to POM.xml:
    Add the Maven Surefire Plugin to your project's pom.xml file. This plugin allows you to run tests during the build process.
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version> <!-- Use the latest version -->
                <configuration>
                    <!-- Specify the package name or directory where your tests are located -->
                    <includes>
                        <include>com/example/**/*Test.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>

2. Run Tests via Command Line:
  After adding the Surefire Plugin, you can run tests using the following Maven command:

  mvn test

  This command will execute all tests in your project.
  
3. If you want to run specific tests or a single test class, you can use the -Dtest parameter:
    # Run a specific test class
    mvn test -Dtest=registertest
    
    # Run specific test methods in a test class
    mvn test -Dtest=registertest#testMethod1+testMethod2
   
    Adjust the class and method names accordingly.
    
    
