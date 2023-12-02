
package com.DanhSachBut;

import com.But.But;
import com.SanPham.SanPham;
import com.Vo.Vo;
import java.util.Scanner;
import java.util.Arrays;

public class DanhSachBut {
    private But[] ds; 
    
    Scanner sc = new Scanner(System.in);

    public DanhSachBut() {
    }

    public DanhSachBut(SanPham[] ds) {
        this.ds = (But[]) ds;
    }
    
    public void nhapDSBut(){
        int n;
        System.out.print("Moi ban nhap so loai but: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new But[n];     
        for(int i = 0; i < ds.length; i++){
            System.out.println("Moi ban nhap loai but thu " + (i + 1));
            ds[i] = new But();
            ds[i].nhapSanpham();
        }
    }
    
     public void xuatDSBut(){
        if (ds == null) {
            System.out.println("Khong co san pham");
        } else {
            for(var x : ds){
                x.xuatSanpham();
                System.out.println();
            }
        }
    }
    
    public void addBut(){
        SanPham a = new But();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = (But) a;
    }
    
    public void deleteBut(){
        System.out.println("Moi ban nhap ten But can xoa: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < ds.length; i++){
            if((ds[i].getName().compareTo(tmp)) == 1){
                for(int j = i; j < ds.length; j++){
                    ds[j] = ds[j + 1];
                    ds = Arrays.copyOf(ds, ds.length - 1);
                }
            }
        }
    }
    
    public void updateBut(){
        System.out.print("Moi ban nhap id But can sua: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < ds.length; i++){
            if((ds[i].getIdSanpham().compareTo(tmp)) == 1){
                ds[i].nhapSanpham();
            }
        }
    }

    public void setDs(SanPham[] ds) {
        this.ds = (But[]) ds;
    }
    
    public void timKiemBut(String keyword) {
    for (But but : ds) {
        if (but.getName().contains(keyword)) {
            but.xuatSanpham();
        }
    }
}
}
