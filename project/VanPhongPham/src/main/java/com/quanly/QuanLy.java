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



public class QuanLy extends NguoiDung {
    Scanner sc = new Scanner (System.in);
    String sTaiKhoanNhanVien, sMatKhauNhanVien;
    String FileNameNhanVien = "Account Nhan Vien.txt";
    String FileNameQuanLy = "Account Quan Ly.txt";
    int iSoLuongNhanVien = 0; //Theo doi so luong nhan vien
    public QuanLy(String sTenDangNhap, String sMatKhau, String sVaiTro){
        super (sTenDangNhap, sMatKhau, "QuanLy");
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
    public String getTaiKhoanNhanVien(){
        return sTaiKhoanNhanVien;
    }
    public void setTaiKhoanNhanVien(String sTaiKhoanNhanVien){
        System.out.print("Moi nhap tai khoan Nhan Vien ");
        sTaiKhoanNhanVien = sc.nextLine();
        this.sTaiKhoanNhanVien = sTaiKhoanNhanVien;
    }
    public String getMatKhauNhanVien(){
        return sMatKhauNhanVien;
    }
    public void setMatKhauNhanVien(String sMatKhauNhanVien){
        System.out.print("Moi nhap mat khau Nhan Vien ");
        sMatKhauNhanVien = sc.nextLine();
        this.sMatKhauNhanVien = sMatKhauNhanVien;
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
            } else if ( !fiQuanLy[0].trim().equals(sTaiKhoan) || !fiQuanLy[1].trim().equals(sMatKhau)) {
                iLogin = 2;
            }
        }
        return iLogin;
    }

    public void DangKyTaiKhoanNhanVien() throws IOException{        
        File file = new File(FileNameNhanVien);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        NhanVien newNhanVien = new NhanVien("", "", "1");
        newNhanVien.setTaiKhoanNhanVien(sTaiKhoanNhanVien);
        newNhanVien.setMatKhauNhanVien(sMatKhauNhanVien);
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileNameNhanVien, true));
        iSoLuongNhanVien++;
        writer.write(newNhanVien.getTaiKhoanNhanVien() + "," + newNhanVien.getMatKhauNhanVien() + "," + "1" + "\n");
        writer.close();
    }
    
    public void XoaTaiKhoanNhanVien() throws IOException{
        File file = new File(FileNameNhanVien);
        System.out.print("Moi nhap tai khoan Nhan Vien ");
        String sTaiKhoan = sc.nextLine();
        String fiNhanVien[] = new String[999]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileNameNhanVien));
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        /*while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if((fiNhanVien[0].equals(sTaiKhoan)) && fiNhanVien[2].equals("1")){
                fiNhanVien[0] = null;
                fiNhanVien[1] = null;
                fiNhanVien[2] = "0";
                iSoLuongNhanVien--;
                break;
            }
        }*/
        NhanVien nv = new NhanVien("","","1");
        while (nv.getTaiKhoanNhanVien() != null) {
            if(nv.getTaiKhoanNhanVien().equals(sTaiKhoan) && nv.getMatKhauNhanVien().equals(sMatKhau)){
                nv.sTenDangNhap = "";
                nv.sMatKhau = "";
                nv.sVaiTro = "0";
                iSoLuongNhanVien--;
                break;
            }
            
        }
        System.out.println("Da xoa nhan vien co tai khoan " + sTaiKhoan);
        reader.close();
    }
    
    public void CapNhatThongTinNhanVien(){
        
    }
    
    public void XemDanhSachNhanVien(){
        
    }
}
