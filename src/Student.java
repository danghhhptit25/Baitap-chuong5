public class Student {
    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;

    public Student(String mssv, String name, double diemCC, double diemGK, double diemCK) {
        this.mssv = mssv;
        this.name = name;
        setDiemCC(diemCC);
        setDiemGK(diemGK);
        setDiemCK(diemCK);
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double getDiemCC() {
        return diemCC;
    }

    public double getDiemGK() {
        return diemGK;
    }

    public double getDiemCK() {
        return diemCK;
    }

    public void setDiemCC(double diemCC) {
        if (diemCC >= 0 && diemCC <= 10) {
            this.diemCC = diemCC;
        } else {
            System.out.println("Điểm chuyên cần không hợp lệ (phải từ 0 đến 10)!");
        }
    }

    public void setDiemGK(double diemGK) {
        if (diemGK >= 0 && diemGK <= 10) {
            this.diemGK = diemGK;
        } else {
            System.out.println("Điểm giữa kỳ không hợp lệ (phải từ 0 đến 10)!");
        }
    }

    public void setDiemCK(double diemCK) {
        if (diemCK >= 0 && diemCK <= 10) {
            this.diemCK = diemCK;
        } else {
            System.out.println("Điểm cuối kỳ không hợp lệ (phải từ 0 đến 10)!");
        }
    }

    public double diemTrungBinh() {
        return (diemCC * 0.1) + (diemGK * 0.3) + (diemCK * 0.6);
    }

    public static void main(String[] args) {
        Student sv1 = new Student("B25DCCC001", "Nguyen Van A", 9.0, 8.0, 7.5);
        Student sv2 = new Student("B25DCCC002", "Tran Thi B", 10.0, 6.5, 8.0);
        Student sv3 = new Student("B25DCCC003", "Le Van C", 7.0, 5.0, 6.0);

        sv1.setDiemGK(-1);
        sv1.setDiemGK(11);

        System.out.printf("%-12s %-18s %s\n", "MSSV", "Họ Tên", "Điểm TB");
        System.out.printf("%-12s %-18s %.2f\n", sv1.getMssv(), sv1.getName(), sv1.diemTrungBinh());
        System.out.printf("%-12s %-18s %.2f\n", sv2.getMssv(), sv2.getName(), sv2.diemTrungBinh());
        System.out.printf("%-12s %-18s %.2f\n", sv3.getMssv(), sv3.getName(), sv3.diemTrungBinh());
    }
}