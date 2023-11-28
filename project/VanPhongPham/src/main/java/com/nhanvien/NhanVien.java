package com.nhanvien;

import com.nguoidung.NguoiDung;
import com.sanpham.SanPham;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
        

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

        public void XoaNhanVienTheoMa(String sMaNhanVien) {
        for (int i = 0; i < iSoLuongNhanVien; i++) {
            if (nvDsnv[i].getMaNhanVien().equals(sMaNhanVien)) {
                nvDsnv[i].setTrangThaiNhanVien(0);
                System.out.println("Da xoa Nhan Vien co ma: " + sMaNhanVien);
                return;
            }
        }
        System.out.println("Khong tim thay Nhan Vien co ma: " + sMaNhanVien);
    }
    
    public void XoaTatCaNhanVien() {
        for (int i = 0; i < iSoLuongNhanVien; i++) {
            nvDsnv[i].setTrangThaiNhanVien(0);            
        }
        System.out.println("Da xoa tat ca Nhan Vien");
        return;
    }
    
    public void HoanTacTatCaNhanVien() {
        for (int i = 0; i < iSoLuongNhanVien; i++) {
            nvDsnv[i].setTrangThaiNhanVien(1);
        }
        System.out.println("Da hoan tac xoa tat ca Nhan Vien.");
    }
    
    public void TimKiemNhanVienTheoMa(String sMaNhanVien) {
        for (int i = 0; i < iSoLuongNhanVien; i++) {
            if (nvDsnv[i].getMaNhanVien().equals(sMaNhanVien)) {
                NhanVien nv = nvDsnv[i];
                System.out.println("Thong tin Nhan Vien co ma " + sMaNhanVien + ":");
                System.out.println("Ho ten: " + nv.getHoTenNhanVien());
                System.out.println("Dia chi: " + nv.getDiaChiNhanVien());
                System.out.println("So dien thoai: " + nv.getSoDienThoaiNhanVien());
                System.out.println("Vai tro: " + nv.getVaiTroNhanVien());
                return;
            }
        }
        System.out.println("Khong tim thay Nhan Vien co ma: " + sMaNhanVien);
    }
    
    public void SuaThongTinNhanVienTheoMa(String sMaNhanVien) {
        for (int i = 0; i < iSoLuongNhanVien; i++) {
            if (nvDsnv[i].getMaNhanVien().equals(sMaNhanVien)) {
                // Gọi các setter để sửa thông tin
                nvDsnv[i].setHoTenNhanVien("");
                nvDsnv[i].setDiaChiNhanVien("");
                nvDsnv[i].setSoDienThoaiNhanVien("");
                System.out.println("Da sua thong tin cho Nhan Vien co ma: " + sMaNhanVien);
                return;
            }
        }
        System.out.println("Khong tim thay Nhan Vien co ma: " + sMaNhanVien);
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
    
    public class HoaDon extends SanPham {
        public HoaDon(String idSanPham, String name, float gia, int soluong, String ngaySx, String donviSx, String loai){
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
            for(;;){
                System.out.println("Moi nhap so luong san pham:");
                SoLuongSP=sc.nextInt();
                this.SoLuongSP = SoLuongSP;
                if(SoLuongSP>0) break;
            }
        }

        public float getThanhTien() {
            return ThanhTien;
        }

        public void setThanhTien(float ThanhTien) {
            ThanhTien=SoLuongSP*gia;
            this.ThanhTien = ThanhTien;
        }

        public float getTongTien() {
            return TongTien;
        }

        public void setTongTien(float TongTien) {
            this.TongTien = TongTien;
        }

        public String[] NhapTTHoaDon(){
        setSoLuongSP(sc.nextInt());
        setThanhTien(0);
        setTongTien(0);
            String[] TTHoaDon = {name, Integer.toString(getSoLuongSP()),Float.toString(gia), Float.toString(getThanhTien())};
        return TTHoaDon;
        }
        
        public void NhapHoaDon() throws IOException{
            File file=new File(FileHoaDon);
            try{
                if(!file.exists()){
                    file.createNewFile();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            Date ngay=java.util.Calendar.getInstance().getTime();
            BufferedWriter writer=new BufferedWriter(new FileWriter(FileHoaDon));
            writer.write(ngay + "/");
            for(int i=1;;i++){

            }

        
        }   

        public void XuatHoaDon(){

        }

        public void XemHoaDon(){

        }
    }
}
