package models;

public enum DocumentType {
    CEDULA(" C.C. - C�dula de ciudadan�a "),
    CEDULA_EXTRANJERIA(" C.E. - C�dula de Extranjer�a "),
    PASAPORTE(" PS. - Pasaporte "),
    TARJETA_IDENTIDAD(" T.I. - Tarjeta de Identidad "),
    REGISTRO_CIVIL(" R.C. - Registro Civil ");
    private final String documentString;

    DocumentType(String documentString) {
        this.documentString=documentString;
    }

    public String getDocumentString() {
        return documentString;
    }

}
