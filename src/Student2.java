import java.util.ArrayList;


public class Student2 {
    private String tenLop;
    private ArrayList<Student> danhSachSinhVien;

    public Student2(String tenLop) {
        this.tenLop = tenLop;
        this.danhSachSinhVien = new ArrayList<>();
    }

    public void addStudent(Student s) {
        for (Student existing : danhSachSinhVien) {
            if (existing.getMssv().equalsIgnoreCase(s.getMssv())) {
                throw new IllegalArgumentException("Lỗi: Mã sinh viên " + s.getMssv() + " đã tồn tại trong lớp!");
            }
        }
        danhSachSinhVien.add(s);
    }

    public String xepLoai(Student s) {
        double dtb = s.diemTrungBinh();
        if (dtb >= 8.0) {
            return "Giỏi";
        } else if (dtb >= 6.5) {
            return "Khá";
        } else if (dtb >= 5.0) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    public void inBangDiem() {
        System.out.println("==================================================");
        System.out.println("BẢNG ĐIỂM LỚP: " + tenLop);
        System.out.printf("%-12s %-18s %-10s %s\n", "MSSV", "Họ Tên", "Điểm TB", "Xếp Loại");
        System.out.println("--------------------------------------------------");
        for (Student s : danhSachSinhVien) {
            System.out.printf("%-12s %-18s %-10.2f %s\n",
                    s.getMssv(), s.getName(), s.diemTrungBinh(), xepLoai(s));
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Sĩ số lớp: " + danhSachSinhVien.size());
        System.out.println("==================================================");
    }
        public static void main(String[] args) {
            Student2 lop = new Student2("D25CQCC07-B");

            Student s1 = new Student("B25DCCC001", "Nguyen Van An", 9.0, 8.5, 9.0);
            Student s2 = new Student("B25DCCC002", "Le Thi Binh", 8.0, 7.0, 7.0);
            Student s3 = new Student("B25DCCC003", "Tran Van Cuong", 6.0, 5.0, 5.5);
            Student s4 = new Student("B25DCCC004", "Pham Van Dung", 4.0, 3.0, 4.0);

            lop.addStudent(s1);
            lop.addStudent(s2);
            lop.addStudent(s3);
            lop.addStudent(s4);

            Student sDuplicate = new Student("B25DCCC001", "Nguoi Den Sau", 10, 10, 10);

            try {
                lop.addStudent(sDuplicate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            lop.inBangDiem();
        }

}