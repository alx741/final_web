doc:
	dia -e casos_de_uso.png -t png casos_de_uso.dia
	dia -e diagrama_de_clases.png -t png diagrama_de_clases.dia
	libreoffice --convert-to pdf casos_de_uso.odt
	libreoffice --convert-to pdf modelo_bd.odt
	libreoffice --convert-to pdf acta_constitucion.odt

clean:
	rm casos_de_uso.png diagrama_de_clases.png casos_de_uso.pdf \
		modelo_bd.pdf acta_constitucion.pdf
	rm *~
