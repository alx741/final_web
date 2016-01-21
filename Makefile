all: web doc

doc: doc/generated

doc/generated:
	cd doc && make all

web:
	cd src/web && make

clean:
	cd doc && make clean
	cd src/web && make clean
