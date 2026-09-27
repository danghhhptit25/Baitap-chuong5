public class Student1 {
    private static int counter = 0;

    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;
    private String email;
    private String sdt;

    public Student1(String name, double diemCC, double diemGK, double diemCK) {
        counter++;
        this.mssv = String.format("B25DCCC%03d", counter);
        this.name = name;
        this.diemCC = diemCC;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }

    public static int getTotalStudents() {
        return counter;
    }

    public Student1 capNhatEmail(String email) {
        this.email = email;
        return this;
    }

    public Student1 capNhatSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }


        public static void main(String[] args) {
            Student1 sv = new Student1("Lan", 8, 7.5, 9);
            sv.capNhatEmail("lan@ptit.edu.vn").capNhatSdt("0912345678");

            System.out.println(sv.getMssv());
            System.out.println(Student1.getTotalStudents());

            Student1 sv2 = new Student1("Minh", 7, 8, 8);
            Student1 sv3 = new Student1("Hoa", 9, 9, 9.5);

            System.out.println(sv2.getMssv());
            System.out.println(sv3.getMssv());
            System.out.println("Tổng số SV: " + Student1.getTotalStudents()); // 3
        }


}