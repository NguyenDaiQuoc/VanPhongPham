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

public abstract class HoaDon implements SanPham {

    Scanner sc = new Scanner(System.in);
    String FileHoaDon = ("Hoa Don.txt");
    File file = new File(FileHoaDon);

    public HoaDon(String name, int SoLuongSP, float gia, float ThanhTien) {
        super();
    }

    int SoLuongSP;
    float ThanhTien;
    float TongTien;

    public HoaDon(int SoLuongSP, float ThanhTien, float TongTien) {
        this.SoLuongSP = SoLuongSP;
        this.ThanhTien = ThanhTien;
        this.TongTien = TongTien;
    }

    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int SoLuongSP) {
        for (;;) {
            System.out.println("Moi nhap so luong san pham:");
            SoLuongSP = sc.nextInt();
            this.SoLuongSP = SoLuongSP;
            if (SoLuongSP > 0) {
                break;
            }
        }
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        ThanhTien = SoLuongSP * gia;
        this.ThanhTien = ThanhTien;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        TongTien += ThanhTien;
        this.TongTien = TongTien;
    }

    public HoaDon[] NhapTTHoaDon() {
        setSoLuongSP(0);
        setThanhTien(0);
        setTongTien(0);
        HoaDon[] TTHoaDon = new HoaDon[99];
        int c = 1;
        for (int i = 1; c != 0; i++) {
            System.out.println("Moi nhap thong tin hoa don:");
            TTHoaDon[i] = new HoaDon(name, getSoLuongSP(), gia, getThanhTien());
            System.out.println("Nhan 0 neu muon dung nhap hoa don:");
            c = sc.nextInt();
        }
        return TTHoaDon;
    }

    public void NhapHoaDonVaoFile() throws IOException {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date ngay = java.util.Calendar.getInstance().getTime();
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileHoaDon));
        writer.write(ngay + "/");
        for (int i = 1;; i++) {

        }
        //writer.write(TongTien +".\n");

    }

    public void XuatHoaDon() throws IOException {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new FileReader(FileHoaDon));
        String sLine;
        String fiHoaDon[] = new String[20];
        while ((sLine = reader.readLine()) != null) {
            fiHoaDon = sLine.split(",");
            fiHoaDon = sLine.split("/");
            fiHoaDon = sLine.split(".");

        }
    }

    public void XemHoaDon() {
    }
}
