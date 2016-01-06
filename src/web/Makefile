DEPLOY_DIR='/var/lib/tomcat-7-test/webapps/final'


all: build deploy

build: clean
	ant

deploy:
	cp -rfv build/web $(DEPLOY_DIR)
	sudo service tomcat-7-test restart

clean:
	ant clean
	rm -rfv $(DEPLOY_DIR)
