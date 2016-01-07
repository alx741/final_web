DEPLOY_DIR='/var/lib/tomcat-7-test/webapps/final'


all: build deploy

build: clean
	mvn package

deploy:
	cp -rfv target/web-1.0-SNAPSHOT $(DEPLOY_DIR)
	sudo service tomcat-7-test restart

clean:
	mvn clean
	rm -rfv $(DEPLOY_DIR)
