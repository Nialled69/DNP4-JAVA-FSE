public class PdfDocument extends Document {
    
    public PdfDocument(String name) {
        super(name);
    }
    
    @Override
    public void create() {
        System.out.println("Creating PDF document: " + name + ".pdf");
    }
    
    @Override
    public void save() {
        System.out.println("Saving PDF document: " + name + ".pdf");
    }
    
    @Override
    public void display() {
        System.out.println("Displaying PDF document: " + name + ".pdf");
        System.out.println("Content: " + content);
    }
} 