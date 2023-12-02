package com.vanphongpham;

import java.util.Scanner;
import java.util.Arrays;
import com.GioHang.GioHang;
import com.KhachHang.KhachHang;
import com.SanPham.SanPham;
import com.TaiKhoan.TaiKhoan;
import com.NguoiDung.NguoiDung;
import com.DonHang.DonHang;
import com.PhuongThucThanhToan.PhuongThucThanhToan;
import com.BinhLuan.BinhLuan;
import com.But.But;
import com.DanhSachBut.DanhSachBut;
import com.DanhSachSach.DanhSachSach;
import com.DanhSachVo.DanhSachVo;
import com.Sach.Sach;
import com.Vo.Vo;
import com.ThongTinChuongTrinh.ThongTinChuongTrinh;
import com.Cskh.Cskh;
import com.QuanLy.QuanLyFile;
import com.QuanLy.QuanLyArray;
import java.io.IOException;
import com.NhanVien.NhanVien;
import com.Feedback.Feedback;
import com.HoaDon.HoaDon;

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
        GioHang gioHang = new GioHang();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        SanPham[] sanPhamList = new SanPham[30];  // Adjust the size as needed

        // Initialize the book list (danhSachSach)
        DanhSachSach danhSachSach = new DanhSachSach();
        
        Sach[] ds1 = new Sach[10];  // Create an array of 10 Sach objects

for (int i = 0; i < ds1.length; i++) {
    // Initialize each Sach object in the array with predefined data
    ds1[i] = new Sach(
        "ID" + (i+1),
        "Book Title " + (i+1),
        "Author " + (i+1),
        i * 10.0f + 50.0f,
        i * 5 + 10,
        "2023-12-01",
        "Publisher " + (i+1),
        "Genre " + (i+1)
    );
}

danhSachSach.setDs(ds1);  // Set the ds array in danhSachSach


        // Initialize the notebook list (danhSachVo)
        DanhSachVo danhSachVo = new DanhSachVo();
        
        Vo[] ds2 = new Vo[10];  // Create an array of 10 Vo objects

for (int i = 0; i < ds2.length; i++) {
    // Initialize each Vo object in the array with predefined data
    ds2[i] = new Vo(
        "ID" + (i+1),
        "Notebook Title " + (i+1),
        i * 5.0f + 20.0f,
        i * 5 + 10,
        "2023-12-01",
        "Publisher " + (i+1),
        "Size " + (i+1)
    );
}

danhSachVo.setDs(ds2);  // Set the ds array in danhSachVo

        // Initialize the pen list (danhSachBut)
        DanhSachBut danhSachBut = new DanhSachBut(); 
        
        But[] ds3 = new But[10];  // Create an array of 10 But objects

for (int i = 0; i < ds3.length; i++) {
    // Initialize each But object in the array with predefined data
    ds3[i] = new But(
        "ID" + (i+1),
        "Pen Title " + (i+1),
        i * 2.0f + 10.0f,
        i * 5 + 10,
        "2023-12-01",
        "Publisher " + (i+1),
        "Type " + (i+1)
    );
}

danhSachBut.setDs(ds3);  // Set the ds array in danhSachBut

        // Add Sach objects to sanPhamList
System.arraycopy(ds1, 0, sanPhamList, 0, ds1.length);

// Add Vo objects to sanPhamList
System.arraycopy(ds2, 0, sanPhamList, ds1.length, ds2.length);

// Add But objects to sanPhamList
System.arraycopy(ds3, 0, sanPhamList, ds1.length + ds2.length, ds3.length);
        
        KhachHang khachHang = null;
        TaiKhoan taiKhoan = new TaiKhoan(); // You need to instantiate TaiKhoan
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
            System.out.println("8. Dang xuat va thoat chuong trinh");
            System.out.println("Hay nhap thong tin nguoi dung truoc khi mua hang nhe!");
            System.out.print("Nhap lua chon (1, 2, 3, 4, 5, 6, 7, hoac 8): ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            if (userChoice == 1) {
                gioHang.muaSanPham(sanPhamList, scanner, danhSachSach, danhSachVo, danhSachBut);
            }
            else if (userChoice == 2) {
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
} else if (userChoice == 8) {
    System.out.println("Dang dang xuat va thoat chuong trinh...");
    System.exit(0);                
    System.out.println("Chuong trinh ket thuc.");
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
   
       public static void hienThiSanPham(SanPham[] sanPhamList) {
            for (int i = 0; i < sanPhamList.length; i++) {
                if (sanPhamList[i] != null) {
                    System.out.println((i + 1) + ". " + sanPhamList[i].getName() + " - " + sanPhamList[i].getGia() + "VND");
                } else {
                    System.out.println((i + 1) + ". NULL");
                }
            }
        }
        private static void dangNhapNhapThongTin(KhachHang khachHang, Scanner scanner, TaiKhoan taiKhoan) throws IOException {
            khachHang.NhapThongTin();
            taiKhoan.saveUserInfoToFile(khachHang);
            System.out.println("Da nhap thong tin thanh cong.");
        }
       
        private static void xemThongTinNguoiDung(KhachHang khachHang) {
            System.out.println("Thong tin nguoi dung:");
            System.out.println("Ma nguoi dung: " + khachHang.sMaNguoiDung);
            System.out.println("Ho ten: " + khachHang.sHoTen);
            System.out.println("So dien thoai: " + khachHang.sSoDienThoai);
            System.out.println("Dia chi: " + khachHang.sDiaChi);
        }
}
