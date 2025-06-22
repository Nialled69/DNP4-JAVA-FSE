public class WordDocument extends Document {    
    public WordDocument(String name) {
        super(name);
    }
    
    @Override
    public void create() {
        System.out.println("Creating Word document: " + name + ".docx");
    }
    
    @Override
    public void save() {
        System.out.println("Saving Word document: " + name + ".docx");
    }
    
    @Override
    public void display() {
        System.out.println("Displaying Word document: " + name + ".docx");
        System.out.println("Content: " + content);
    }
} 