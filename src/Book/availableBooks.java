package Book;
public class availableBooks {
    private String namebook;
    private String nameauthor;
    private String kind;
    private String daypuli;
  

    // constructor
    public availableBooks(String namebook, String kind, String nameauthor, String daypuli) {
        this.namebook = namebook;
        this.kind = kind;
        this.nameauthor = nameauthor;
        this.daypuli = daypuli;
        
    }

    // getters
    public String getNamebook() {
        return this.namebook;
    }

    public String getKind() {
        return this.kind;
    }

    public String getAuthor() {
        return this.nameauthor;
    }

    public String getDaypuli() {
        return this.daypuli;
    }
    
    
    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setAuthor(String nameauthor) {
        this.nameauthor = nameauthor;
    }

    public void setDaypuli(String daypuli) {
        this.daypuli = daypuli;
    }
    
}

