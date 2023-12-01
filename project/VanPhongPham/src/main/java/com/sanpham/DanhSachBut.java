/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first.DoAn;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class DanhSachBut {
    private SanPham [] ds;
    
    Scanner sc = new Scanner(System.in);

    public DanhSachBut() {
    }

    public DanhSachBut(SanPham[] ds) {
        this.ds = ds;
    }
    
    SanPham but = new But();
    
    public void nhapDSBut(){
        int n;
        System.out.print("Moi ban nhap so luong loai but: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new But[n];     
        for(int i = 0; i < ds.length; i++){
            System.out.print("Moi ban nhap loai but thu " + (i + 1));
            ds[i] = new But();
            ds[i].nhapSanpham();
        }
    }
    
    public void xuatDSBut(){
        for(var x : ds){
            x.xuatSanpham();
        }
    }
    
    public void addBut(){
        SanPham a = new But();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = a;
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
    
}
