package com.quanly;

import java.io.File;
import java.io.IOException;
import com.nguoidung.NguoiDung;
import java.util.Scanner;
import com.nhanvien.NhanVien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class QuanLyFile extends NguoiDung {

    Scanner sc = new Scanner(System.in);
    String sTaiKhoanNhanVien, sMatKhauNhanVien, sTaiKhoanQuanLy, sMatKhauQuanLy;
    String FileNameNhanVien = "Account Nhan Vien.txt";
    String FileNameQuanLy = "Account Quan Ly.txt";
    String FileThongTinNV = "Thong tin Nhan Vien.txt";
    String FileThongTinQL = "Thong tin Quan Ly.txt";
    String FileTmp = "tmp.txt";
    public static int iSoLuongNhanVien = 0; //Theo doi so luong nhan vien
    String sHoTenQuanLy, sSoDienThoaiQuanLy, sDiaChiQuanLy;
    
    //constructor
    public QuanLyFile(String sTenDangNhap, String sMatKhau, String sVaiTro) {
        super(sTenDangNhap, sMatKhau, "QuanLy");
    }
    public QuanLyFile(){};
    
    public QuanLyFile(String sTaiKhoanQuanLy, String sMatKhauQuanLy){
        this.sTaiKhoanQuanLy = sTaiKhoanQuanLy;
        this.sMatKhauQuanLy = sMatKhauQuanLy;
    }

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
        QuanLyFile ql = new QuanLyFile("", "", "QuanLy");
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
        //}
        writer.close();
        reader.close();
        if (bFound == true) {
                if(!fileTTQL.delete()) System.out.println("Khong the xoa file!");
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
        QuanLyFile ql = new QuanLyFile("", "", "");
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
        QuanLyFile ql = new QuanLyFile("", "", "");
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

    public void DangKyTaiKhoanNhanVien() throws IOException {
        File file = new File(FileNameNhanVien);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean bExists = false;
        NhanVien newNhanVien = new NhanVien("", "", "NhanVien");
        newNhanVien.setTaiKhoanNhanVien(sTaiKhoanNhanVien);
        newNhanVien.setMatKhauNhanVien(sMatKhauNhanVien);
        newNhanVien.setVaiTroNhanVien(sTaiKhoanNhanVien);
        //UID = newNhanVien.GenerateUID();
        BufferedReader reader = new BufferedReader(new FileReader(FileNameNhanVien));
        String sLine;
        String fiNhanVien[] = new String[10];
        while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if (fiNhanVien[0].equals(newNhanVien.getTaiKhoanNhanVien())) {
                System.out.println("Tai khoan nhan vien " + newNhanVien.getTaiKhoanNhanVien() + " da ton tai!");
                bExists = true;
                break;
            }
        }
        if (bExists == false) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileNameNhanVien, true));
            iSoLuongNhanVien++;
            //writer.write(newNhanVien.getTaiKhoanNhanVien() + "," + newNhanVien.getMatKhauNhanVien() + "," + newNhanVien.sVaiTro + "," + newNhanVien.iTrangThai + "," + UID + "\n");
            writer.write(newNhanVien.getTaiKhoanNhanVien() + "," + newNhanVien.getMatKhauNhanVien() + "," + newNhanVien.getVaiTroNhanVien() + "," + newNhanVien.iTrangThai + "," + newNhanVien.getMaNguoiDung() + "\n");
            writer.close();
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(FileThongTinNV, true));
            //writer1.write(UID + "\n");
            writer1.write(newNhanVien.getMaNguoiDung() + ",,,,1\n");
            writer1.close();
        }
    }

    public void XoaTaiKhoanNhanVien() throws IOException {
        File file = new File(FileNameNhanVien);
        File fileTmp = new File(FileTmp);
        File fileTT = new File(FileThongTinNV);
        System.out.print("Moi nhap tai khoan Nhan Vien can xoa ");
        String sTaiKhoan = sc.nextLine();
        String fiNhanVien[] = new String[10]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileNameNhanVien));
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileTmp, true));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean bFound = false;
        String ID = "";
        while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if ((fiNhanVien[0].equals(sTaiKhoan) && fiNhanVien[3].equals("1"))) {
                bFound = true;
                ID = fiNhanVien[4];
                System.out.println(fiNhanVien[4]);
                writer.write(fiNhanVien[0] + "," + fiNhanVien[1] + "," + fiNhanVien[2] + ",0," + fiNhanVien[4] + "\n");
            } else {
                writer.write(fiNhanVien[0] + "," + fiNhanVien[1] + "," + fiNhanVien[2] + ",1," + fiNhanVien[4] + "\n");
            }
        }
        reader.close();
        writer.close();
        if (bFound == true) {
            file.delete();
            fileTmp.renameTo(new File(FileNameNhanVien));
            System.out.println("Da xoa nhan vien co tai khoan " + sTaiKhoan);
            String sLine1;
            String fiNhanVien1[] = new String[10];
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(FileTmp, true));
            BufferedReader reader1 = new BufferedReader(new FileReader(FileThongTinNV));
            while ((sLine1 = reader1.readLine()) != null) {
                fiNhanVien1 = sLine1.trim().split(",");
                if (fiNhanVien1[4].equals("1") && fiNhanVien1[0].equals(ID)) {
                    writer1.write(fiNhanVien1[0] + "," + fiNhanVien1[1] + "," + fiNhanVien1[2] + "," + fiNhanVien1[3] + ",0\n");
                } else {
                    writer1.write(fiNhanVien1[0] + "," + fiNhanVien1[1] + "," + fiNhanVien1[2] + "," + fiNhanVien1[3] + "," + fiNhanVien1[4] + "\n");
                }
            }
            writer1.close();
            reader1.close();
            fileTT.delete();
            fileTmp.renameTo(new File(FileThongTinNV));
        } else {
            System.out.println("Khong tim thay tai khoan Nhan Vien can xoa");
            fileTmp.delete();
        }
    }

    public void CapNhatThongTinNhanVien() throws IOException {
        File fileTmp = new File(FileTmp);
        try {
            if (!fileTmp.exists()) {
                fileTmp.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file1 = new File(FileNameNhanVien);
        File fileTT = new File(FileThongTinNV);
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileTmp));
        //BufferedReader reader = new BufferedReader(new FileReader(FileNameNhanVien));
        BufferedReader reader1 = new BufferedReader(new FileReader(FileThongTinNV));
        NhanVien nv = new NhanVien("", "", "NhanVien");
        System.out.print("Moi nhap ID cua Nhan Vien can cap nhat thong tin ");
        String ID = sc.nextLine();
        String sLine, sLine1;
        //String fiNhanVien[] = new String[10];
        String fiNhanVien1[] = new String[10];
        boolean bFound = false;
        //while ((sLine = reader.readLine()) != null) {
        //reader1 = new BufferedReader(new FileReader(FileThongTinNV));
        nv.NhapThongTin();
        while ((sLine1 = reader1.readLine()) != null) {
            //fiNhanVien = sLine.split(",");
            fiNhanVien1 = sLine1.split(",");
            //if (fiNhanVien[3].equals("1") && fiNhanVien[4].equals(ID) && fiNhanVien1[0].equals(ID)) {
            if (fiNhanVien1[0].equals(ID)) {
                nv.setHoTenNhanVien(sHoTen);
                nv.setDiaChiNhanVien(sDiaChi);
                nv.setSoDienThoaiNhanVien(sSoDienThoai);
                writer.write(ID + "," + nv.getHoTenNhanVien() + "," + nv.getDiaChiNhanVien() + "," + nv.getSoDienThoaiNhanVien() + ",1\n");
                bFound = true;
            } //else if(!fiNhanVien[4].equals(fiNhanVien1[0]) && (fiNhanVien1[4].equals("1") || fiNhanVien1[4].equals("0"))){
            else {
                writer.write(fiNhanVien1[0] + "," + fiNhanVien1[1] + "," + fiNhanVien1[2] + "," + fiNhanVien1[3] + ",1\n");
            }
        }
        //}
        writer.close();
        reader1.close();
        if (bFound == true) {
            //reader.close();
            fileTT.delete();
            fileTmp.renameTo(new File(FileThongTinNV));
            System.out.println("Da cap nhat thong tin Nhan Vien ID = " + ID);
        } else {
            fileTmp.delete();
            System.out.println("Khong tim thay Nhan Vien mang ID = " + ID);
        }
    }

    public void XemThongTinNhanVien() throws IOException {
        File file = new File(FileThongTinNV);
        String fiNhanVien[] = new String[10]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileThongTinNV));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        NhanVien nv = new NhanVien("", "", "");
        nv.LayThongTin();
        boolean bFound = false;
        System.out.printf("%-12s%-25s%-20s%-15s\n", "Ma NV", "Ho & ten", "Dia chi", "So dien thoai");

        while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if (fiNhanVien[4].equals("1")) {
                bFound = true;
                System.out.printf("%-12s%-25s%-20s%-15s\n", fiNhanVien[0], fiNhanVien[1], fiNhanVien[2], fiNhanVien[3]);
            } else {
                continue;
            }
        }
        if (bFound == false) {
            System.out.println("Khong co thong tin Nhan Vien");
        }
    }

    public void XemTaiKhoanNhanVien() throws IOException {
        File file = new File(FileNameNhanVien);
        String fiNhanVien[] = new String[10]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileNameNhanVien));
        NhanVien nv = new NhanVien("", "", "");
        nv.LayTaiKhoan();
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
            fiNhanVien = sLine.split(",");
            if (fiNhanVien[3].equals("1")) {
                bFound = true;
                System.out.printf("%-20s%-30s%-16s\n", fiNhanVien[0], fiNhanVien[1], fiNhanVien[2]);
            }
        }
        if (bFound == false) {
            System.out.println("Khong co thong tin tai khoan Nhan Vien");
        }

    }
}
