package com.vanphongpham;

import java.util.Scanner;
//hoac import com.vanphongpham.user.User;
import com.ThongTinChuongTrinh.ThongTinChuongTrinh;
import com.cskh.Cskh;
import com.quanly.QuanLy;
import java.io.IOException;
import com.nhanvien.NhanVien;
import com.feedback.Feedback;

public class VanPhongPham {

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
                                                System.out.println("Ban co muon dang ky tai khoan Nhan Vien tiep khong?");
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
                                        
                    try{
                        NhanVien nv = new NhanVien("","","",1,"");
                        int iLogin=nv.DangNhap();
                        if(iLogin==2){
                            nv.hd.NhapHoaDon();
                        }
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                    
                case 3: {
                    
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
}
