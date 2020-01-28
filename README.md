# spring-boot-microservice-template
Template with minimum required dependencies for Bring Boot 2.x (exactly, 2.2.4)


The project assume the following project structure:
src/main/java
Production Java source.

src/main/resources
Production resources, such as XML and properties files.

src/test/java
Test Java source.

src/test/resources
Test resources.

src/sourceSet/java
Java source for the source set named sourceSet.

src/sourceSet/resources
Resources for the source set named sourceSet.


I do NOT recommend to change the structure (due to the possible change of developers between team).

If one need to change the structure, use this configuration:
sourceSets {
	main {
		java {
			srcDirs = ['src/main/java']
		}
		resources {
			srcDirs = ['src/main/resources']
		}
	}
	test {
		java {
			srcDirs = ['src/test/java']
		}
		resources {
			srcDirs = ['src/test/resources']
		}
	}
}

NOTE: please make sure there are no other symbols other than spaces, tabs and new lines.


