package com.vanphongpham;

import java.util.Scanner;
//import com.user.User;
//hoac import com.vanphongpham.user.User;
import com.ThongTinChuongTrinh.ThongTinChuongTrinh;
import com.cskh.Cskh;
import com.quanly.QuanLyFile;
import com.quanly.QuanLyArray;
import java.io.IOException;
import com.nhanvien.NhanVien;
import com.feedback.Feedback;
import com.hoadon.HoaDon;

public class VanPhongPham {

    GioHang gioHang = new GioHang();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        SanPham[] sanPhamList = taoDanhSachSanPham();
        KhachHang khachHang = null;
        TaiKhoan taiKhoan = new TaiKhoan(); // You need to instantiate TaiKhoan

    public static void clearScreen() {
        for (int i = 0; i < 31; ++i) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Menu
        int lc;
        while (true) {
            clearScreen();
            System.out.println("Chao mung ban den voi: Ung dung Ban van phong pham");
            System.out.println("Welcome to Program");
            System.out.println("==================================================");
            System.out.println("|Moi ban chon thao tac ung voi nhu cau cua minh  |");
            System.out.println("|1. Quan ly (Adminstrator) (2 File)  --> Quoc    |");
            System.out.println("|2. Khach Hang (Customer)      (n File)  --> Thinh, Sang|");
            System.out.println("|3. Nhan vien (Staff)      (1 File)  --> Phat    |");
            System.out.println("|4. CSKH (Customer care)                         |");
            System.out.println("|5. Thong tin ve chuong trinh (Details)          |");
            System.out.println("|6. Gop y ve chuong trinh (Feedback) (1 File) --> Viet|");
            System.out.println("|0. Thoat ung dung (Exit application)            |");
            System.out.println("==================================================");
            System.out.print("Moi ban nhap lua chon (Please enter your choice): ");
            lc = sc.nextInt();
            switch (lc) {
                case 1: {
                    int iCnt = 5, ok = 1;
                    //QuanLyFile quanly = new QuanLyFile("", "", "QuanLy");
                    QuanLyArray quanly = new QuanLyArray("","","QuanLy");
                    NhanVien nhanvien = new NhanVien("","","",1,"");
                    try {
                        while (iCnt != 0) {
                            int iLogin = quanly.DangNhapTaiKhoanQuanLy();
                            if (iLogin == 0) {
                                clearScreen();
                                System.out.println("Dang nhap thanh cong voi vai tro Quan Ly");
                                while (ok == 1) {
                                    System.out.println("Chao mung ban den voi: Ung dung Ban van phong pham");
                                    System.out.println("Welcome to Program");
                                    System.out.println("==================================================");
                                    System.out.println("|1. Cap nhat thong tin Quan Ly                   |");
                                    System.out.println("|2. Xem danh sach Quan Ly                        |");
                                    System.out.println("|3. Dang ky tai khoan Nhan Vien                  |");
                                    System.out.println("|4. Xoa tai khoan Nhan Vien                      |");
                                    System.out.println("|5. Cap nhat thong tin Nhan Vien                 |");
                                    System.out.println("|6. Tim kiem Nhan Vien                           |");
                                    System.out.println("|7. Xem danh sach Nhan Vien                      |");
                                    System.out.println("|0. Thoat vai tro Quan Ly                        |");
                                    System.out.println("==================================================");
                                    System.out.print("Moi ban nhap mot lua chon (0-6) ");
                                    int lc1 = sc.nextInt();
                                    switch (lc1) {
                                        case 1: {
                                            clearScreen();
                                            int ok1 = 1;
                                            while (ok1 == 1) {
                                                quanly.CapNhatThongTinQuanLy();
                                                System.out.println("Ban co muon cap nhat thong tin Quan Ly tiep khong?");
                                                System.out.println("1. Tiep tuc");
                                                System.out.println("0. Quay lai");
                                                int lc2 = sc.nextInt();
                                                switch (lc2) {
                                                    case 1: {
                                                        break;
                                                    }
                                                    case 0: {
                                                        ok1 = 0;
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println("Lua chon khong hop le!");
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 2: {
                                            int ok1 = 1;
                                            clearScreen();
                                            while (ok1 == 1) {
                                                System.out.println("Ban muon them thong tin gi?");
                                                System.out.println("1. Xem Thong tin Quan Ly");
                                                System.out.println("2. Xem Tai khoan Quan Ly");
                                                System.out.println("0. Quay lai");
                                                System.out.print("Moi nhap lua chon (0 - 2) ");
                                                int lc2 = sc.nextInt();
                                                switch (lc2) {
                                                    case 1: {
                                                        clearScreen();
                                                        quanly.XemThongTinQuanLy();
                                                        break;
                                                    }
                                                    case 2: {
                                                        clearScreen();
                                                        quanly.XemTaiKhoanQuanLy();
                                                        break;
                                                    }
                                                    case 0: {
                                                        ok1 = 0;
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 3: {
                                                                                       clearScreen();
                                            int ok1 = 1;
                                            while (ok1 == 1) {
                                                nhanvien.DangKyTaiKhoanNhanVien();
                                                int lc2;
                                                do {
                                                    System.out.println("Ban co muon dang ky tai khoan Nhan Vien tiep khong?");
                                                    System.out.println("1. Tiep tuc");
                                                    System.out.println("0. Quay lai");
                                                    String input = sc.next();
                                                    if (input.length() == 1 && (input.charAt(0) == '0' || input.charAt(0) == '1')) {
                                                        lc2 = Integer.parseInt(input); 
                                                        if(lc2 == 0){
                                                            ok1 = 0;
                                                            break;
                                                        }
                                                    } else {
                                                        System.out.println("Lua chon khong hop le! Vui long nhap lai.");
                                                        lc2 = -1;
                                                    }

                                                } while (lc2 != 0 && lc2 != 1);
                                            }
                                            break;
                                        }
                                        case 4: {
                                            clearScreen();
                                            int ok1 = 1;
                                            while (ok1 == 1) {
                                                System.out.println("1. Xoa Nhan Vien theo ID");
                                                System.out.println("2. Xoa Nhan Vien theo tai khoan");
                                                System.out.println("3. Xoa tat ca Nhan Vien");
                                                System.out.println("0. Quay lai");
                                                System.out.print("Moi nhap lua chon cua ban ");
                                                int lc2 = sc.nextInt();
                                                switch(lc2){
                                                    case 1: {
                                                        clearScreen();
                                                        int ok2 = 1;
                                                        while (ok2 == 1) {                                                            
                                                            nhanvien.XoaNhanVienTheoMa();
                                                            System.out.print("Ban co muon xoa tiep khong?");
                                                            System.out.println("1. Tiep tuc");
                                                            System.out.println("0.Quay lai");
                                                            System.out.print("Moi nhap lua chon cua ban ");
                                                            int lc3 = sc.nextInt();
                                                            switch(lc3){
                                                                case 1: {
                                                                    break;
                                                                }
                                                                case 0: {
                                                                    ok2 = 0;
                                                                    break;
                                                                }
                                                                default: {
                                                                    System.out.println("Lua chon khong hop le!");
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case 2: {
                                                        clearScreen();
                                                        int ok2 = 1;
                                                        while (ok2 == 1) {
                                                            nhanvien.XoaTaiKhoanNhanVienTheoTaiKhoan();
                                                            System.out.print("Ban co muon xoa tiep khong?");
                                                            System.out.println("1. Tiep tuc");
                                                            System.out.println("0.Quay lai");
                                                            System.out.print("Moi nhap lua chon cua ban ");
                                                            int lc3 = sc.nextInt();
                                                            switch (lc3) {
                                                                case 1: {
                                                                    break;
                                                                }
                                                                case 0: {
                                                                    ok2 = 0;
                                                                    break;
                                                                }
                                                                default: {
                                                                    System.out.println("Lua chon khong hop le!");
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case 3: {
                                                        clearScreen();
                                                        int ok2 = 1;
                                                        while (ok2 == 1) {
                                                            nhanvien.XoaTatCaNhanVien();
                                                            System.out.println("1. Hoan tac");
                                                            System.out.println("0. Quay lai");
                                                            System.out.print("Xin moi nhap lua chon ");
                                                            int lc3 = sc.nextInt();
                                                            switch (lc3) {
                                                                case 1: {
                                                                    nhanvien.HoanTacXoaTatCaNhanVien();
                                                                    break;
                                                                }
                                                                case 0: {
                                                                    ok2 = 0;
                                                                    break;
                                                                }
                                                                default: {
                                                                    System.out.println("Lua chon khong hop le!");
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case 0: {
                                                        ok1 = 0;
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println("Lua chon khong hop le!");
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 5: {
                                            clearScreen();
                                            int ok1 = 1;
                                            while (ok1 == 1) {
                                                nhanvien.CapNhatThongTinNhanVien();
                                                System.out.println("Ban co muon cap nhat thong tin Nhan Vien tiep khong?");
                                                System.out.println("1. Tiep tuc");
                                                System.out.println("0. Quay lai");
                                                int lc2 = sc.nextInt();
                                                switch (lc2) {
                                                    case 1: {
                                                        break;
                                                    }
                                                    case 0: {
                                                        ok1 = 0;
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println("Lua chon khong hop le!");
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 6: {
                                            int ok1 = 1;
                                            clearScreen();
                                            while(ok1 == 1){
                                                nhanvien.TimKiemNhanVienTheoMa();
                                                System.out.println("Ban co muon tim kiem Nhan Vien tiep khong?");
                                                System.out.println("1. Tiep tuc");
                                                System.out.println("0. Quay lai");
                                                int lc2 = sc.nextInt();
                                                switch (lc2) {
                                                    case 1: {
                                                        break;
                                                    }
                                                    case 0: {
                                                        ok1 = 0;
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println("Lua chon khong hop le!");
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 7: {
                                            int ok1 = 1;
                                            clearScreen();
                                            while (ok1 == 1) {
                                                System.out.println("Ban muon xem thong tin gi?");
                                                System.out.println("1. Xem Thong tin Nhan Vien");
                                                System.out.println("2. Xem Tai khoan Nhan Vien");
                                                System.out.println("0. Quay lai");
                                                System.out.print("Moi nhap lua chon (0 - 2) ");
                                                int lc2 = sc.nextInt();
                                                switch (lc2) {
                                                    case 1: {
                                                        clearScreen();
                                                        nhanvien.XemThongTinNhanVien();
                                                        break;
                                                    }
                                                    case 2: {
                                                        clearScreen();
                                                        nhanvien.XemTaiKhoanNhanVien();
                                                        break;
                                                    }
                                                    case 0: {
                                                        ok1 = 0;
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 0: {
                                            ok = 0;
                                            break;
                                        }
                                        default: {
                                            System.out.println("Lua chon khong hop le!");
                                            break;
                                        }
                                    }
                                }
                                break;
                            } else if (iLogin == 2 && iCnt != 0) {
                                System.out.println("Tai khoan hoac mat khau sai, hay thu lai, ban con " + --iCnt + " lan thu ");
                            } else if (iLogin == 1) {
                                System.out.println("Tai khoan khong ton tai, xin lien he voi bo phan cskh de dang ki tai khoan Quan Ly moi");
                                break;
                            }
                        }
                        if (iCnt == 0) {
                            System.out.println("Da qua so lan thu lai, hay thu lai sau!");
                        }
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                case 2: {
    while (!loggedIn) {
        System.out.println("Chao mung ban den voi ung dung van phong pham!");
        System.out.println("Chon tuy chon:");
        System.out.println("1. Dang ky");
        System.out.println("2. Dang nhap");
        System.out.print("Nhap lua chon (1 hoac 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            System.out.println("\nDang ky:");
            System.out.print("Nhap ten dang nhap: ");
            String username = scanner.nextLine();
            System.out.print("Nhap mat khau: ");
            String password = scanner.nextLine();
            khachHang = new KhachHang(username, password); // Initialize khachHang here
            try {
                taiKhoan.dangKy(khachHang);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            System.out.println("\nDang nhap:");
            System.out.print("Nhap ten dang nhap: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Nhap mat khau: ");
            String loginPassword = scanner.nextLine();

            try {
                loggedIn = taiKhoan.dangNhap(loginUsername, loginPassword);

                if (loggedIn) {
                    khachHang = new KhachHang(loginUsername, loginPassword); // Initialize khachHang here
                    taiKhoan.docThongTinNguoiDung(khachHang);
                } else {
                    System.out.println("Ten dang nhap hoac mat khau khong dung hoac tai khoan khong ton tai.");
                    System.out.println("Vui lòng dang ky tai khoan neu tai khoan khong ton tai.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Lua chon khong hop le.");
        }
    }

    // Người dùng đã đăng nhập, hiển thị tùy chọn mua sản phẩm
    boolean running = true;
    while (running) {
        while (loggedIn) {
            System.out.println("Chon tuy chon:");
            System.out.println("1. Mua san pham");
            System.out.println("2. Xem gio hang");
            System.out.println("3. Nhap thong tin nguoi dung");
            System.out.println("4. Xem thong tin nguoi dung");
            System.out.println("5. Dat don hang");
            System.out.println("6. Xem don hang");
            System.out.println("7. Xem binh luan");
            System.out.println("8. Dang xuat");
            System.out.println("Hay nhap thong tin nguoi dung truoc khi mua hang nhe!");
            System.out.print("Nhap lua chon (1, 2, 3, 4, 5, 6, 7, hoac 8): ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            if (userChoice == 1) {
                // Người dùng chọn mua sản phẩm
                gioHang.muaSanPham(sanPhamList, scanner);
            } else if (userChoice == 2) {
                // Người dùng chọn xem gio hang
                gioHang.xemGioHang();
            } else if (userChoice == 3) {
                // Người dùng chọn nhập thông tin
                try {
                    dangNhapNhapThongTin((KhachHang) khachHang, scanner, taiKhoan);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (userChoice == 4) {
                // Người dùng chọn xem thông tin
                xemThongTinNguoiDung((KhachHang) khachHang);
            } else if (userChoice == 5) {
                // Người dùng chọn đặt đơn hàng
                gioHang.datDonHang(scanner, khachHang);
            } else if (userChoice == 6) {
                gioHang.docDonHang(khachHang);
            } else if (userChoice == 7) {
                // User chooses to view comments
                System.out.println("Xem binh luan cua:");
                System.out.println("1. Sach");
                System.out.println("2. Vo");
                System.out.println("3. But");
                System.out.print("Nhap lua chon (1, 2 hoac 3): ");
                int productType = scanner.nextInt();
                scanner.nextLine();

                if (productType >= 1 && productType <= 3) {
                    int startIndex = (productType - 1) * 10;
                    hienThiSanPham(Arrays.copyOfRange(sanPhamList, startIndex, startIndex + 10));
                    System.out.print("Nhap lua chon san pham (1 den 10): ");
                    int productChoice = scanner.nextInt();
                    scanner.nextLine();

                    boolean continueLoop = true;
                    while (loggedIn && continueLoop) {
                        if (productChoice >= 1 && productChoice <= 10) {
                            SanPham chosenProduct = sanPhamList[startIndex + productChoice - 1];
                            BinhLuan binhLuan = new BinhLuan("BL" + (taiKhoan.soLuongNguoiDung + 1), "", chosenProduct);
                            binhLuan.xemBinhLuan(chosenProduct);
                            while (true) {
                                System.out.print("Ban co muon binh luan san pham nay khong? (y/n): ");
                                String commentChoice = scanner.nextLine();

                                if (commentChoice.equalsIgnoreCase("y")) {
                                    System.out.print("Nhap noi dung binh luan: ");
                                    String commentContent = scanner.nextLine();
                                    binhLuan.setNoiDung(commentContent);  // Update the comment content
                                    binhLuan.luuBinhLuan();
                                } else if (commentChoice.equalsIgnoreCase("n")) {
                                    continueLoop = false;
                                    break;  // Return to the main menu
                                } else {
                                    System.out.println("Lua chon khong hop le.");
                                }
                            }
                        } else {
                            System.out.println("Lua chon khong hop le.");
                        }
                    }
                } else {
                    System.out.println("Lua chon khong hop le.");
                }
            } // case 8 is missing here
            case 8: {
                System.out.println("Đang thoát chương trình...");
                System.exit(0);                
                System.out.println("Chương trình kết thúc.");
            }
        }
        clearScreen();
        break;
    }
}
                case 3: {
                    clearScreen();
                    break;
                }
                case 4: {
                    int ok = 1;
                    while (ok == 1) {
                        clearScreen();
                        Cskh.display();
                        System.out.println("1.Quay lai man hinh menu");
                        System.out.println("0.Thoat chuong trinh");
                        System.out.println("Moi ban nhap lua chon");
                        int sl2 = sc.nextInt();
                        switch (sl2) {
                            case 1: {
                                ok = 0;
                                break;
                            }
                            case 0: {
                                System.out.println("Cam on ban da su dung ung dung");
                                return;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    int ok = 1;
                    while (ok == 1) {
                        clearScreen();
                        ThongTinChuongTrinh.display();
                        System.out.println("1.Quay lai man hinh menu");
                        System.out.println("0.Thoat chuong trinh");
                        System.out.println("Moi ban nhap lua chon");
                        int sl;
                        sl = sc.nextInt();
                        switch (sl) {
                            case 1: {
                                ok = 0;
                                break;
                            }
                            case 0: {
                                System.out.println("Cam on ban da su dung ung dung");
                                return;
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    Feedback fb = new Feedback(0,"");
                    try {
                        fb.AddFeedback();
                        }
                    catch(IOException e){
                            e.printStackTrace();
                            }
                    break;
                }
                case 0: {
                    System.out.println("Cam on ban da su dung ung dung!");
                    return;
                }
            }
        }
    }
     public static SanPham[] taoDanhSachSanPham() {
        SanPham[] sanPhamList = new SanPham[30]; // Adjusted the array size to match the number of products

        // Thêm sản phẩm loại Sách
        sanPhamList[0] = new SanPham("Nha Gia Kim - Paulo Coelho", 63000);
        sanPhamList[1] = new SanPham("Dac Nhan Tam - Dale Carnegie", 60000);
        sanPhamList[2] = new SanPham("Cach nghi de thanh cong - Napoleon Hill", 45000);
        sanPhamList[3] = new SanPham("Hat giong tam hon - Jack Canfield", 50000);
        sanPhamList[4] = new SanPham("Quang ganh lo di va vui song - Dale Carnegie", 60000);
        sanPhamList[5] = new SanPham("Doc Vi Bat Ky Ai - David J.Lieberman", 55000);
        sanPhamList[6] = new SanPham("Tieu thuyet Bo Gia - Mario Puzo", 50000);
        sanPhamList[7] = new SanPham("Cuoc song khong gioi han - Nick Vujicic", 80000);
        sanPhamList[8] = new SanPham("Doi Thay Doi Khi Chung Ta Thay Doi - Andrew Matthews", 70000);
        sanPhamList[9] = new SanPham("Nguoi giau co nhat thanh Babylon - George Samuel Clason", 65000);

        // Thêm sản phẩm loại Vở
        sanPhamList[10] = new SanPham("Vo Deli", 10000);
        sanPhamList[11] = new SanPham("Vo Hai Tien", 9000);
        sanPhamList[12] = new SanPham("Vo Hong Ha", 11000);
        sanPhamList[13] = new SanPham("Vo Campus", 12000);
        sanPhamList[14] = new SanPham("Vo Thien Long", 13000);
        sanPhamList[15] = new SanPham("Vo Crabit", 14000);
        sanPhamList[16] = new SanPham("Vo KLONG", 15000);
        sanPhamList[17] = new SanPham("Vo Vinh Tien", 16000);
        sanPhamList[18] = new SanPham("Vo Tien Phat", 17000);
        sanPhamList[19] = new SanPham("Vo Tan Thuan Tien", 18000);

        // Thêm sản phẩm loại Bút
        sanPhamList[20] = new SanPham("But bi Thien Long TL-027", 5000);
        sanPhamList[21] = new SanPham("But bi Pentel BK250", 6000);
        sanPhamList[22] = new SanPham("But long bi Parker IM 2017", 7000);
        sanPhamList[23] = new SanPham("But bi 4 mau Deli S313", 8000);
        sanPhamList[24] = new SanPham("But bi gel Zebra Sarasa clip", 9000);
        sanPhamList[25] = new SanPham("But muc gel Xiaomi Mijia 0.5", 10000);
        sanPhamList[26] = new SanPham("But muc gel Stabilo Palette GP286XF", 11000);
        sanPhamList[27] = new SanPham("But bi Ben Nghe L28", 12000);
        sanPhamList[28] = new SanPham("But bi Flexoffice FO-069", 13000);
        sanPhamList[29] = new SanPham("But bi xoa Pilot Frixion Ball 0.5", 14000);

        return sanPhamList;
    }       
   
        public static void hienThiSanPham(SanPham[] sanPhamList) {
            for (int i = 0; i < sanPhamList.length; i++) {
                if (sanPhamList[i] != null) {
                    System.out.println((i + 1) + ". " + sanPhamList[i].getTen() + " - " + sanPhamList[i].getGia() + "VND");
                } else {
                    System.out.println((i + 1) + ". NULL");
                }
            }
        }
        private static void dangNhapNhapThongTin(KhachHang khachHang, Scanner scanner, TaiKhoan taiKhoan) throws IOException {
            khachHang.nhapThongTin(scanner);
            taiKhoan.saveUserInfoToFile(khachHang);
            System.out.println("Da nhap thong tin thanh cong.");
        }
       
        private static void xemThongTinNguoiDung(KhachHang khachHang) {
            System.out.println("Thong tin nguoi dung:");
            System.out.println("Ma nguoi dung: " + khachHang.maNguoiDung);
            System.out.println("Ho ten: " + khachHang.hoTen);
            System.out.println("So dien thoai: " + khachHang.soDienThoai);
            System.out.println("Dia chi: " + khachHang.diaChi);
        }
}
