package com.HoaDon;

import com.SanPham.SanPham;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.io.File;

public class HoaDon implements SanPham {

    Scanner sc = new Scanner(System.in);
    String fileHoaDon = ("Hoa Don.txt");
    File file = new File(fileHoaDon);

    String name;
    int soLuongSP;
    float gia;
    float thanhTien;
    float tongTien;

    public HoaDon(String name, int soLuongSP, float gia, float thanhTien) {
        this.name = name;
        this.soLuongSP = soLuongSP;
        this.gia = gia;
        this.thanhTien = thanhTien;
    }

    public HoaDon(int soLuongSP, float thanhTien, float tongTien) {
        this.soLuongSP = soLuongSP;
        this.thanhTien = thanhTien;
        this.tongTien = tongTien;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        for (;;) {
            System.out.println("Moi nhap so luong san pham:");
            soLuongSP = sc.nextInt();
            this.soLuongSP = soLuongSP;
            if (soLuongSP > 0) {
                break;
            }
        }
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        thanhTien = soLuongSP * gia;
        this.thanhTien = thanhTien;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        tongTien += thanhTien;
        this.tongTien = tongTien;
    }

    public HoaDon[] nhapTTHoaDon() {
        setSoLuongSP(0);
        setThanhTien(0);
        setTongTien(0);
        HoaDon[] ttHoaDon = new HoaDon[99];
        int c = 1;
        for (int i = 1; c != 0; i++) {
            System.out.println("Moi nhap thong tin hoa don:");
            ttHoaDon[i] = new HoaDon(name, getSoLuongSP(), gia, getThanhTien());
            System.out.println("Nhan 0 neu muon dung nhap hoa don:");
            c = sc.nextInt();
        }
        return ttHoaDon;
    }

    public void nhapHoaDonVaoFile() throws IOException {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date ngay = java.util.Calendar.getInstance().getTime();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileHoaDon));
        writer.write(ngay + "/");
        // Add your code here to write into the file
        writer.close();
    }

    public void xuatHoaDon() throws IOException {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new FileReader(fileHoaDon));
        String sLine;
        String fiHoaDon[] = new String[20];
        while ((sLine = reader.readLine()) != null) {
            fiHoaDon = sLine.split(",");
            fiHoaDon = sLine.split("/");
            fiHoaDon = sLine.split(".");
            // Add your code here to use the split results
        }
        reader.close();
    }

    public void xemHoaDon() {
        // Add your code here
    }

    @Override
    public String getIdSanpham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getGia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSoluong() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getNgaySx() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDonviSx() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setIdSanpham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void nhapSanpham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void xuatSanpham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getFinalPrice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
