package com.nguoidung;
import java.util.Random;


public abstract class NguoiDung{
    public String sTenDangNhap, sMatKhau, sVaiTro, sHoTen, sSoDienThoai, sDiaChi, sMaNguoiDung;
    public int iTrangThai;
    
    //constructor dung de luu thong tin dang nhap
    public NguoiDung(String sTenDangNhap, String sMatKhau, String sVaiTro){
        this.sTenDangNhap = sTenDangNhap;
        this.sMatKhau = sMatKhau;
        this.sVaiTro = sVaiTro;
        this.iTrangThai = 1;
        this.sMaNguoiDung = GenerateUID();
    }
    // cac phuong thuc de lay thong tin ca nhan

    public void setsHoTen(String sHoTen) {
        this.sHoTen = sHoTen;
    }

    public void setsSoDienThoai(String sSoDienThoai) {
        this.sSoDienThoai = sSoDienThoai;
    }

    public void setsDiaChi(String sDiaChi) {
        this.sDiaChi = sDiaChi;
    }

    public void setsMaNguoiDung(String sMaNguoiDung) {
        this.sMaNguoiDung = sMaNguoiDung;
    }
    
    public String getHoTen(){
        return sHoTen;
    }
    public String getSoDienThoai(){
        return sSoDienThoai;
    }
    public String getDiaChi(){
        return sDiaChi;
    }
    public String getMaNguoiDung(){
        return sMaNguoiDung;
    }
    
    //methods
    public abstract void NhapThongTin();//hoac khong can abstract: public void NhapThongTIn(){}
    
    public String GenerateUID(){
        Random rd = new Random();
        //String UID = "";
        StringBuilder UID = new StringBuilder();
        String characters = "abcdefghijklmnoqprstuvwxyzABCDEFGHIJKLMNOPQRSTUVwXYZ0123456789";
        int i = 8; //UID chu 8 ky tu
        while(i --> 0){
            //UID = UID.concat(String.valueOf(characters.charAt(rd.nextInt(characters.length()))));
            UID.append(characters.charAt(rd.nextInt(characters.length())));
        }
        //return UID;
        return UID.toString();
    }
    
}