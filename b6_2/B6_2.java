package b6_2;

import java.util.Scanner;
public class B6_2 {
        static Scanner sc = new Scanner(System.in);
        static String hoTen = "";
        static String email = "";
        static String dienThoai = "";
        static String matKhau = "";

        public static void nhapThongTin() {

            System.out.print("Nhập họ và tên: ");
            hoTen = sc.nextLine();

            System.out.print("Nhập email: ");
            email = sc.nextLine();

            System.out.print("Nhập số điện thoại: ");
            dienThoai = sc.nextLine();

            System.out.print("Nhập mật khẩu: ");
            matKhau = sc.nextLine();

            System.out.println("Đã nhập thông tin người dùng thành công!");
        }

        public static void chuanHoaHoTen() {

            if (hoTen.isEmpty()) {
                System.out.println("Vui lòng nhập thông tin người dùng trước!");
                return;
            }

            String ten = hoTen.trim().replaceAll("\\s+", " ");

            ten = ten.toLowerCase();

            StringBuilder sb = new StringBuilder();

            String[] arr = ten.split(" ");

            for (String tu : arr) {

                sb.append(Character.toUpperCase(tu.charAt(0)));
                sb.append(tu.substring(1));
                sb.append(" ");
            }

            hoTen = sb.toString().trim();

            System.out.println("Họ và tên sau khi chuẩn hóa: " + hoTen);
        }


        public static void kiemTraEmail() {

            if (email.isEmpty()) {
                System.out.println("Vui lòng nhập thông tin người dùng trước!");
                return;
            }

            String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

            if (email.matches(regex)) {
                System.out.println("Email hợp lệ!");
            } else {
                System.out.println("Email không hợp lệ!");
            }
        }


        public static void kiemTraDienThoai() {

            if (dienThoai.isEmpty()) {
                System.out.println("Vui lòng nhập thông tin người dùng trước!");
                return;
            }

            String regex = "^(03|05|07|08|09)[0-9]{8}$";

            if (dienThoai.matches(regex)) {
                System.out.println("Số điện thoại hợp lệ!");
            } else {
                System.out.println("Số điện thoại không hợp lệ!");
            }
        }

        public static void kiemTraMatKhau() {

            if (matKhau.isEmpty()) {
                System.out.println("Vui lòng nhập thông tin người dùng trước!");
                return;
            }

            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9\\s])\\S{8,}$";

            if (matKhau.matches(regex)) {
                System.out.println("Mật khẩu hợp lệ!");
            } else {
                System.out.println("Mật khẩu không hợp lệ!");
                System.out.println("Mật khẩu phải có ít nhất 8 ký tự, gồm:");
                System.out.println("- Chữ thường");
                System.out.println("- Chữ hoa");
                System.out.println("- Chữ số");
                System.out.println("- Ký tự đặc biệt");
                System.out.println("- Không chứa khoảng trắng");
            }
        }

        public static void main(String[] args) {

            int luaChon;

            do {

                System.out.println("\n******** QUẢN LÝ NGƯỜI DÙNG ********");
                System.out.println("1. Nhập thông tin người dùng");
                System.out.println("2. Chuẩn hóa họ tên");
                System.out.println("3. Kiểm tra email hợp lệ");
                System.out.println("4. Kiểm tra số điện thoại hợp lệ");
                System.out.println("5. Kiểm tra mật khẩu hợp lệ");
                System.out.println("6. Thoát");
                System.out.print("Lựa chọn của bạn: ");

                luaChon = Integer.parseInt(sc.nextLine());

                switch (luaChon) {

                    case 1:
                        nhapThongTin();
                        break;

                    case 2:
                        chuanHoaHoTen();
                        break;

                    case 3:
                        kiemTraEmail();
                        break;

                    case 4:
                        kiemTraDienThoai();
                        break;

                    case 5:
                        kiemTraMatKhau();
                        break;

                    case 6:
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } while (luaChon != 6);

            sc.close();
        }
    }

