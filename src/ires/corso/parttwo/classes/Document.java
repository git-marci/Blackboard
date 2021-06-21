package ires.corso.parttwo.classes;

import java.time.LocalDate;

public final class Document
{
    private LocalDate issuingDate; // Data di rilascio
    private LocalDate expirationDate; // Data di scadenza
    private String documentType; // Tipo documento
    private String documentId; // Document ID

    public Document(LocalDate issuingDate, LocalDate expirationDate, String documentType, String documentId) {
        this.issuingDate = issuingDate;
        this.expirationDate = expirationDate;
        this.documentType = documentType;
        this.documentId = documentId;
    }

    public LocalDate getIssuingDate() {
        return issuingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentId() {
        return documentId;
    }
}
