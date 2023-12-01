package com.NhanVien;

import com.NguoiDung.NguoiDung;
import com.SanPham.SanPham;
import com.HoaDon.HoaDon;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Arrays;
        

public class NhanVien extends NguoiDung {

    Scanner sc = new Scanner(System.in);
    String sTaiKhoanNhanVien, sMatKhauNhanVien, sHoTenNhanVien, sDiaChiNhanVien, sSoDienThoaiNhanVien, sMaNhanVien, sVaiTroNhanVien;
    String FileNameNhanVien = "Account Nhan Vien.txt";
    String FileThongTinNV = "Thong tin Nhan Vien.txt";
    String FileHoaDon = "File Hoa Don.txt";
    String FileTmp = "tmp.txt";
    File fileTmp = new File(FileTmp);
    File fileAcc = new File(FileNameNhanVien);
    File fileThongTin = new File(FileThongTinNV);
    NguoiDung NhanVien[] = new NguoiDung[10];
    public int iSoLuongNhanVien = 0; //Theo doi so luong nhan vien
    public int iTrangThai = 1;
    String sLine, fiNhanVien[];
    NhanVien nvDsnv[] = new NhanVien[999];
    public HoaDon hd = new HoaDon("",0,0,0);
    //constructor
    public NhanVien(String sTenDangNhap, String sMatKhau, String sVaiTro) {
        super(sTenDangNhap, sMatKhau, "NhanVien");
    }
    
    public NhanVien(){}
    
    public NhanVien(NhanVien other) {
        this.sTaiKhoanNhanVien = other.sTaiKhoanNhanVien;
        this.sMatKhauNhanVien = other.sMatKhauNhanVien;
        this.sHoTenNhanVien = other.sHoTenNhanVien;
        this.sDiaChiNhanVien = other.sDiaChiNhanVien;
        this.sSoDienThoaiNhanVien = other.sSoDienThoaiNhanVien;
        this.sMaNhanVien = other.sMaNhanVien;
        this.sVaiTroNhanVien = other.sVaiTroNhanVien;
        this.iTrangThai = other.iTrangThai;
    }
    
