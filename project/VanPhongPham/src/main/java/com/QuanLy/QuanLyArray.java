package com.QuanLy;

import java.io.File;
import java.io.IOException;
import com.NguoiDung.NguoiDung;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import com.SanPham.SanPham;
import com.DanhSachVo.DanhSachVo;
import com.DanhSachSach.DanhSachSach;
import com.DanhSachBut.DanhSachBut;

public class QuanLyArray extends NguoiDung {

    Scanner sc = new Scanner(System.in);
    String sTaiKhoanQuanLy, sMatKhauQuanLy, sMaQuanLy;
    String FileNameQuanLy = "Tai Khoan Quan Ly.txt";
    String FileThongTinQL = "Thong Tin Quan Ly.txt";
    String FileTmp = "tmp.txt";
    String sHoTenQuanLy, sSoDienThoaiQuanLy, sDiaChiQuanLy;
    File fileTmp = new File(FileTmp);
    SanPham[] danhSachSanPham = new SanPham[10];

    //constructor
    public QuanLyArray(String sTenDangNhap, String sMatKhau, String sVaiTro) {
        super(sTenDangNhap, sMatKhau, "QuanLy");
    }

    public QuanLyArray() {
    }

    public QuanLyArray(String sTenDangNhap, String sMatKhau, String sVaiTro, String sMaQuanLy) {
        super(sTenDangNhap, sMatKhau, sVaiTro);
        this.sMaQuanLy = sMaQuanLy;
    }//lay thong tin account

    public QuanLyArray(String sMaQuanLy, String sHoTenQuanLy, String sDiaChiQuanLy, String sSoDienThoaiQuanLy, int iTrangThai) {
        this.sHoTenQuanLy = sHoTenQuanLy;
        this.sSoDienThoaiQuanLy = sSoDienThoaiQuanLy;
        this.sDiaChiQuanLy = sDiaChiQuanLy;
        this.sMaQuanLy = sMaQuanLy;
        this.iTrangThai = iTrangThai;
    }//lay thong tin

    public QuanLyArray(QuanLyArray a) {
        this.sTaiKhoanQuanLy = a.sTaiKhoanQuanLy;
        this.sMatKhauQuanLy = a.sMatKhauQuanLy;
        this.sVaiTro = a.sVaiTro;
        this.iTrangThai = a.iTrangThai;
        this.sMaNguoiDung = GenerateUID();
    }//copy

    //getter & setter 
    public String getHoTen() {
        return sHoTenQuanLy;
    }

    public void setHoTen(String sHoTen) {
        for (;;) {
            System.out.print("Moi nhap ho ten Quan Ly (khong duoc de trong) ");
            sHoTenQuanLy = sc.nextLine();
            this.sHoTenQuanLy = sHoTenQuanLy;
            if (sHoTenQuanLy != "") {
                break;
            }
        }
    }

    public String getSoDienThoai() {
        return sSoDienThoaiQuanLy;
    }

    public void setSoDienThoai(String sSoDienThoai) {
        for (;;) {
            System.out.print("Moi so dien thoai Quan Ly ");
            sSoDienThoaiQuanLy = sc.nextLine();
            this.sSoDienThoaiQuanLy = sSoDienThoaiQuanLy;
            if (sSoDienThoaiQuanLy != "") {
                break;
            }
        }
    }

    public String getDiaChi() {
        return sDiaChiQuanLy;
    }

    public void setDiaChi(String sDiaChi) {
        for (;;) {
            System.out.print("Moi nhap dia chi Quan Ly ");
            sDiaChiQuanLy = sc.nextLine();
            this.sDiaChiQuanLy = sDiaChiQuanLy;
            if (sDiaChiQuanLy != "") {
                break;
            }
        }
    }

    public String getsTaiKhoanQuanLy() {
        return sTaiKhoanQuanLy;
    }

    public void setsTaiKhoanQuanLy(String sTaiKhoanQuanLy) {
        this.sTaiKhoanQuanLy = sTaiKhoanQuanLy;
    }

    public String getsMatKhauQuanLy() {
        return sMatKhauQuanLy;
    }

    public void setsMatKhauQuanLy(String sMatKhauQuanLy) {
        this.sMatKhauQuanLy = sMatKhauQuanLy;
    }

    public String getsMaQuanLy() {
        return sMaQuanLy;
    }

    public void setsMaQuanLy(String sMaQuanLy) {
        this.sMaQuanLy = sMaQuanLy;
    }

    public String getsHoTenQuanLy() {
        return sHoTenQuanLy;
    }

    public void setsHoTenQuanLy(String sHoTenQuanLy) {
        this.sHoTenQuanLy = sHoTenQuanLy;
    }

    public String getsSoDienThoaiQuanLy() {
        return sSoDienThoaiQuanLy;
    }

    public void setsSoDienThoaiQuanLy(String sSoDienThoaiQuanLy) {
        this.sSoDienThoaiQuanLy = sSoDienThoaiQuanLy;
    }

    public String getsDiaChiQuanLy() {
        return sDiaChiQuanLy;
    }

    public void setsDiaChiQuanLy(String sDiaChiQuanLy) {
        this.sDiaChiQuanLy = sDiaChiQuanLy;
    }

    //Override de nhap thong tin ca nhan
    @Override
    public void NhapThongTin() {
        System.out.println("Moi nhap thong tin ca nhan Quan Ly");
    }

