package b6_1;

import java.util.Scanner;
public class B6_1 {
        public static int nhapDiem(Scanner sc, double[] diem) {

            System.out.print("Nhập số lượng sinh viên: ");
            int n = sc.nextInt();

            if (n <= 0 || n > diem.length) {
                System.out.println("Số lượng sinh viên không hợp lệ!");
                return 0;
            }

            for (int i = 0; i < n; i++) {

                while (true) {

                    System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                    double value = sc.nextDouble();

                    if (value < 0 || value > 10) {
                        System.out.println("Điểm phải nằm trong khoảng 0 đến 10. Nhập lại!");
                        continue;
                    }

                    diem[i] = value;
                    break;
                }
            }

            return n;
        }

        public static void inDanhSach(double[] diem, int n) {

            if (n == 0) {
                System.out.println("Chưa có dữ liệu!");
                return;
            }

            System.out.println("\n===== DANH SÁCH ĐIỂM SINH VIÊN =====");

            for (int i = 0; i < n; i++) {
                System.out.println("Sinh viên thứ " + (i + 1) + ": " + diem[i]);
            }
        }

        public static void tinhTrungBinh(double[] diem, int n) {

            if (n == 0) {
                System.out.println("Chưa có dữ liệu!");
                return;
            }

            double tong = 0;

            for (int i = 0; i < n; i++) {
                tong += diem[i];
            }

            double trungBinh = tong / n;

            System.out.printf("Điểm trung bình: %.2f\n", trungBinh);
        }

        public static void timCaoThap(double[] diem, int n) {

            if (n == 0) {
                System.out.println("Chưa có dữ liệu!");
                return;
            }

            double max = diem[0];
            double min = diem[0];

            for (int i = 1; i < n; i++) {

                if (diem[i] > max) {
                    max = diem[i];
                }

                if (diem[i] < min) {
                    min = diem[i];
                }
            }

            System.out.println("Điểm cao nhất: " + max);
            System.out.println("Điểm thấp nhất: " + min);
        }

        public static void demDatTruot(double[] diem, int n) {

            if (n == 0) {
                System.out.println("Chưa có dữ liệu!");
                return;
            }

            int dat = 0;
            int truot = 0;

            for (int i = 0; i < n; i++) {

                if (diem[i] >= 5) {
                    dat++;
                } else {
                    truot++;
                }
            }

            System.out.println("Số sinh viên đạt: " + dat);
            System.out.println("Số sinh viên trượt: " + truot);
        }

        public static void sapXepTangDan(double[] diem, int n) {

            if (n == 0) {
                System.out.println("Chưa có dữ liệu!");
                return;
            }

            for (int i = 0; i < n - 1; i++) {

                for (int j = i + 1; j < n; j++) {

                    if (diem[i] > diem[j]) {

                        double temp = diem[i];
                        diem[i] = diem[j];
                        diem[j] = temp;
                    }
                }
            }

            System.out.println("Đã sắp xếp điểm tăng dần!");
            inDanhSach(diem, n);
        }

        public static void thongKeGioiXuatSac(double[] diem, int n) {

            if (n == 0) {
                System.out.println("Chưa có dữ liệu!");
                return;
            }

            int gioiXuatSac = 0;

            for (int i = 0; i < n; i++) {

                if (diem[i] >= 8) {
                    gioiXuatSac++;
                }
            }

            System.out.println("Số sinh viên giỏi và xuất sắc: " + gioiXuatSac);
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            double[] diem = new double[100];
            int n = 0;

            int luaChon;

            do {

                System.out.println("\n******** QUẢN LÝ ĐIỂM SV ********");
                System.out.println("1. Nhập danh sách điểm sinh viên");
                System.out.println("2. In danh sách điểm");
                System.out.println("3. Tính điểm trung bình của các sinh viên");
                System.out.println("4. Tìm điểm cao nhất và thấp nhất");
                System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
                System.out.println("6. Sắp xếp điểm tăng dần");
                System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
                System.out.println("8. Thoát");
                System.out.print("Lựa chọn của bạn: ");

                luaChon = sc.nextInt();

                switch (luaChon) {

                    case 1:
                        n = nhapDiem(sc, diem);
                        break;

                    case 2:
                        inDanhSach(diem, n);
                        break;

                    case 3:
                        tinhTrungBinh(diem, n);
                        break;

                    case 4:
                        timCaoThap(diem, n);
                        break;

                    case 5:
                        demDatTruot(diem, n);
                        break;

                    case 6:
                        sapXepTangDan(diem, n);
                        break;

                    case 7:
                        thongKeGioiXuatSac(diem, n);
                        break;

                    case 8:
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } while (luaChon != 8);

            sc.close();
        }
    }

