package com.DanhSachSach;

import com.Sach.Sach;
import com.SanPham.SanPham;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DanhSachSach {

    String FileSach = "DSSach.txt";
    String FileTmp = "Tmp.txt";

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

    public Sach[] docFileDSSach() {
        Sach[] tempArray = new Sach[100];  // Adjust the size as needed
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
        Sach[] sachList = new Sach[count];
        for (int i = 0; i < count; i++) {
            sachList[i] = tempArray[i];
        }

        return sachList;
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
        Sach a = createSachFromUserInput();
        if (ds == null) {
            ds = new Sach[1];
        } else {
            ds = Arrays.copyOf(ds, ds.length + 1);
        }
        ds[ds.length - 1] = a;
        try {
            FileWriter fw = new FileWriter("DSSach.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.getIdSanpham() + ", " + a.getName() + ", " + a.getGia() + ", " + a.getSoluong() + ", " + a.getNgaySx() + ", " + a.getDonviSx());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("An error occurred while writing to DSSach.txt.");
            ex.printStackTrace();
        }
    }

    public void deleteSach() {
        System.out.println("Moi ban nhap ten Sach can xoa: ");
        String tmp = sc.nextLine();

        // Read the file into the ds array
        Sach[] ds = docFileDSSach();

        if (ds != null) {  // Check if ds is not null
            int indexToDelete = -1;
            for (int i = 0; i < ds.length; i++) {
                if ((ds[i].getName().equals(tmp)) == true) {
                    indexToDelete = i;
                    break;
                }
            }

            if (indexToDelete != -1) {
                Sach[] newDs = new Sach[ds.length - 1];
                for (int i = 0, j = 0; i < ds.length; i++) {
                    if (i != indexToDelete) {
                        newDs[j++] = ds[i];
                    }
                }
                ds = newDs;
            } else {
                System.out.println("Khong tim thay Sach co ten la " + tmp);
                return;
            }

            try {
                FileWriter fr = new FileWriter("DSSach.txt");
                BufferedWriter bw = new BufferedWriter(fr);
                for (var x : ds) {
                    bw.write(x.getIdSanpham() + ", " + x.getName() + ", " + x.getGia() + ", " + x.getSoluong() + ", " + x.getNgaySx() + ", " + x.getDonviSx());
                    bw.newLine();
                }
                bw.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("An error occurred while writing to DSSach.txt.");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Khong co Sach nao trong danh sach.");
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
        // Read the data from the file into a local Sach array
        Sach[] sachList = this.docFileDSSach();

        // Check if sachList is null
        if (sachList == null) {
            System.out.println("No data found.");
            return;
        }

        // Now search for the keyword in the sachList array
        for (Sach sach : sachList) {
            if (sach.getName().contains(keyword)) {
                sach.xuatSanpham();
            }
        }
    }

    public void ThayDoiSach() throws IOException {
        File fileTmp = new File(FileTmp);
        File file = new File(FileSach);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileTmp));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String ID;
        System.out.print("Moi nhap ID sach can thay doi ");
        ID = sc.nextLine();
        String sLine;
        String fiSach[] = new String[10];
        boolean bFound = false;
        while ((sLine = reader.readLine()) != null) {
            fiSach = sLine.split(",");
            if (fiSach[0].equals(ID)) {
                System.out.print("Moi nhap so luong sach can thay doi ");
                int sl = sc.nextInt();
                writer.write(ID + "," + fiSach[1] + "," + fiSach[2] + "," + sl + "," + fiSach[4] + "," + fiSach[5] + "," + fiSach[6] + "\n");
                bFound = true;
            } else {
                writer.write(fiSach[0] + "," + fiSach[1] + "," + fiSach[2] + "," + fiSach[3] + "," + fiSach[4] + "," + fiSach[5] + "," + fiSach[6] + "\n");
            }
        }
        //}
        writer.close();
        reader.close();
        if (bFound == true) {
            file.delete();
            fileTmp.renameTo(new File(FileSach));
            System.out.println("Da cap nhat so luong Sach ID = " + ID);
        } else {
            fileTmp.delete();
            System.out.println("Khong tim thay Sach mang ID = " + ID);
        }
    }
}
