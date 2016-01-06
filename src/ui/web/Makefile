all: build deploy

build:
	ant clean
	ant

deploy:
	cp -rfv build/web /var/lib/tomcat-7-test/webapps/final
	sudo service tomcat-7-test restart
