public class availableBooks {

    private final String namebook;
    private final String kind;
    private final String author;
    private final String view;

    public availableBooks(String namebook, String author, String kind, String view){
        this.namebook = namebook;
        this.kind = kind;
        this.author = author;
        this.view = view;
    }
public String getNamebook(){
    return namebook;
}
public String getKind(){
    return kind;
}
public String getAuthor(){
    return author;
}
public String getView(){
    return view;
}
}


