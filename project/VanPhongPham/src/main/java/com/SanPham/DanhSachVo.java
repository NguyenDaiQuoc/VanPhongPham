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
        ds = new Vo[n];
        for(int i = 0; i < ds.length; i++){
            System.out.println("Moi ban nhap loai Vo thu " + (i + 1));
            ds[i] = new Vo();
            ds[i].nhapSanpham();
        }
    }
    
    public void ghiFileDSVo(){
        try{
            FileWriter fr = new FileWriter("DSVo.txt");
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
    
    public void docFileDSVo(){
        try{
            FileReader fr = new FileReader("DSVo.txt");
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
    
    public void addVo(){
        SanPham a = new Vo();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = a;
        System.out.println("Them but thanh cong");
        try{
            FileWriter fw = new FileWriter("DSVo.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.toString());
            bw.newLine();
        }
        catch(IOException ex){}
    }
    
    public void deleteVo(){
        System.out.print("Moi ban nhap ten Vo can xoa: ");
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
            FileWriter fr = new FileWriter("DSVo.txt");
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
        System.out.print("Moi ban nhap id Sach can sua: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < ds.length; i++){
            if((ds[i].getIdSanpham().equals(tmp)) == true){
                ds[i].nhapSanpham();
            }
        }
        try{
            FileWriter fr = new FileWriter("DSVo.txt");
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
    
    public void xuatDSVo(){
        for(var x : ds){
            x.xuatSanpham();
            System.out.println();
        }
    }
}
