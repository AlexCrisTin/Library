package Student;
public class StudentInformation {
    private String namestudent;
    private String MSSV;
    private String day;
    private String daypay;
    private String book;
    
    // constructor khởi tạo các đối tượng của lớp với các giá trị cụ thể.
    public StudentInformation(String namestudent, String MSSV, String day, String daypay, String book) {
        this.namestudent = namestudent;
        this.MSSV = MSSV;
        this.day = day;
        this.daypay = daypay;
        this.book = book;
    }

    // getters lấy giá trị của các trường dữ liệu
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
    public String getBook() {
        return this.book;
    }
    // setters thiết lập giá trị cho các trường dữ liệu
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
    public void setBook(String book) {
        this.book = book;
    }
}
