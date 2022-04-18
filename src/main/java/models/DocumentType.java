package models;

public enum DocumentType {
    CEDULA(" C.C. - Cédula de ciudadanía "),
    CEDULA_EXTRANJERIA(" C.E. - Cédula de Extranjería "),
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
