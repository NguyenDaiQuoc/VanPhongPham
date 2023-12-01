/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first.DoAn;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class DanhSachVo {
    private SanPham [] ds;
    
    Scanner sc = new Scanner(System.in);

    public DanhSachVo() {
    }

    public SanPham[] getDs() {
        return ds;
    }

    public void setDs(SanPham[] ds) {
        this.ds = ds;
    }
    
    public void nhapDSVo(){
        int n;
        System.out.print("Moi ban nhap so loai Vo: ");
        n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            System.out.println("Moi ban nhap loai Vo thu " + (i + 1));
            ds[i] = new Vo();
            ds[i].nhapSanpham();
        }
    }
    
    public void xuatDSVo(){
        for(var x : ds){
            x.xuatSanpham();
            System.out.println();
        }
    }
    
    public void addVo(){
        SanPham a = new Vo();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = a;
    }
    
    public void deleteVo(){
        System.out.println("Moi ban nhap ten Vo can xoa: ");
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
    
    public void updateSach(){
        System.out.print("Moi ban nhap id Sach can sua: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < ds.length; i++){
            if((ds[i].getIdSanpham().compareTo(tmp)) == 1){
                ds[i].nhapSanpham();
            }
        }
    }
}
