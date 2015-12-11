DEST_DIR = ./generated

DOC_FILES = casos_de_uso.png diagrama_de_clases.png casos_de_uso.pdf \
			modelo_bd.pdf acta_constitucion.pdf


doc: $(addprefix $(DEST_DIR)/, $(DOC_FILES))

$(DEST_DIR)/casos_de_uso.png: casos_de_uso.dia
	dia -e $@ -t png casos_de_uso.dia

$(DEST_DIR)/diagrama_de_clases.png: diagrama_de_clases.dia
	dia -e $@ -t png diagrama_de_clases.dia

$(DEST_DIR)/casos_de_uso.pdf: casos_de_uso.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) casos_de_uso.odt

$(DEST_DIR)/modelo_bd.pdf: modelo_bd.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) modelo_bd.odt

$(DEST_DIR)/acta_constitucion.pdf: acta_constitucion.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) acta_constitucion.odt

clean:
	rm $(addprefix $(DEST_DIR)/, $(DOC_FILES))
