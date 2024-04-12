package Student;
public class StudentInformation {
    private String namestudent;
    private String MSSV;
    private String day;
    private String daypay;
    private String book;
    // constructor
    public StudentInformation(String namestudent, String MSSV, String day, String daypay, String book) {
        this.namestudent = namestudent;
        this.MSSV = MSSV;
        this.day = day;
        this.daypay = daypay;
        this.book = book;
    }

    // getters
    public String getNamestudent() {
        return this.namestudent;
    }

    public String getMSSV() {
        return this.MSSV;
    }

    public String getDay() {
        return this.day;
    }

    public String getDaypay() {
        return this.daypay;
    }
    public String getbook() {
        return this.book;
    }
    // setters
    public void setNamestudent(String namestudent) {
        this.namestudent = namestudent;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDaypay(String daypay) {
        this.daypay = daypay;
    }
    public void setbook(String book) {
        this.book = book;
    }
}
