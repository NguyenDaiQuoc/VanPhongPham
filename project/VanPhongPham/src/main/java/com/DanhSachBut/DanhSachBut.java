package com.DanhSachBut;

import com.But.But;
import com.SanPham.SanPham;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

public class DanhSachBut {

    private But[] ds;

    Scanner sc = new Scanner(System.in);

    public DanhSachBut() {
    }

    public DanhSachBut(SanPham[] ds) {
        this.ds = (But[]) ds;
    }

    public But createButFromUserInput() {
        Scanner sc = new Scanner(System.in);
        But but = new But();

        System.out.print("Moi ban nhap id But: ");
        String idSanpham = sc.nextLine();
        but.setIdSanpham(idSanpham);

        System.out.print("Moi ban nhap ten But: ");
        String name = sc.nextLine();
        but.setName(name);

        System.out.print("Moi ban nhap gia But: ");
        float gia = Float.parseFloat(sc.nextLine());
        but.setGia(gia);

        System.out.print("Moi ban nhap so luong cua But: ");
        int soluong = Integer.parseInt(sc.nextLine());
        but.setSoluong(soluong);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngaySx = formatter.format(date);
        but.setNgaySx(ngaySx);

        System.out.print("Moi ban nhap don vi san xuat But: ");
        String donviSx = sc.nextLine();
        but.setDonviSx(donviSx);

        System.out.print("Moi ban nhap loai But: ");
        String loai = sc.nextLine();
        but.setLoai(loai);

        return but;
    }

    public void nhapDSBut() {
        int n;
        System.out.print("Moi ban nhap tong so loai but can nhap: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new But[n];
        for (int i = 0; i < ds.length; i++) {
            System.out.println("Moi ban nhap loai but thu " + (i + 1));
            ds[i] = createButFromUserInput();
        }
    }

    public void ghiFileDSBut() {
        try {
            FileWriter fr = new FileWriter("DSBut.txt");
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

    public But[] docFileDSBut() {
        But[] tempArray = new But[100];  // Adjust the size as needed
        int count = 0;

        try {
            FileReader fr = new FileReader("DSBut.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null && count < tempArray.length) {
                // Parse the line to create a new But object
                But but = new But();
                String[] parts = line.split(",");
                but.setIdSanpham(parts[0].trim());
                but.setName(parts[1].trim());
                but.setGia(Float.parseFloat(parts[2].trim()));
                but.setSoluong(Integer.parseInt(parts[3].trim()));
                but.setNgaySx(parts[4].trim());
                but.setDonviSx(parts[5].trim());
                but.setLoai(parts[6].trim());
                tempArray[count] = but;
                count++;
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            // Handle exception
        }

        // Create a new array with the exact number of elements
        But[] butList = new But[count];
        for (int i = 0; i < count; i++) {
            butList[i] = tempArray[i];
        }

        return butList;
    }

    public void printButProducts() {
        SanPham[] sanPhamList = docFileDSBut();
        System.out.println("Danh sach cac san pham But:");
        for (SanPham sanPham : sanPhamList) {
            But but = (But) sanPham;
            System.out.println("ID: " + but.getIdSanpham());
            System.out.println("Ten: " + but.getName());
            System.out.println("Gia: " + but.getGia());
            System.out.println("So luong: " + but.getSoluong());
            System.out.println("Ngay san xuat: " + but.getNgaySx());
            System.out.println("Don vi san xuat: " + but.getDonviSx());
            System.out.println("Loai: " + but.getLoai());
            System.out.println("------------------------");
        }
    }

    public void xuatDSBut() {
        if (ds == null) {
            System.out.println("Khong co san pham");
        } else {
            for (var x : ds) {
                x.xuatSanpham();
                System.out.println();
            }
        }
    }

    public void addBut() {
        But a = createButFromUserInput();
        if (ds == null) {
            ds = new But[1];
        } else {
            ds = Arrays.copyOf(ds, ds.length + 1);
        }
        ds[ds.length - 1] = a;
        try {
            FileWriter fw = new FileWriter("DSBut.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.getIdSanpham() + ", " + a.getName() + ", " + a.getGia() + ", " + a.getSoluong() + ", " + a.getNgaySx() + ", " + a.getDonviSx() + ", " + a.getLoai());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("An error occurred while writing to DSBut.txt.");
            ex.printStackTrace();
        }
    }

    public void deleteBut() {
        System.out.println("Moi ban nhap ten But can xoa: ");
        String tmp = sc.nextLine();

        // Read the file into the ds array
        But[] ds = docFileDSBut();

        if (ds != null) {  // Check if ds is not null
            int indexToDelete = -1;
            for (int i = 0; i < ds.length; i++) {
                if ((ds[i].getName().equals(tmp)) == true) {
                    indexToDelete = i;
                    break;
                }
            }

            if (indexToDelete != -1) {
                But[] newDs = new But[ds.length - 1];
                for (int i = 0, j = 0; i < ds.length; i++) {
                    if (i != indexToDelete) {
                        newDs[j++] = ds[i];
                    }
                }
                ds = newDs;
            } else {
                System.out.println("Khong tim thay But co ten la " + tmp);
                return;
            }

            try {
                FileWriter fr = new FileWriter("DSBut.txt");
                BufferedWriter bw = new BufferedWriter(fr);
                for (var x : ds) {
                    bw.write(x.getIdSanpham() + ", " + x.getName() + ", " + x.getGia() + ", " + x.getSoluong() + ", " + x.getNgaySx() + ", " + x.getDonviSx() + ", " + x.getLoai());
                    bw.newLine();
                }
                bw.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("An error occurred while writing to DSBut.txt.");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Khong co But nao trong danh sach.");
        }
    }

    public void updateBut() {
        System.out.print("Moi ban nhap id But can sua: ");
        String tmp = sc.nextLine();
        for (int i = 0; i < ds.length; i++) {
            if ((ds[i].getIdSanpham().equals(tmp)) == true) {
                ds[i].nhapSanpham();
            }
        }
        try {
            FileWriter fr = new FileWriter("DSBut.txt");
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