    public NhanVien(String sTaiKhoanNhanVien, String sMatKhauNhanVien, String sVaiTroNhanVien, int iTrangThai, String sMaNhanVien){
            this.sTaiKhoanNhanVien = sTaiKhoanNhanVien;
            this.sMatKhauNhanVien = sMatKhauNhanVien;   
            this.sVaiTroNhanVien = sVaiTroNhanVien;
            this.iTrangThai = iTrangThai;
            this.sMaNhanVien = sMaNhanVien;
    }//lay Account NhanVien
    public NhanVien(String sMaNhanVien, String sHoTenNhanVien, String sDiaChiNhanVien, String sSoDienThoaiNhanVien,int iTrangThai){
        this.sMaNhanVien = sMaNhanVien;
        this.sHoTenNhanVien = sHoTenNhanVien;
        this.sDiaChiNhanVien = sDiaChiNhanVien;
        this.sSoDienThoaiNhanVien = sSoDienThoaiNhanVien;
        this.iTrangThai = iTrangThai;
    } // lay Thong Tin NhanVien
    
    
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
            System.out.print("Moi nhap vai tro cua Nhan Vien (ThuNgan, Kho, TrucQuay) ");
            sVaiTroNhanVien = sc.nextLine();
            if (sVaiTroNhanVien.equals("ThuNgan") || sVaiTroNhanVien.equals("Kho") || sVaiTroNhanVien.equals("TrucQuay")) {
                break;
            }
            this.sVaiTroNhanVien = sVaiTroNhanVien;
        }
    }
    
    public int getTrangThaiNhanVien() {
        return iTrangThai;
    }

    public void setTrangThaiNhanVien(int iTrangThai) {
        this.iTrangThai = iTrangThai;
    }
    
    //method
    public void DocFileAccNhanVien() throws IOException {
        if (!fileAcc.exists()) {
            fileAcc.createNewFile();
        }
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader(fileAcc));
            while ((sLine = reader.readLine()) != null) {
                fiNhanVien = sLine.split(",");
                nvDsnv[i] = new NhanVien(fiNhanVien[0], fiNhanVien[1], fiNhanVien[2], Integer.parseInt(fiNhanVien[3]), fiNhanVien[4]);
                i++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public void DocFileThongTinNhanVien() throws IOException {
        if (!fileThongTin.exists()) {
            fileThongTin.createNewFile();
        }
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader(fileThongTin));
            while ((sLine = reader.readLine()) != null) {
                fiNhanVien = sLine.split(",");
                nvDsnv[i] = new NhanVien(fiNhanVien[9], fiNhanVien[1], fiNhanVien[2], fiNhanVien[3], Integer.parseInt(fiNhanVien[4]));
                i++;
            }
            iSoLuongNhanVien = i;
            reader.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public void GhiFileAccNhanVien() throws IOException {
        if (!fileAcc.exists()) {
            fileAcc.createNewFile();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileAcc, true));
            for (int i = 0; i < iSoLuongNhanVien; i++) {
                writer.write(nvDsnv[i].getTaiKhoanNhanVien() + "," + nvDsnv[i].getMatKhauNhanVien() + "," + nvDsnv[i].getVaiTroNhanVien() + "," + nvDsnv[i].getTrangThaiNhanVien() + "," + nvDsnv[i].getMaNhanVien() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public void GhiFileThongTinNhanVien() throws IOException {
        if (!fileThongTin.exists()) {
            fileThongTin.createNewFile();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileThongTin, true));
            for (int i = 0; i < iSoLuongNhanVien; i++) {
                writer.write(nvDsnv[i].getMaNhanVien() + "," + nvDsnv[i].getHoTenNhanVien() + "," + nvDsnv[i].getDiaChiNhanVien() + "," + nvDsnv[i].getSoDienThoaiNhanVien() + "," + nvDsnv[i].getVaiTroNhanVien() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error!");
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
        newNhanVien.setVaiTroNhanVien(sVaiTroNhanVien);
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

    public void XoaTaiKhoanNhanVienTheoTaiKhoan() throws IOException {
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
    
        public void XoaNhanVienTheoMa() throws IOException{
        File file = new File(FileNameNhanVien);
        File fileTmp = new File(FileTmp);
        File fileTT = new File(FileThongTinNV);
        System.out.print("Moi nhap ID Nhan Vien can xoa ");
        sMaNhanVien = sc.nextLine();
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
        while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if ((fiNhanVien[4].equals(sMaNhanVien) && fiNhanVien[3].equals("1"))) {
                bFound = true;
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
            System.out.println("Da xoa nhan vien co ID " + sMaNhanVien);
            String sLine1;
            String fiNhanVien1[] = new String[10];
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(FileTmp, true));
            BufferedReader reader1 = new BufferedReader(new FileReader(FileThongTinNV));
            while ((sLine1 = reader1.readLine()) != null) {
                fiNhanVien1 = sLine1.trim().split(",");
                if (fiNhanVien1[4].equals("1") && fiNhanVien1[0].equals(sMaNhanVien)) {
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
            System.out.println("Khong tim thay ID Nhan Vien can xoa!");
            fileTmp.delete();
        }
    }
    
    public void XoaTatCaNhanVien() throws IOException{
        File file = new File(FileNameNhanVien);
        File fileTmp = new File(FileTmp);
        File fileTT = new File(FileThongTinNV);
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
        while ((sLine = reader.readLine()) != null) {
                writer.write(fiNhanVien[0] + "," + fiNhanVien[1] + "," + fiNhanVien[2] + ",0," + fiNhanVien[4] + "\n");
        }
        reader.close();
        writer.close();
        if (bFound == true) {
            file.delete();
            fileTmp.renameTo(new File(FileNameNhanVien));
            String sLine1;
            String fiNhanVien1[] = new String[10];
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(FileTmp, true));
            BufferedReader reader1 = new BufferedReader(new FileReader(FileThongTinNV));
            while ((sLine1 = reader1.readLine()) != null) {
                fiNhanVien1 = sLine1.trim().split(",");
                    writer1.write(fiNhanVien1[0] + "," + fiNhanVien1[1] + "," + fiNhanVien1[2] + "," + fiNhanVien1[3] + "," + 0 + "\n");
            }
            writer1.close();
            reader1.close();
            fileTT.delete();
            fileTmp.renameTo(new File(FileThongTinNV));
            System.out.println("Da xoa tat ca Nhan Vien!");
        } else {
            System.out.println("Khong co tai khoan Nhan Vien can xoa!");
            fileTmp.delete();
        }
    }
    
    public void HoanTacXoaTatCaNhanVien() throws IOException{
        File file = new File(FileNameNhanVien);
        File fileTmp = new File(FileTmp);
        File fileTT = new File(FileThongTinNV);
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
        while ((sLine = reader.readLine()) != null) {
                writer.write(fiNhanVien[0] + "," + fiNhanVien[1] + "," + fiNhanVien[2] + ",1," + fiNhanVien[4] + "\n");
        }
        reader.close();
        writer.close();
        if (bFound == true) {
            file.delete();
            fileTmp.renameTo(new File(FileNameNhanVien));
            String sLine1;
            String fiNhanVien1[] = new String[10];
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(FileTmp, true));
            BufferedReader reader1 = new BufferedReader(new FileReader(FileThongTinNV));
            while ((sLine1 = reader1.readLine()) != null) {
                fiNhanVien1 = sLine1.trim().split(",");
                    writer1.write(fiNhanVien1[0] + "," + fiNhanVien1[1] + "," + fiNhanVien1[2] + "," + fiNhanVien1[3] + "," + 1 + "\n");
            }
            writer1.close();
            reader1.close();
            fileTT.delete();
            fileTmp.renameTo(new File(FileThongTinNV));
            System.out.println("Da hoan tac xoa tat ca Nhan Vien!");
        } else {
            System.out.println("Khong co thong tin can hoa tac!");
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
            System.out.println("Khong co thong tin tai khoan Nhan Vien!");
        }
    }
    

    public void TimKiemNhanVienTheoMa() throws IOException {
        File file = new File(FileThongTinNV);
        String fiNhanVien[] = new String[10]; //dung de quan ly thong tin nhan vien
        String sLine;
        System.out.print("Moi nhap ID Nhan Vien can tim kiem ");
        sMaNhanVien = sc.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(FileThongTinNV));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        NhanVien nv = new NhanVien("", "", "");
        boolean bFound = false;
        while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if (fiNhanVien[4].equals("1") && fiNhanVien[0].equals(sMaNhanVien)) {
                bFound = true;
                nv.LayThongTin();
                System.out.printf("%-12s%-25s%-20s%-15s\n", "Ma NV", "Ho & ten", "Dia chi", "So dien thoai");
                System.out.printf("%-12s%-25s%-20s%-15s\n", fiNhanVien[0], fiNhanVien[1], fiNhanVien[2], fiNhanVien[3]);
            } else {
                continue;
            }
        }
        if (bFound == false) {
            System.out.println("Khong co thong tin Nhan Vien mang ID " + sMaNhanVien);
        }
    }
        
    public void SapXepTheoMa() {
        Arrays.sort(nvDsnv, 0, iSoLuongNhanVien, (nv1, nv2) -> nv1.getMaNhanVien().compareTo(nv2.getMaNhanVien()));
        System.out.println("Da sap xep Nhan Vien theo ma.");
    }
    
    public void SapXepTheoVaiTro() {
        Arrays.sort(nvDsnv, 0, iSoLuongNhanVien, (nv1, nv2) -> nv1.getVaiTroNhanVien().compareTo(nv2.getVaiTroNhanVien()));
        System.out.println("Da sap xep Nhan Vien theo vai tro.");
    }
    
    public int DangNhap() throws IOException{
        setTaiKhoanNhanVien(sTaiKhoanNhanVien);
        setMatKhauNhanVien(sMatKhauNhanVien);
        File file=new File(FileNameNhanVien);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        int iLogin=1;
        BufferedReader reader=new BufferedReader(new FileReader(FileNameNhanVien));
        String sline;
        String fiNhanVien[]=new String[10];
        while((sline=reader.readLine())!=null){
            fiNhanVien=sline.split(",");
            if(!fiNhanVien[0].trim().equals(sTaiKhoanNhanVien)&&!fiNhanVien[1].trim().equals(sMatKhauNhanVien)){
                iLogin= -1;
            }
            else if(!fiNhanVien[0].trim().equals(sTaiKhoanNhanVien)||!fiNhanVien[1].trim().equals(sMatKhauNhanVien)){
                iLogin= 0;
            }
            else if(fiNhanVien[0].trim().equals(sTaiKhoanNhanVien)&&fiNhanVien[1].trim().equals(sMatKhauNhanVien)&&(fiNhanVien[2].trim().equals("Kho"))){
                iLogin= 1;
            }
            else if(fiNhanVien[0].trim().equals(sTaiKhoanNhanVien)&&fiNhanVien[1].trim().equals(sMatKhauNhanVien)&&(fiNhanVien[2].trim().equals("ThuNgan"))){
                iLogin= 2;
            }
            else if(fiNhanVien[0].trim().equals(sTaiKhoanNhanVien)&&fiNhanVien[1].trim().equals(sMatKhauNhanVien)&&(fiNhanVien[2].trim().equals("TrucQuay"))){
                iLogin= 3;
            }        
        }
        return iLogin;
    }
    
    
}
