
package b6_3;

import java.util.Scanner;

public class B6_3 {
    static Scanner sc = new Scanner(System.in);
    static String[] danhSachBienSo = new String[100];
    static int soLuong = 0;

    public static void main(String[] args) {
        int luaChon;

        do {
            System.out.println("\n******** QUẢN LÝ BIỂN SỐ XE ********");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(sc.nextLine());

                switch (luaChon) {
                    case 1:
                        themBienSo();
                        break;

                    case 2:
                        hienThiDanhSach();
                        break;

                    case 3:
                        timKiemBienSo();
                        break;

                    case 4:
                        timTheoMaTinh();
                        break;

                    case 5:
                        sapXepTangDan();
                        break;

                    case 6:
                        System.out.println("Đã thoát chương trình!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                luaChon = 0;
                System.out.println("Vui lòng nhập số!");
            }

        } while (luaChon != 6);
    }

    public static void themBienSo() {
        System.out.print("Nhập số lượng biển số muốn thêm: ");
        int n;

        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ!");
            return;
        }

        if (n <= 0 || soLuong + n > danhSachBienSo.length) {
            System.out.println("Số lượng không hợp lệ hoặc vượt quá sức chứa!");
            return;
        }

        String regex = "^[0-9]{2}[A-Z]{1,2}-[0-9]{3}\\.[0-9]{2}$";

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập biển số xe thứ " + (i + 1) + ": ");
            String bienSo = sc.nextLine().trim().toUpperCase();

            if (!bienSo.matches(regex)) {
                System.out.println("Biển số không đúng định dạng! Ví dụ: 30F-123.45");
                i--;
                continue;
            }

            danhSachBienSo[soLuong] = bienSo;
            soLuong++;

            System.out.println("Thêm biển số thành công!");
        }
    }

    public static void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách biển số xe đang trống!");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("\n--- DANH SÁCH BIỂN SỐ XE ---\n");

        for (int i = 0; i < soLuong; i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(danhSachBienSo[i])
                    .append("\n");
        }

        System.out.println(sb);
    }

    public static void timKiemBienSo() {
        if (soLuong == 0) {
            System.out.println("Danh sách biển số xe đang trống!");
            return;
        }

        System.out.print("Nhập biển số cần tìm: ");
        String bienSoCanTim = sc.nextLine().trim().toUpperCase();

        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            if (danhSachBienSo[i].equals(bienSoCanTim)) {
                System.out.println("Tìm thấy biển số: " + danhSachBienSo[i]);
                System.out.println("Vị trí: " + (i + 1));
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy biển số xe!");
        }
    }

    public static void timTheoMaTinh() {
        if (soLuong == 0) {
            System.out.println("Danh sách biển số xe đang trống!");
            return;
        }

        System.out.print("Nhập mã tỉnh cần tìm: ");
        String maTinh = sc.nextLine().trim();

        if (!maTinh.matches("^[0-9]{2}$")) {
            System.out.println("Mã tỉnh phải gồm 2 chữ số!");
            return;
        }

        boolean timThay = false;

        StringBuffer sb = new StringBuffer();

        sb.append("\n--- DANH SÁCH BIỂN SỐ THEO MÃ TỈNH ")
                .append(maTinh)
                .append(" ---\n");

        for (int i = 0; i < soLuong; i++) {
            String maTinhTrongBienSo = danhSachBienSo[i].substring(0, 2);

            if (maTinhTrongBienSo.equals(maTinh)) {
                sb.append(danhSachBienSo[i]).append("\n");
                timThay = true;
            }
        }

        if (timThay) {
            System.out.println(sb);
        } else {
            System.out.println("Không có biển số nào thuộc mã tỉnh này!");
        }
    }

    public static void sapXepTangDan() {
        if (soLuong == 0) {
            System.out.println("Danh sách đang trống!");
            return;
        }

        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                if (danhSachBienSo[i].compareTo(danhSachBienSo[j]) > 0) {
                    String temp = danhSachBienSo[i];
                    danhSachBienSo[i] = danhSachBienSo[j];
                    danhSachBienSo[j] = temp;
                }
            }
        }

        System.out.println("Đã sắp xếp biển số xe tăng dần!");
        hienThiDanhSach();
    }
}
