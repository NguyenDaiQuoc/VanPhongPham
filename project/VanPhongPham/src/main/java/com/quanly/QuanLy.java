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
    String FileNhanVien = "Thong tin Nhan Vien.txt";
    String FileTmp = "tmp.txt";
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
    
    /*//getter and setter
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
    */
    
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
        String UID;
        NhanVien newNhanVien = new NhanVien("", "", "NhanVien");
        newNhanVien.setTaiKhoanNhanVien(sTaiKhoanNhanVien);
        newNhanVien.setMatKhauNhanVien(sMatKhauNhanVien);
        //UID = newNhanVien.GenerateUID();
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileNameNhanVien, true));
        iSoLuongNhanVien++;
        //writer.write(newNhanVien.getTaiKhoanNhanVien() + "," + newNhanVien.getMatKhauNhanVien() + "," + newNhanVien.sVaiTro + "," + newNhanVien.iTrangThai + "," + UID + "\n");
        writer.write(newNhanVien.getTaiKhoanNhanVien() + "," + newNhanVien.getMatKhauNhanVien() + "," + newNhanVien.sVaiTro + "," + newNhanVien.iTrangThai + "," + newNhanVien.getMaNguoiDung() + "\n");
        writer.close();
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(FileNhanVien, true));
        //writer1.write(UID + "\n");
        writer1.write(newNhanVien.getMaNguoiDung() + "\n");
        writer1.close();
    }
    
    public void XoaTaiKhoanNhanVien() throws IOException {
        File file = new File(FileNameNhanVien);
        File file1 = new File(FileTmp);
        System.out.print("Moi nhap tai khoan Nhan Vien can xoa ");
        String sTaiKhoan = sc.nextLine();
        String fiNhanVien[] = new String[999]; //dung de quan ly thong tin nhan vien
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
        while ((sLine = reader.readLine()) != null) {
            fiNhanVien = sLine.split(",");
            if ((fiNhanVien[0].equals(sTaiKhoan) && fiNhanVien[3].equals("1")) || fiNhanVien[3].equals("0")) {
                writer.write(fiNhanVien[0] + "," + fiNhanVien[1] + "," + fiNhanVien[2] + ",0," + fiNhanVien[4] + "\n");
            }
            else {
                writer.write(fiNhanVien[0] + "," + fiNhanVien[1] + "," + fiNhanVien[2] + ",1," + fiNhanVien[4] + "\n");
            }
        }
        /*NhanVien nv = new NhanVien("","","NhanVien");
        while (nv.getTaiKhoanNhanVien() != null) {
            if(nv.getTaiKhoanNhanVien().equals(sTaiKhoan) && nv.getMatKhauNhanVien().equals(sMatKhau)){
                nv.sTenDangNhap = "";
                nv.sMatKhau = "";
                nv.sVaiTro = "";
                nv.iTrangThai = 0;
                iSoLuongNhanVien--;
                break;
            }            
        }*/
        reader.close();
        writer.close();
        file.delete();
        file1.renameTo(new File(FileNameNhanVien));        
        System.out.println("Da xoa nhan vien co tai khoan " + sTaiKhoan);
    }
    
    public void CapNhatThongTinNhanVien() throws IOException{
        File file = new File(FileTmp);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        File file1 = new File(FileNameNhanVien);
        File file2 = new File(FileNhanVien);
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileTmp, true));
        BufferedReader reader = new BufferedReader(new FileReader(FileNameNhanVien));
        BufferedReader reader1 = new BufferedReader(new FileReader(FileNhanVien));
        NhanVien nv = new NhanVien("","","NhanVien");
        System.out.println("Moi nhap thong tin Nhan Vien");
        System.out.print("Moi nhap ID cua Nhan Vien "); String ID = sc.nextLine();
        String sLine,sLine1;
        String fiNhanVien[] = new String[999];
        String fiNhanVien1[] = new String[999];
        boolean bFound = false;
        while ((sLine = reader.readLine()) != null) {
            while ((sLine1 = reader1.readLine()) != null) {
                fiNhanVien = sLine.trim().split(",");
                fiNhanVien1 = sLine1.trim().split(",");
                if(!fiNhanVien1[0].equals(fiNhanVien[4])){
                    //+ "," + fiNhanVien1[0] + "," + fiNhanVien1[3] + "," + fiNhanVien1[4] 
                    writer.write(fiNhanVien1[0] +  "\n");
                }
                if (fiNhanVien[3].equals("1") && fiNhanVien[4].equals(ID) && fiNhanVien1[0].equals(ID)) {
                    nv.setHoTenNhanVien(sHoTen);
                    nv.setDiaChiNhanVien(sDiaChi);
                    nv.setSoDienThoaiNhanVien(sSoDienThoai);
                    writer.write(ID + "," + nv.getHoTenNhanVien() + "," + nv.getDiaChiNhanVien() + "," + nv.getSoDienThoaiNhanVien() + ",1\n");
                    bFound = true;
                }
            }
        }
        writer.close();
        reader.close();
        reader1.close();
        if(bFound == true){
        file2.delete();
        file.renameTo(new File(FileNhanVien));
        System.out.println("Da cap nhat thong tin nhan vien ID = " + ID);
        }
        else {
            System.out.println("Khong tim thay Nhan Vien mang ID = " + ID);
        }
    }
    
    public void XemThongTinNhanVien() throws IOException{
        File file = new File(FileNhanVien);
        String fiNhanVien[] = new String[999]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileNhanVien));
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < iSoLuongNhanVien; i++) {
            while ((sLine = reader.readLine()) != null) {
                fiNhanVien = sLine.split(",");
                if (fiNhanVien[3].equals("1")) {
                    System.out.println();
                }
            }
        }
    }
    
    public void XemTaiKhoanNhanVien() throws IOException{
        File file = new File(FileNameNhanVien);
        String fiNhanVien[] = new String[999]; //dung de quan ly thong tin nhan vien
        String sLine;
        BufferedReader reader = new BufferedReader(new FileReader(FileNameNhanVien));
        System.out.println("Thong tin tai khoan Nhan Vien");
        System.out.println("Tai khoan\t\t\tMat khau");
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
                if (fiNhanVien[3].equals("1")) {
                    System.out.println(fiNhanVien[0] + "\t\t\t" + fiNhanVien[1]);
                }
            }
        
    }
}
