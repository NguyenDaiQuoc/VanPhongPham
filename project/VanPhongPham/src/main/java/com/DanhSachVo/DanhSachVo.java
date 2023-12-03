
package com.DanhSachVo;

import com.SanPham.SanPham;
import com.Vo.Vo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DanhSachVo {
    private Vo[] ds;
    
    Scanner sc = new Scanner(System.in);

    public DanhSachVo() {
    }

    public SanPham[] getDs() {
        return ds;
    }

    public void setDs(SanPham[] ds) {
        this.ds = (Vo[]) ds;
    }
    
    public Vo createVoFromUserInput() {
    Scanner sc = new Scanner(System.in);
    Vo vo = new Vo();

    System.out.print("Moi ban nhap id Vo: ");
    String idSanpham = sc.nextLine();
    vo.setIdSanpham(idSanpham);

    System.out.print("Moi ban nhap ten Vo: ");
    String name = sc.nextLine();
    vo.setName(name);

    System.out.print("Moi ban nhap gia Vo: ");
    float gia = Float.parseFloat(sc.nextLine());
    vo.setGia(gia);

    System.out.print("Moi ban nhap so luong cua Vo: ");
    int soluong = Integer.parseInt(sc.nextLine());
    vo.setSoluong(soluong);

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String ngaySx = formatter.format(date);
    vo.setNgaySx(ngaySx);

    System.out.print("Moi ban nhap don vi san xuat Vo: ");
    String donviSx = sc.nextLine();
    vo.setDonviSx(donviSx);

    return vo;
}
    
    public void nhapDSVo(){
        int n;
        System.out.print("Moi ban nhap tong so loai Vo can nhap: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Vo[n];
        for(int i = 0; i < ds.length; i++){
            System.out.println("Moi ban nhap loai Vo thu " + (i + 1));
            ds[i] = createVoFromUserInput();
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

    public SanPham[] docFileDSVo() {
    SanPham[] tempArray = new SanPham[100];  // Adjust the size as needed
    int count = 0;

    try {
        FileReader fr = new FileReader("DSVo.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null && count < tempArray.length) {
            // Parse the line to create a new Vo object
            Vo vo = new Vo();
            String[] parts = line.split(",");
            vo.setIdSanpham(parts[0].trim());
            vo.setName(parts[1].trim());
            vo.setGia(Float.parseFloat(parts[2].trim()));
            vo.setSoluong(Integer.parseInt(parts[3].trim()));
            vo.setNgaySx(parts[4].trim());
            vo.setDonviSx(parts[5].trim());
            tempArray[count] = vo;
            count++;
        }
        br.close();
        fr.close();
    } catch (IOException ex) {
        // Handle exception
    }

    // Create a new array with the exact number of elements
    SanPham[] sanPhamList = new SanPham[count];
    for (int i = 0; i < count; i++) {
        sanPhamList[i] = tempArray[i];
    }

    return sanPhamList;
}
    
    public void xuatDSVo(){
        if (ds == null) {
            System.out.println("Khong co san pham");
        } else {
            for(var x : ds){
                x.xuatSanpham();
                System.out.println();
            }
        }
    }
    
    public void addVo(){
        SanPham a = new Vo();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = (Vo) a;
        try{
            FileWriter fw = new FileWriter("DSVo.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.toString());
            bw.newLine();
        }
        catch(IOException ex){}
    }
    
    public void deleteVo(){
        System.out.println("Moi ban nhap ten Vo can xoa: ");
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
            if((ds[i].getIdSanpham().compareTo(tmp)) == 1){
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
    
    public void timKiemVo(String keyword) {
    for (Vo vo : ds) {
        if (vo.getName().contains(keyword)) {
            vo.xuatSanpham();
        }
    }
}
}
