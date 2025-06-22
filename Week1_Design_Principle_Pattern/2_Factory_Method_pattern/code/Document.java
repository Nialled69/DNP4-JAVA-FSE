public abstract class Document {
    protected String name;
    protected String content;
    
    public Document(String name) {
        this.name = name;
        this.content = "";
    }
    
    public abstract void create();
    public abstract void save();
    public abstract void display();
    
    public String getName() {
        return name;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
} 