doc: casos_de_uso.png diagrama_de_clases.png casos_de_uso.pdf modelo_bd.pdf \
	acta_constitucion.pdf

casos_de_uso.png: casos_de_uso.dia
	dia -e casos_de_uso.png -t png casos_de_uso.dia

diagrama_de_clases.png: diagrama_de_clases.dia
	dia -e diagrama_de_clases.png -t png diagrama_de_clases.dia

casos_de_uso.pdf: casos_de_uso.odt
	libreoffice --convert-to pdf casos_de_uso.odt

modelo_bd.pdf: modelo_bd.odt
	libreoffice --convert-to pdf modelo_bd.odt

acta_constitucion.pdf: acta_constitucion.odt
	libreoffice --convert-to pdf acta_constitucion.odt

clean:
	rm casos_de_uso.png diagrama_de_clases.png casos_de_uso.pdf \
		modelo_bd.pdf acta_constitucion.pdf
	rm *~
