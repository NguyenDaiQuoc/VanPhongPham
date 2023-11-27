
package com.mycompany.first.DoAn;

import java.util.Scanner;


public class DanhSachSanPham {
    private SanPham [] dsSp; // Danh sach san pham
    
    Scanner sc = new Scanner(System.in);
    
    public DanhSachSanPham() {
    }

    public DanhSachSanPham(SanPham[] dsSp) {
        this.dsSp = dsSp;
    }

    public SanPham[] getDs() {
        return dsSp;
    }

    public void setDs(SanPham[] dsSp) {
        this.dsSp = dsSp;
    }
    
    public void nhapDSSP(){
        int n;
        System.out.println("Moi nhap so luong san pham");
        n = Integer.parseInt(sc.nextLine());
        dsSp = new SanPham[n];
        for(int i = 0; i < n; i++){
            dsSp[i] = new SanPham();
            dsSp[i].nhapSanpham();
        }
    }
    
    public void xuatDSSP(){
        for(var x : dsSp){
            x.xuatSanPham();
        }
    }
}
