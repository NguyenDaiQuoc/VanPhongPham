package com.nhanvien;

import com.nguoidung.NguoiDung;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NhanVien extends NguoiDung {

    Scanner sc = new Scanner(System.in);
    String sTaiKhoanNhanVien, sMatKhauNhanVien, sHoTenNhanVien, sDiaChiNhanVien, sSoDienThoaiNhanVien, sMaNhanVien, sVaiTroNhanVien;
    String FileNameNhanVien = "Account Nhan Vien.txt";
    String FileThongTinNV = "Thong tin Nhan Vien.txt";
    String FileTmp = "tmp.txt";
    File fileTmp = new File(FileTmp);
    File fileAcc = new File(FileNameNhanVien);
    File fileThongTin = new File(FileThongTinNV);
    NguoiDung NhanVien[] = new NguoiDung[10];
    public int iSoLuongNhanVien = 0; //Theo doi so luong nhan vien
    public int iTrangThai = 1;
    String sLine, fiNhanVien[];
    NhanVien nvDsnv[] = new NhanVien[999];
    
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
            System.out.print("Moi nhap vai tro cua Nhan Vien ");
            sVaiTroNhanVien = sc.nextLine();
            if (sVaiTroNhanVien.equals("TuVan") || sVaiTroNhanVien.equals("ThuNgan") || sVaiTroNhanVien.equals("Kho") || sVaiTroNhanVien.equals("TrucQuay")) {
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
    public void DocFileAccNhanVien() throws IOException{
        if(!fileAcc.exists()){
             fileAcc.createNewFile();
            }
        try{
        int i = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileAcc));
        while((sLine = reader.readLine()) != null){
            fiNhanVien = sLine.split(",");
            nvDsnv[i] = new NhanVien(fiNhanVien[0],fiNhanVien[1],fiNhanVien[2],fiNhanVien[3].charAt(0),fiNhanVien[4]);
            i++;
        }
        reader.close();
        } catch(IOException e){
            System.out.println("Error!");
        }
    }
    
    public void DocFileThongTinNhanVien() throws IOException{
        if(!fileThongTin.exists())
            fileThongTin.createNewFile();
        try{
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader(fileThongTin));
            while((sLine = reader.readLine()) != null){
                fiNhanVien = sLine.split(",");
                nvDsnv[i] = new NhanVien(fiNhanVien[9],fiNhanVien[1], fiNhanVien[2],fiNhanVien[3],fiNhanVien[4].charAt(0));
                i++;
            }
            reader.close();
        } catch(IOException e){
            System.out.println("Error!");
        }
    }
    
    public void GhiFileAccNhanVien() throws IOException{
        if (!fileAcc.exists()) {
            fileAcc.createNewFile();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileAcc, true));
            for(int i = 0; i < iSoLuongNhanVien; i++){
                writer.write(nvDsnv[i].getTaiKhoanNhanVien() + "," + nvDsnv[i].getMatKhauNhanVien() + "," + nvDsnv[i].getVaiTroNhanVien() + "," + nvDsnv[i].getTrangThaiNhanVien() + "," + nvDsnv[i].getMaNhanVien() +"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
    
    public void GhiFileThongTinNhanVien() throws IOException{
        if (!fileThongTin.exists()) {
            fileThongTin.createNewFile();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileThongTin, true));
            for(int i = 0; i < iSoLuongNhanVien; i++){
                writer.write(nvDsnv[i].getMaNhanVien() + "," + nvDsnv[i].getHoTenNhanVien() + "," + nvDsnv[i].getDiaChiNhanVien() + "," + nvDsnv[i].getSoDienThoaiNhanVien() + "," + nvDsnv[i].getVaiTroNhanVien() +"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
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
            else if(fiNhanVien[0].trim().equals(sTaiKhoanNhanVien)&&fiNhanVien[1].trim().equals(sMatKhauNhanVien)&&(fiNhanVien[2].trim().equals("TuVan"))){
                iLogin= 4;
            }

        }
        return iLogin;
    }
}
