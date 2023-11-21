package com.nhanvien;

import com.nguoidung.NguoiDung;
import java.util.Scanner;

public class NhanVien extends NguoiDung {

    Scanner sc = new Scanner(System.in);
    String sTaiKhoanNhanVien, sMatKhauNhanVien, sHoTenNhanVien, sDiaChiNhanVien, sSoDienThoaiNhanVien, sMaNhanVien;
    String FileNameNhanVien = "Account Nhan Vien.txt";
    String FileNameQuanLy = "Account Quan Ly.txt";
    NguoiDung NhanVien[] = new NguoiDung[999];
    int iSoLuongNhanVien = 0; //Theo doi so luong nhan vien

    public NhanVien(String sTenDangNhap, String sMatKhau, String sVaiTro) {
        super(sTenDangNhap, sMatKhau, "NhanVien");
    }

    //Override de nhap thong tin ca nhan
    @Override
    public void NhapThongTin() {
        System.out.print("Moi Nhap Ho Ten ");
        this.sHoTen = sc.nextLine();
        System.out.print("Moi nhap SoDienThoai ");
        this.sSoDienThoai = sc.nextLine();
        System.out.println("Moi nhap Dia Chi ");
        this.sDiaChi = sc.nextLine();
    }

    //getter and setter
    public String getTaiKhoanNhanVien() {
        return sTaiKhoanNhanVien;
    }

    public void setTaiKhoanNhanVien(String sTaiKhoanNhanVien) {
        System.out.print("Moi nhap tai khoan Nhan Vien ");
        sTaiKhoanNhanVien = sc.nextLine();
        this.sTaiKhoanNhanVien = sTaiKhoanNhanVien;
    }

    public String getMatKhauNhanVien() {
        return sMatKhauNhanVien;
    }

    public void setMatKhauNhanVien(String sMatKhauNhanVien) {
        sc.nextLine();
        System.out.print("Moi nhap mat khau Nhan Vien ");
        sMatKhauNhanVien = sc.nextLine();
        this.sMatKhauNhanVien = sMatKhauNhanVien;
    }

    public String getHoTenNhanVien() {
        return sHoTenNhanVien;
    }

    public void setHoTenNhanVien(String sHoTenNhanVien) {
        System.out.print("Moi nhap ho ten Nhan Vien ");
        sHoTenNhanVien = sc.nextLine();
        this.sHoTenNhanVien = sHoTenNhanVien;
    }

    public String getDiaChiNhanVien() {
        return sDiaChiNhanVien;
    }

    public void setDiaChiNhanVien(String sDiaChiNhanVien) {
        System.out.print("Moi nhap dia chi Nhan Vien ");
        sDiaChiNhanVien = sc.nextLine();
        this.sDiaChiNhanVien = sDiaChiNhanVien;
    }

    public String getSoDienThoaiNhanVien() {
        return sSoDienThoaiNhanVien;
    }

    public void setSoDienThoaiNhanVien(String sSoDienThoaiNhanVien) {
        System.out.print("Moi nhap so dien thoai Nhan Vien ");
        sSoDienThoaiNhanVien = sc.nextLine();
        this.sSoDienThoaiNhanVien = sSoDienThoaiNhanVien;
    }

    public String getMaNhanVien() {
        return sMaNhanVien;
    }

    public void setMaNhanVien(String sMaNhanVien) {
        this.sMaNhanVien = sMaNhanVien;
    }
    
}
