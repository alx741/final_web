DEPLOY_DIR='/var/lib/tomcat-7-test/webapps/final'


all: build deploy

build: clean
	mvn package

deploy:
	cp -rfv target/web-1.0-SNAPSHOT $(DEPLOY_DIR)
	mvn clean

clean:
	mvn clean
	rm -rfv $(DEPLOY_DIR)
