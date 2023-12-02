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
    
    public void ghiFileDSBut(){
        try{
            FileWriter fr = new FileWriter("DSBut.txt");
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
    
    public void docFileDSBut(){
        try{
            FileReader fr = new FileReader("DSBut.txt");
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
    
    public void addBut(){
        SanPham a = new But();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = a;
        System.out.println("Them But thanh cong");
        try{
            FileWriter fw = new FileWriter("DSBut.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.toString());
            bw.newLine();
        }
        catch(IOException ex){}
    }
    
    public void deleteBut(){
        System.out.print("Moi ban nhap ten But can xoa: ");
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
        System.out.println("Xoa But thanh cong");
        try{
            FileWriter fr = new FileWriter("DSBut.txt");
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
    
    public void updateBut(){
        System.out.print("Moi ban nhap id But can sua: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < ds.length; i++){
            if((ds[i].getIdSanpham().equals(tmp)) == true){
                ds[i].nhapSanpham();
            }
        }
        System.out.print("Sua But thanh cong");
        try{
            FileWriter fr = new FileWriter("DSBut.txt");
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
    
    public void xuatDSBut(){
        for(var x : ds){
            x.xuatSanpham();
            System.out.println();
        }
    }
    
}
