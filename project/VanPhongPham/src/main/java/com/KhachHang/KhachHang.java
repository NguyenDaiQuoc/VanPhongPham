package com.KhachHang;

import com.NguoiDung.NguoiDung;

import java.util.Scanner;

public class KhachHang extends NguoiDung {
    // Default constructor
    public KhachHang() {
        super("", "", "KhachHang");
    }

    // Parameterized constructor
    public KhachHang(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau, "KhachHang");
    }
    
    // Copy constructor
    public KhachHang(KhachHang other) {
        super(other.sTenDangNhap, other.sMatKhau, other.sVaiTro);
        this.sHoTen = other.sHoTen;
        this.sSoDienThoai = other.sSoDienThoai;
        this.sDiaChi = other.sDiaChi;
    }

    @Override
    public void NhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        this.sHoTen = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.sSoDienThoai = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        this.sDiaChi = scanner.nextLine();
    }

    @Override
    public void LayThongTin() {
        System.out.println("Ho ten: " + sHoTen);
        System.out.println("So dien thoai: " + sSoDienThoai);
        System.out.println("Dia chi: " + sDiaChi);
    }

    @Override
    public void LayTaiKhoan() {
        System.out.println("Ten dang nhap: " + sTenDangNhap);
        System.out.println("Mat khau: " + sMatKhau);
        System.out.println("Vai tro: " + sVaiTro);
    }
}
