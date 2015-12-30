DEST_DIR = ./generated

DOC_FILES =  casos_de_uso.pdf casos_de_uso.png diagrama_de_clases.png \
		modelo_bd.pdf acta_constitucion.pdf

all: doc

doc: $(addprefix $(DEST_DIR)/, $(DOC_FILES))

$(DEST_DIR)/casos_de_uso.pdf: casos_de_uso.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) $<

$(DEST_DIR)/modelo_bd.pdf: modelo_bd.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) $<

$(DEST_DIR)/acta_constitucion.pdf: acta_constitucion.odt
	libreoffice --convert-to pdf --outdir $(DEST_DIR) $<

$(DEST_DIR)/casos_de_uso.png: casos_de_uso.dia
	dia -e $@ -t png $<

$(DEST_DIR)/diagrama_de_clases.png: diagrama_de_clases.dia
	dia -e $@ -t png $<

clean:
	rm -rf $(DEST_DIR)
