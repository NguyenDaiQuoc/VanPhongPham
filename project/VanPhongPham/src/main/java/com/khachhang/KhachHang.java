package com.KhachHang;

import com.NguoiDung;
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

class KhachHang extends NguoiDung {
    KhachHang(String tenDangNhap, String matKhau) {
        super(sTenDangNhap, sMatKhau, "KhachHang");
    }

    @Override
    void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap ho ten: ");
        this.sHoTen = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.sSoDienThoai = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        this.sDiaChi = scanner.nextLine();
    }
}


