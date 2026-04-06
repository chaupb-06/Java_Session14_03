import java.text.DecimalFormat;
import java.util.Scanner;

public class bt03 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###" + " VND");
        Scanner sc = new Scanner(System.in);
        double balance = 1000000;
        final double min_balance = 50000;
        boolean isDone = false;
        while (!isDone) {
            try {
                System.out.print("Nhập số tiền muốn rút: ");
                double withDrawal = Double.parseDouble(sc.nextLine());
                if (withDrawal <= 0) {
                    System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
                }
                else if (withDrawal > balance) {
                    System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
                }
                else if ((balance - withDrawal) < min_balance) {
                    System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                }
                else {
                    balance -= withDrawal;
                    isDone = true;
                    System.out.println("Giao dịch thành công!");
                    System.out.println("Số tiền đã rút: " + df.format(withDrawal));
                    System.out.println("Số dư còn lại trong tài khoản: " + df.format(balance));
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập phải là số hợp lệ");
            }
        }
        sc.close();
    }
}
