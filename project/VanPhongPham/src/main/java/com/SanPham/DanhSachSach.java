/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first.DoAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class DanhSachSach {
    private SanPham [] ds;
    
    Scanner sc = new Scanner(System.in);

    public DanhSachSach() {
    }

    public DanhSachSach(SanPham[] ds) {
        this.ds = ds;
    }

    public SanPham[] getDs() {
        return ds;
    }

    public void setDs(SanPham[] ds) {
        this.ds = ds;
    }
    
    public void nhapDSSach(){
        int n;
        System.out.print("Moi ban nhap so loai Sach: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Sach[n];
        for(int i = 0; i < ds.length; i++){
            System.out.println("Moi ban nhap loai Sach thu " + (i + 1));
            ds[i] = new Sach();
            ds[i].nhapSanpham();
        }
    }
    
    public void ghiFileDSSach(){
        try{
            FileWriter fr = new FileWriter("DSSach.txt");
            BufferedWriter bw = new BufferedWriter(fr);
            for(var x : ds){
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fr.close();
        }
        catch(IOException ex){}
    }
    
    public void docFileDSSach(){
        try{
            FileReader fr = new FileReader("DSSach.txt");
            BufferedReader br = new BufferedReader(fr);
            String tmp = "";
            while(tmp != null){
                System.out.println(tmp);
                tmp = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch(IOException ex){}
    }
    
    public void addSach(){
        SanPham a = new Sach();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = a;
        System.out.println("Them Bui thanh cong");
        try{
            FileWriter fw = new FileWriter("DSSach.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.toString());
            bw.newLine();
        }
        catch(IOException ex){}
    }
    
    public void deleteSach(){
        System.out.print("Moi ban nhap ten Sach can xoa: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < ds.length; i++){
            if((ds[i].getName().equals(tmp)) == true){
                if(i == ds.length - 1) ds = Arrays.copyOf(ds, ds.length - 1);
                else{
                    for(int j = i; j < ds.length - 1; j++){
                    ds[j] = ds[j + 1];
                    ds = Arrays.copyOf(ds, ds.length - 1);
                    }
                }
            }
        }
        try{
            FileWriter fr = new FileWriter("DSSach.txt");
            BufferedWriter bw = new BufferedWriter(fr);
            for(var x : ds){
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fr.close();
        }
        catch(IOException ex){}
    }
    
    public void updateSach(){
        System.out.print("Moi ban nhap id sach can sua: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < ds.length; i++){
            if((ds[i].getIdSanpham().equals(tmp)) == true){
                ds[i].nhapSanpham();
            }
        }
        try{
            FileWriter fr = new FileWriter("DSSach.txt");
            BufferedWriter bw = new BufferedWriter(fr);
            for(var x : ds){
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fr.close();
        }
        catch(IOException ex){}
    }
    
    public void xuatDSSach(){
        for(var x : ds){
            x.xuatSanpham();
            System.out.println();
        }
    }
    
}
