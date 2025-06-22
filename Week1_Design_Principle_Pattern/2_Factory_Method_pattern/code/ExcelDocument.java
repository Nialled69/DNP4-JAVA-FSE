public class ExcelDocument extends Document {
    public ExcelDocument(String name) {
        super(name);
    }
    
    @Override
    public void create() {
        System.out.println("Creating Excel document: " + name + ".xlsx");
    }
    
    @Override
    public void save() {
        System.out.println("Saving Excel document: " + name + ".xlsx");
    }
    
    @Override
    public void display() {
        System.out.println("Displaying Excel document: " + name + ".xlsx");
        System.out.println("Content: " + content);
    }
} 