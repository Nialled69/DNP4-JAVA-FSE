public abstract class DocumentFactory {
    public abstract Document createDocument(String name);
    
    public Document getDocument(String name) {
        Document document = createDocument(name);
        document.create();
        return document;
    }
} 