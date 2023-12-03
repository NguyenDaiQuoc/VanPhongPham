
package com.Kho;

import com.DanhSachSanPham.DanhSachSanPham;
import com.SanPham.SanPham;
import java.util.Scanner;


public abstract class Kho implements SanPham {
    Scanner sc = new Scanner(System.in);
    private final SanPham[] DanhSachSanPham;
    private int SoLuongSP;
    
    public Kho(int KichThuoc){
        this.DanhSachSanPham=new SanPham[KichThuoc];
        this.SoLuongSP=0;
    }

    public Kho(SanPham[] DanhSachSanPham, int SoLuongSP) {
        this.DanhSachSanPham = DanhSachSanPham;
        this.SoLuongSP = SoLuongSP;
    }

    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int SoLuongSP) {
        this.SoLuongSP = SoLuongSP;
    }
    
    
    
    @Override
    public String getIdSanpham() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public float getGia() {
        return 0;
    }

    @Override
    public int getSoluong() {
        return 0;
    }

    @Override
    public String getNgaySx() {
        return null;
    }

    @Override
    public String getDonviSx() {
        return null;
    }

    @Override
    public void setIdSanpham() {
    }

    @Override
    public void nhapSanpham() {
    }

    @Override
    public void xuatSanpham() {
    }

    @Override
    public double getFinalPrice() {
        return 0;
    }


    
    public void CapNhatSL(String IdSanpham,int SoLuongThem){
        SanPham sanPham = timSanPham(IdSanpham);
        if (sanPham != null) {
            int soLuongMoi = sanPham.getSoluong() + SoLuongThem;
            sanPham.setSoluong(soLuongMoi);
            System.out.println("Số lượng sản phẩm " + IdSanpham + " đã được cập nhật thành " + soLuongMoi);
        } else {
            System.out.println("Sản phẩm có ID " + IdSanpham + " không tồn tại trong kho.");
        }
    }
    
    private SanPham timSanPham(String IdSanpham) {
        for (int i = 0; i < SoLuongSP; i++) {
            if (DanhSachSanPham[i].getIdSanpham().equals(IdSanpham)) {
                return DanhSachSanPham[i];
            }
        }
        return null;
    }
}

