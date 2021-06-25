# Concepts Covered

**Spring Profiles**  
@ActiveProfiles("test"), create file with '-test' suffix, application-test.yml, define h2 datasource in this file.

**Autoconfigure database for test**  
@DataJpaTest, create import.sql and schema.sql, which will be read by spring automatically during db setup.

**Create composite key in entity**  
@EmbeddedId, @Embeddable

**Lombok**  
Add maven-compiler-plugin, and add annotationProcessorPaths under it, to enable lombok. Enable lombok in IntelliJ using preference.  
@Data @Builder @NoArgsConstructor @AllArgsConstructor

**Mapstruct**  
Add maven-compiler-plugin, and add annotationProcessorPaths under it, to enable mapstruct. Create a interface and annotate with @Mapper and add a abstract method, whose implementation will be provided by mapstruct. Map value from one object or pojo to another.

**maven-compiler-plugin**  
When you run mvn clean install, it start the maven lifecycle, each lifecycle method is linked to a maven plugin.  

--  start  
**maven-clean-plugin** - delete target folder  
**jacoco-maven-plugin** - prepare jacoco agent  
**maven-resources-plugin** - scans and copies resource file  
**maven-compiler-plugin** - compile the code  
**maven-resources-plugin:3.2.0:testResources** - scans and copies test resource file  
**maven-compiler-plugin:3.8.1:testCompile** - compile test cases code  
**maven-surefire-plugin** - run test cases  
**jacoco-maven-plugin:0.8.7:report** - generate coverage report  
**maven-jar-plugin:3.2.0:jar** - generate jar file for code  
**spring-boot-maven-plugin:2.5.0:repackage** - repackage the code to include embedded tomcat and spring items  
**jacoco-maven-plugin:0.8.7:check** - run code coverage  
-- end

**spring-boot-maven-plugin**  
repackages the jar generated by maven, along with embedded tomcat and spring items.

**Jacoco**  
jacoco-maven-plugin,  
- prepare agent  
- generate report, default is html (target/site/jacoco/index.html) 
- check coverage, provide the code coverage ratio required and files to be excluded in coverage, in configuration.
