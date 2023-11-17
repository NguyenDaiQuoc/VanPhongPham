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
    String TaiKhoanNhanVien, MatKhauNhanVien;
    String FileNameNhanVien = "Account Nhan Vien.txt";
    String FileNameQuanLy = "Account Quan Ly.txt";
    NguoiDung NhanVien[] = new NguoiDung[999];
    int iSoLuongNhanVien = 0; //Theo doi so luong nhan vien
    public QuanLy(String TenDangNhap, String MatKhau, String VaiTro){
        super (TenDangNhap, MatKhau, "QuanLy");
        
    }
    
    //Override de nhap thong tin ca nhan
    @Override
    public void NhapThongTin() {
        System.out.print("Moi Nhap Ho Ten ");
        this.HoTen = sc.nextLine();
        System.out.print("Moi nhap SoDienThoai ");
        this.SoDienThoai = sc.nextLine();
        System.out.println("Moi nhap Dia Chi ");
        this.DiaChi = sc.nextLine();
    }
    
    //getter and setter
    public String getTaiKhoanNhanVien(){
        return TaiKhoanNhanVien;
    }
    public void setTaiKhoanNhanVien(String TaiKhoanNhanVien){
        System.out.print("Moi nhap tai khoan Nhan Vien ");
        TaiKhoanNhanVien = sc.nextLine();
        this.TaiKhoanNhanVien = TaiKhoanNhanVien;
    }
    public String getMatKhauNhanVien(){
        return MatKhauNhanVien;
    }
    public void setMatKhauNhanVien(String MatKhauNhanVien){
        System.out.print("Moi nhap mat khau Nhan Vien ");
        MatKhauNhanVien = sc.nextLine();
        this.MatKhauNhanVien = MatKhauNhanVien;
    }
    
    
    //methods
    
    public boolean DangNhapTaiKhoanQuanLy() throws IOException {
        System.out.print("Moi nhap tai khoan Quan Ly ");
        String sTaiKhoan = sc.nextLine();
        System.out.print("Moi nhap mat khau Quan Ly ");
        String sMatKhau = sc.nextLine();
        File file = new File(FileNameQuanLy);
        boolean bLogin = false;
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
        int iCnt = 5;//bien quan ly so lan dang nhap
        while ((sline = reader.readLine()) != null) {
            fiQuanLy = sline.split(",");
            if (fiQuanLy[0].trim().equals(sTaiKhoan) && fiQuanLy[1].trim().equals(sMatKhau)) {
                System.out.println("Dang nhap thanh cong voi vai tro Quan Ly");
                bLogin = true;
            } else if (!fiQuanLy[0].trim().equals(sTaiKhoan) || !fiQuanLy[1].trim().equals(sMatKhau)) {
                System.out.println("Tai khoan hoac mat khau sai, hay thu lai, ban con " + --iCnt + "lan thu");
            } else if (!fiQuanLy[0].trim().equals(sTaiKhoan) && !fiQuanLy[1].trim().equals(sMatKhau)) {
                System.out.println("Tai khoan khong ton tai, xin lien he voi bo phan cskh");
                bLogin = false;
            }
            if (iCnt == 0) {
                System.out.println("Da qua so lan thu lai, hay thu lai sau!");
                bLogin = false;
            }
        }
        return bLogin;
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
        setTaiKhoanNhanVien(TaiKhoanNhanVien);
        setMatKhauNhanVien(MatKhauNhanVien);
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileNameNhanVien,true));
        iSoLuongNhanVien++;
        for(int i = 0; i < iSoLuongNhanVien; i++){
            writer.write(NhanVien[i].TenDangNhap + " " + NhanVien[i].MatKhau + "" + "NhanVien"); iSoLuongNhanVien++;  
        }
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
        while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if(fiNhanVien[0].equals(sTaiKhoan)){
                this.TaiKhoanNhanVien = null;
                this.MatKhauNhanVien = null;
                this.VaiTro = null;
            }
            iSoLuongNhanVien--;
        }
    }
    
    public void CapNhatThongTinNhanVien(){
        
    }
    
    public void XemDanhSachNhanVien(){
        
    }
}