    public void LayThongTin() {
        System.out.println("Day la thong tin ca nhan Quan Ly");
    }

    public void LayTaiKhoan() {
        System.out.println("Day la thong tin tai khoan Quan Ly");
    }

    //methods
    public void DocFileAccQuanLy() {

    }

    public void DocFileThongTinQuanLy() {

    }

    public int DangNhapTaiKhoanQuanLy() throws IOException {
        System.out.print("Moi nhap tai khoan Quan Ly ");
        String sTaiKhoan = sc.nextLine();
        System.out.print("Moi nhap mat khau Quan Ly ");
        String sMatKhau = sc.nextLine();
        File file = new File(FileNameQuanLy);
        int iLogin = 1;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new FileReader(FileNameQuanLy));
        String sline;
        String fiQuanLy[] = new String[999];
        while ((sline = reader.readLine()) != null) {
            fiQuanLy = sline.split(",");
            if (fiQuanLy[0].trim().equals(sTaiKhoan) && fiQuanLy[1].trim().equals(sMatKhau)) {
                iLogin = 0;
            } else if (!fiQuanLy[0].trim().equals(sTaiKhoan) && !fiQuanLy[1].trim().equals(sMatKhau)) {
                return 1;
            } else if (!fiQuanLy[0].trim().equals(sTaiKhoan) || !fiQuanLy[1].trim().equals(sMatKhau)) {
                iLogin = 2;
            }
        }
        return iLogin;
    }

    public void CapNhatThongTinQuanLy() throws IOException {
        File fileTmp = new File(FileTmp);
        try {
            if (!fileTmp.exists()) {
                fileTmp.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File fileTTQL = new File(FileThongTinQL);
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileTmp));
        BufferedReader reader = new BufferedReader(new FileReader(FileThongTinQL));
        QuanLyArray ql = new QuanLyArray("", "", "QuanLy");
        System.out.print("Moi nhap ID cua Quan Ly can cap nhat ");
        String ID = sc.nextLine();
        String sLine;
        String fiQuanLy[] = new String[10];
        boolean bFound = false;
        ql.NhapThongTin();
        while ((sLine = reader.readLine()) != null) {
            fiQuanLy = sLine.split(",");
            if (fiQuanLy[0].equals(ID)) {
                ql.setHoTen(sHoTenQuanLy);
                ql.setDiaChi(sDiaChiQuanLy);
                ql.setSoDienThoai(sSoDienThoaiQuanLy);
                writer.write(ID + "," + ql.getHoTen() + "," + ql.getDiaChi() + "," + ql.getSoDienThoai() + ",1\n");
                bFound = true;
            } else {
                writer.write(fiQuanLy[0] + "," + fiQuanLy[1] + "," + fiQuanLy[2] + "," + fiQuanLy[3] + ",1\n");
            }
        }
        writer.close();
        reader.close();
        if (bFound == true) {
            if (!fileTTQL.delete()) {
                System.out.println("Khong the xoa file!");
            }
            fileTmp.renameTo(new File(FileThongTinQL));
            System.out.println("Da cap nhat thong tin Quan Ly ID = " + ID);
        } else {
            fileTmp.delete();
            System.out.println("Khong tim thay Quan Ly mang ID = " + ID);
        }
    }

    public void XemThongTinQuanLy() throws IOException {
        File file = new File(FileThongTinQL);
        String fiQuanLy[] = new String[10]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileThongTinQL));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuanLyArray ql = new QuanLyArray("", "", "");
        ql.LayThongTin();
        boolean bFound = false;
        System.out.printf("%-12s%-25s%-20s%-15s\n", "Ma QL", "Ho & ten", "Dia chi", "So dien thoai");
        while ((sLine = reader.readLine()) != null) {
            fiQuanLy = sLine.split(",");
            if (fiQuanLy[4].equals("1")) {
                bFound = true;
                System.out.printf("%-12s%-25s%-20s%-15s\n", fiQuanLy[0], fiQuanLy[1], fiQuanLy[2], fiQuanLy[3]);
            } else {
                continue;
            }
        }
        if (bFound == false) {
            System.out.println("Khong co thong tin Quan Ly");
        }
    }

    public void XemTaiKhoanQuanLy() throws IOException {
        File file = new File(FileNameQuanLy);
        String fiQuanLy[] = new String[10]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileNameQuanLy));
        QuanLyArray ql = new QuanLyArray("", "", "");
        ql.LayTaiKhoan();
        System.out.printf("%-20s%-30s%-16s\n", "Tai khoan", "Mat khau", "Vai Tro");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean bFound = false;
        while ((sLine = reader.readLine()) != null) {
            fiQuanLy = sLine.split(",");
            if (fiQuanLy[3].equals("1")) {
                bFound = true;
                System.out.printf("%-20s%-30s%-16s\n", fiQuanLy[0], fiQuanLy[1], fiQuanLy[2]);
            }
        }
        if (bFound == false) {
            System.out.println("Khong co thong tin tai khoan Quan Ly");
        }
    }

    public void XemSanPham() {
        DanhSachBut dsb = new DanhSachBut();
        DanhSachVo dsv = new DanhSachVo();
        DanhSachSach dss = new DanhSachSach();
        dsb.xuatDSBut();
        dsv.xuatDSVo();
        dss.xuatDSSach();
    }

}
