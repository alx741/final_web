DEST_DIR="./generated"

DOC_FILES=$(DEST_DIR)/casos_de_uso.png $(DEST_DIR)/diagrama_de_clases.png \
	$(DEST_DIR)/casos_de_uso.pdf $(DEST_DIR)/modelo_bd.pdf \
	$(DEST_DIR)/acta_constitucion.pdf

doc: $(DOC_FILES)

$(DEST_DIR)/casos_de_uso.png: casos_de_uso.dia
	dia -e $(DEST_DIR)/casos_de_uso.png -t png casos_de_uso.dia

$(DEST_DIR)/diagrama_de_clases.png: diagrama_de_clases.dia
	dia -e $(DEST_DIR)/diagrama_de_clases.png -t png diagrama_de_clases.dia

$(DEST_DIR)/casos_de_uso.pdf: casos_de_uso.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) casos_de_uso.odt

$(DEST_DIR)/modelo_bd.pdf: modelo_bd.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) modelo_bd.odt

$(DEST_DIR)/acta_constitucion.pdf: acta_constitucion.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) acta_constitucion.odt

clean:
	rm *~ $(DOC_FILES)
