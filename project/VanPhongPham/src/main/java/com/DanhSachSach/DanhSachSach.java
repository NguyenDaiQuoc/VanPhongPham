package com.DanhSachSach;

import com.Sach.Sach;
import com.SanPham.SanPham;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DanhSachSach {

    private Sach[] ds;

    Scanner sc = new Scanner(System.in);

    public DanhSachSach() {
    }

    public DanhSachSach(SanPham[] ds) {
        this.ds = (Sach[]) ds;
    }

    public SanPham[] getDs() {
        return ds;
    }

    public void setDs(SanPham[] ds) {
        this.ds = (Sach[]) ds;
    }

    public Sach createSachFromUserInput() {
        Scanner sc = new Scanner(System.in);
        Sach sach = new Sach();

        System.out.print("Moi ban nhap id Sach: ");
        String idSanpham = sc.nextLine();
        sach.setIdSanpham(idSanpham);

        System.out.print("Moi ban nhap ten Sach: ");
        String name = sc.nextLine();
        sach.setName(name);

        System.out.print("Moi ban nhap gia Sach: ");
        float gia = Float.parseFloat(sc.nextLine());
        sach.setGia(gia);

        System.out.print("Moi ban nhap so luong cua Sach: ");
        int soluong = Integer.parseInt(sc.nextLine());
        sach.setSoluong(soluong);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngaySx = formatter.format(date);
        sach.setNgaySx(ngaySx);

        System.out.print("Moi ban nhap don vi san xuat Sach: ");
        String donviSx = sc.nextLine();
        sach.setDonviSx(donviSx);

        return sach;
    }

    public void nhapDSSach() {
        int n;
        System.out.print("Moi ban nhap tong so loai Sach can nhap: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Sach[n];
        for (int i = 0; i < ds.length; i++) {
            System.out.println("Moi ban nhap loai Sach thu " + (i + 1));
            ds[i] = createSachFromUserInput();
        }
    }

    public void ghiFileDSSach() {
        try {
            FileWriter fr = new FileWriter("DSSach.txt");
            BufferedWriter bw = new BufferedWriter(fr);
            for (var x : ds) {
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fr.close();
        } catch (IOException ex) {
        }
    }

    public SanPham[] docFileDSSach() {
        SanPham[] tempArray = new SanPham[100];  // Adjust the size as needed
        int count = 0;

        try {
            FileReader fr = new FileReader("DSSach.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null && count < tempArray.length) {
                // Parse the line to create a new Sach object
                Sach sach = new Sach();
                String[] parts = line.split(",");
                sach.setIdSanpham(parts[0].trim());
                sach.setName(parts[1].trim());
                sach.setGia(Float.parseFloat(parts[2].trim()));
                sach.setSoluong(Integer.parseInt(parts[3].trim()));
                sach.setNgaySx(parts[4].trim());
                sach.setDonviSx(parts[5].trim());
                tempArray[count] = sach;
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

    public void printSachProducts() {
        SanPham[] sanPhamList = docFileDSSach();
        System.out.println("Danh sach cac san pham Sach:");
        for (SanPham sanPham : sanPhamList) {
            Sach sach = (Sach) sanPham;
            System.out.println("ID: " + sach.getIdSanpham());
            System.out.println("Ten: " + sach.getName());
            System.out.println("Gia: " + sach.getGia());
            System.out.println("So luong: " + sach.getSoluong());
            System.out.println("Ngay san xuat: " + sach.getNgaySx());
            System.out.println("Don vi san xuat: " + sach.getDonviSx());
            System.out.println("------------------------");
        }
    }

    public void xuatDSSach() {
        if (ds == null) {
            System.out.println("Khong co san pham");
        } else {
            for (var x : ds) {
                x.xuatSanpham();
                System.out.println();
            }
        }
    }

    public void addSach() {
        SanPham a = new Sach();
        a.nhapSanpham();
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = (Sach) a;
        try {
            FileWriter fw = new FileWriter("DSSach.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.toString());
            bw.newLine();
        } catch (IOException ex) {
        }
    }

    public void deleteSach() {
        System.out.println("Moi ban nhap ten Sach can xoa: ");
        String tmp = sc.nextLine();
        for (int i = 0; i < ds.length; i++) {
            if ((ds[i].getName().equals(tmp)) == true) {
                if (i == ds.length - 1) {
                    ds = Arrays.copyOf(ds, ds.length - 1);
                } else {
                    for (int j = i; j < ds.length - 1; j++) {
                        ds[j] = ds[j + 1];
                        ds = Arrays.copyOf(ds, ds.length - 1);
                    }
                }
            }
        }
        try {
            FileWriter fr = new FileWriter("DSSach.txt");
            BufferedWriter bw = new BufferedWriter(fr);
            for (var x : ds) {
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fr.close();
        } catch (IOException ex) {
        }
    }

    public void updateSach() {
        System.out.print("Moi ban nhap id sach can sua: ");
        String tmp = sc.nextLine();
        for (int i = 0; i < ds.length; i++) {
            if ((ds[i].getIdSanpham().equals(tmp)) == true) {
                ds[i].nhapSanpham();
            }
        }
        try {
            FileWriter fr = new FileWriter("DSSach.txt");
            BufferedWriter bw = new BufferedWriter(fr);
            for (var x : ds) {
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fr.close();
        } catch (IOException ex) {
        }

    }

    public void timKiemSach(String keyword) {
        for (Sach sach : ds) {
            if (sach.getName().contains(keyword)) {
                sach.xuatSanpham();
            }
        }
    }
}
