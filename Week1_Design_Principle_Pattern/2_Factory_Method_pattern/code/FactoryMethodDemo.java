public class FactoryMethodDemo {    
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");
        
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        Document wordDoc = wordFactory.getDocument("Report");
        Document pdfDoc = pdfFactory.getDocument("Manual");
        Document excelDoc = excelFactory.getDocument("Data");
        
        System.out.println("\n--- Document Operations ---");
        wordDoc.setContent("This is a Word document content.");
        wordDoc.save();
        wordDoc.display();
        System.out.println();

        pdfDoc.setContent("This is a PDF document content.");
        pdfDoc.save();
        pdfDoc.display();
        System.out.println();
        
        excelDoc.setContent("This is an Excel document content.");
        excelDoc.save();
        excelDoc.display();
        
        System.out.println("\n=== Demo Complete ===");
    }
} 