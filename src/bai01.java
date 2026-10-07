abstract class Employee {
    protected String name;
    protected int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.printf("Tên: %-15s | Tuổi: %-3d | Lương: %,.0f VNĐ%n",
                this.name, this.age, this.calculateSalary());
    }
}

class OfficeEmployee extends Employee {
    private static final double DAILY_SALARY = 100.0;
    private int workingDays;

    public OfficeEmployee(String name, int age, int workingDays) {
        super(name, age);
        this.workingDays = workingDays;
    }

    @Override
    public double calculateSalary() {
        return this.workingDays * DAILY_SALARY;
    }
}

class TechnicalEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    public TechnicalEmployee(String name, int age, double workingHours, double hourlyRate) {
        super(name, age);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return this.workingHours * this.hourlyRate;
    }
}

public class bai01 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new OfficeEmployee("Nguyễn Văn A", 28, 22),
                new TechnicalEmployee("Trần Thị B", 25, 160, 15.0),
                new OfficeEmployee("Lê Văn C", 30, 20),
                new TechnicalEmployee("Phạm Văn D", 32, 175, 20.0)
        };

        System.out.println("=== DANH SÁCH LƯƠNG NHÂN VIÊN ===");

        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}