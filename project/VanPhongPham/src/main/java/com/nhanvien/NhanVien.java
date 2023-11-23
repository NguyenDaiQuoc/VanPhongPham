package com.nhanvien;

import com.nguoidung.NguoiDung;
import java.util.Scanner;

public class NhanVien extends NguoiDung {

    Scanner sc = new Scanner(System.in);
    String sTaiKhoanNhanVien, sMatKhauNhanVien, sHoTenNhanVien, sDiaChiNhanVien, sSoDienThoaiNhanVien, sMaNhanVien, sVaiTroNhanVien;
    String FileNameNhanVien = "Account Nhan Vien.txt";
    String FileNameQuanLy = "Account Quan Ly.txt";
    NguoiDung NhanVien[] = new NguoiDung[10];
    int iSoLuongNhanVien = 0; //Theo doi so luong nhan vien

    public NhanVien(String sTenDangNhap, String sMatKhau, String sVaiTro) {
        super(sTenDangNhap, sMatKhau, "NhanVien");
    }

    //Override de nhap thong tin ca nhan
    @Override
    public void NhapThongTin() {
        System.out.println("Moi nhap cac thong tin cua Nhan Vien");
    }

    public void LayThongTin() {
        System.out.println("Day la cac thong tin cua Nhan Vien");
    }

    public void LayTaiKhoan() {
        System.out.println("Day la thong tin tai khoan cua Nhan Vien");
    }

    //getter and setter
    public String getTaiKhoanNhanVien() {
        return sTaiKhoanNhanVien;
    }

    public void setTaiKhoanNhanVien(String sTaiKhoanNhanVien) {
        for (;;) {
            System.out.print("Moi nhap tai khoan Nhan Vien (khong duoc de trong) ");
            sTaiKhoanNhanVien = sc.nextLine();
            this.sTaiKhoanNhanVien = sTaiKhoanNhanVien;
            if (sTaiKhoanNhanVien != "") {
                break;
            }
        }
    }

    public String getMatKhauNhanVien() {
        return sMatKhauNhanVien;
    }

    public void setMatKhauNhanVien(String sMatKhauNhanVien) {
        for (;;) {
            System.out.print("Moi nhap mat khau Nhan Vien (khong duoc de trong) ");
            sMatKhauNhanVien = sc.nextLine();
            this.sMatKhauNhanVien = sMatKhauNhanVien;
            if (sMatKhauNhanVien != "") {
                break;
            }
        }
    }

    public String getHoTenNhanVien() {
        return sHoTenNhanVien;
    }

    public void setHoTenNhanVien(String sHoTenNhanVien) {
        for (;;) {
            System.out.print("Moi nhap ho ten Nhan Vien (khong duoc de trong) ");
            sHoTenNhanVien = sc.nextLine();
            this.sHoTenNhanVien = sHoTenNhanVien;
            if (sHoTenNhanVien != "") {
                break;
            }
        }
    }

    public String getDiaChiNhanVien() {
        return sDiaChiNhanVien;
    }

    public void setDiaChiNhanVien(String sDiaChiNhanVien) {
        for (;;) {
            System.out.print("Moi nhap dia chi Nhan Vien ");
            sDiaChiNhanVien = sc.nextLine();
            this.sDiaChiNhanVien = sDiaChiNhanVien;
            if (sDiaChiNhanVien != "") {
                break;
            }
        }
    }

    public String getSoDienThoaiNhanVien() {
        return sSoDienThoaiNhanVien;
    }

    public void setSoDienThoaiNhanVien(String sSoDienThoaiNhanVien) {
        for (;;) {
            System.out.print("Moi nhap so dien thoai Nhan Vien (10 so va khong duoc de trong) ");
            sSoDienThoaiNhanVien = sc.nextLine();
            this.sSoDienThoaiNhanVien = sSoDienThoaiNhanVien;
            if (sSoDienThoaiNhanVien.length() == 10 && sSoDienThoaiNhanVien != "") {
                break;
            }
        }
    }

    public String getMaNhanVien() {
        return sMaNhanVien;
    }

    public void setMaNhanVien(String sMaNhanVien) {
        this.sMaNhanVien = sMaNhanVien;
    }

    public String getVaiTroNhanVien() {
        return sVaiTroNhanVien;
    }

    public void setVaiTroNhanVien(String sVaiTroNhanVien) {
        for (;;) {
            System.out.println("Moi nhap vai tro cua Nhan Vien ");
            sVaiTroNhanVien = sc.nextLine();
            if (sVaiTroNhanVien.equals("TuVan") || sVaiTroNhanVien.equals("ThuNgan") || sVaiTroNhanVien.equals("Kho") || sVaiTroNhanVien.equals("TrucQuay")) {
                break;
            }
            this.sVaiTroNhanVien = sVaiTroNhanVien;
        }
    }

}
