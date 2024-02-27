clean:
	./gradlew clean

run:
	./gradlew run

build:
	./gradlew clean build

install-dist:
	./gradlew clean installDist

run-dist:
	./app/build/install/app/bin/app

check-deps:
	./gradlew dependencyUpdates -Drevision=release
