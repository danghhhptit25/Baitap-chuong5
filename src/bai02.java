interface EmailSender {
    void sendEmail(String recipient, String message);
}

interface Programmer {
    void writeCode(String feature);
}

interface Salesperson {
    void sellProduct(String product);
}

abstract class Employee2 {
    protected String name;

    public Employee2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class OfficeEmployee2 extends Employee2 implements EmailSender {
    public OfficeEmployee2(String name) {
        super(name);
    }

    @Override
    public void sendEmail(String recipient, String message) {
        System.out.println(name + " gửi email đến " + recipient + ": \"" + message + "\"");
    }
}

class TechnicalEmployee2 extends Employee2 implements Programmer, EmailSender {
    public TechnicalEmployee2(String name) {
        super(name);
    }

    @Override
    public void writeCode(String feature) {
        System.out.println(name + " đang lập trình tính năng: " + feature);
    }

    @Override
    public void sendEmail(String recipient, String message) {
        System.out.println(name + " gửi email kỹ thuật đến " + recipient + ": \"" + message + "\"");
    }
}

class SalesEmployee2 extends Employee2 implements Salesperson, EmailSender {
    public SalesEmployee2(String name) {
        super(name);
    }

    @Override
    public void sellProduct(String product) {
        System.out.println(name + " đang tư vấn bán sản phẩm: " + product);
    }

    @Override
    public void sendEmail(String recipient, String message) {
        System.out.println(name + " gửi email báo giá đến " + recipient + ": \"" + message + "\"");
    }
}

public class bai02 {
    public static void main(String[] args) {
        OfficeEmployee2 officeEmp = new OfficeEmployee2("An");
        TechnicalEmployee2 techEmp = new TechnicalEmployee2("Bình");
        SalesEmployee2 salesEmp = new SalesEmployee2("Cường");

        officeEmp.sendEmail("hr@company.com", "Báo cáo chấm công");
        techEmp.writeCode("Tính năng đăng nhập");
        salesEmp.sellProduct("Gói dịch vụ");
    }
}