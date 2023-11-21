package com.vanphongpham;

import java.util.Scanner;
import com.user.User;
//hoac import com.vanphongpham.user.User;
import com.ThongTinChuongTrinh.ThongTinChuongTrinh;
import com.cskh.Cskh;
import com.quanly.QuanLy;
import java.io.IOException;
import com.nhanvien.NhanVien;
public class VanPhongPham {
    public static void clearScreen() {
        for (int i = 0; i < 31; ++i) System.out.println();
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Menu
        int lc;
        while(true){
            clearScreen();
            System.out.println("Chao mung ban den voi: Ung dung Ban van phong pham");
            System.out.println("Welcome to Program");
            System.out.println("==================================================");
            System.out.println("|Moi ban chon thao tac ung voi nhu cau cua minh  |");
            System.out.println("|1. Quan ly (Adminstrator) (2 File)  --> Quoc    |");
            System.out.println("|2. Nguoi dung (User)      (n File)  --> Thinh, Sang|");
            System.out.println("|3. Nhan vien (Staff)      (1 File)  --> Phat    |");
            System.out.println("|4. CSKH (Customer care)                         |");
            System.out.println("|5. Thong tin ve chuong trinh (Details)          |");
            System.out.println("|6. Gop y ve chuong trinh (Feedback) (1 File) --> Viet|");
            // UID, nd, date/time
            System.out.println("|0. Thoat ung dung (Exit application)            |");
            System.out.println("==================================================");
            System.out.print("Moi ban nhap lua chon (Please enter your choice): ");
            lc = sc.nextInt();
            switch(lc){
                case 1: {
                    int iCnt = 5, ok = 1;
                    QuanLy quanly = new QuanLy("", "", "QuanLy");
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
                                    System.out.println("|1. Dang ky tai khoan nhan vien                  |");
                                    System.out.println("|2. Xoa tai khoan nhan vien                      |");
                                    System.out.println("|3. Cap nhat thong tin nhan vien                 :");
                                    System.out.println("|4. Xem danh sach nhan vien                      :");
                                    System.out.println("|0. Thoat vai tro Quan Ly                        |");
                                    System.out.println("==================================================");
                                    System.out.print("Moi ban nhap mot lua chon (0-5) ");
                                    int lc1 = sc.nextInt();
                                    switch (lc1) {
                                        case 1: {
                                            try {
                                                quanly.DangKyTaiKhoanNhanVien();
                                            } catch (IOException e) {
                                                e.printStackTrace(); // hoặc xử lý theo nhu cầu của bạn
                                            }
                                            break;
                                        }
                                        case 2: {
                                            clearScreen();
                                            int ok1 = 1;
                                            while (ok1 == 1) {
                                                try {
                                                    quanly.XoaTaiKhoanNhanVien();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                System.out.println("Ban co muon xoa tiep?  ");
                                                System.out.println("1. Tiep tuc ");
                                                System.out.println("0. Quay lai ");
                                                System.out.print("Moi nhap lua chon ");
                                                int lc2 = sc.nextInt();
                                                switch(lc2){
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
                                        case 3: {
                                            quanly.CapNhatThongTinNhanVien();
                                            break;
                                        }
                                        case 4: {
                                            int ok1 = 1;
                                            clearScreen();
                                            while(ok1 == 1){                                                
                                                System.out.println("Ban muon them thong tin gi?");
                                                System.out.println("1. Xem Thong tin Nhan Vien");
                                                System.out.println("2. Xem Tai khoan Nhan Vien");
                                                System.out.println("0. Quay lai");
                                                System.out.print("Moi nhap lua chon (0 - 2) ");
                                                int lc2 = sc.nextInt();
                                                switch(lc2){
                                                    case 1: {
                                                        clearScreen();
                                                        quanly.XemThongTinNhanVien();
                                                        break;
                                                    }
                                                    case 2: {
                                                        clearScreen();
                                                        quanly.XemTaiKhoanNhanVien();
                                                        break;
                                                    }
                                                    case 0 :{
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
                                    }
                                }
                                break;
                            }
                            else if (iLogin == 2 && iCnt != 0) {
                                System.out.println("Tai khoan hoac mat khau sai, hay thu lai, ban con " + --iCnt + " lan thu ");
                            }
                            else if (iLogin == 1) {
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
                    //User usr = new User();
                    User.main(args);
                    break;
                }
                case 4: {
                    int ok = 1;
                    while(ok == 1){
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
                    while(ok == 1){
                        clearScreen();
                        //details.main(args);
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
                    break;
                }
                case 0: {
                    System.out.println("Cam on ban da su dung ung dung!");
                    return ;
                }
            }
        }
    }
}
