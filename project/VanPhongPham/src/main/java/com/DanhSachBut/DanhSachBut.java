
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
        try{
            FileWriter fw = new FileWriter("DSBut.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.toString());
            bw.newLine();
        }
        catch(IOException ex){}
    }
    
    public void deleteBut(){
        System.out.println("Moi ban nhap ten But can xoa: ");
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
