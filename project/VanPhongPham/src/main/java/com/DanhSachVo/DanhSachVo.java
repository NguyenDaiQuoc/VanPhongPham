package com.DanhSachVo;

import com.SanPham.SanPham;
import com.Vo.Vo;
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

public class DanhSachVo {

    String FileVo = "DSVo.txt";
    String FileTmp = "Tmp.txt";
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

    public void nhapDSVo() {
        int n;
        System.out.print("Moi ban nhap tong so loai Vo can nhap: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Vo[n];
        for (int i = 0; i < ds.length; i++) {
            System.out.println("Moi ban nhap loai Vo thu " + (i + 1));
            ds[i] = createVoFromUserInput();
        }
    }

    public void ghiFileDSVo() {
        try {
            FileWriter fr = new FileWriter("DSVo.txt");
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

    public Vo[] docFileDSVo() {
        Vo[] tempArray = new Vo[100];  // Adjust the size as needed
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
        Vo[] voList = new Vo[count];
        for (int i = 0; i < count; i++) {
            voList[i] = tempArray[i];
        }

        return voList;
    }

    public void printVoProducts() {
        SanPham[] sanPhamList = docFileDSVo();
        System.out.println("Danh sach cac san pham Vo:");
        for (SanPham sanPham : sanPhamList) {
            Vo vo = (Vo) sanPham;
            System.out.println("ID: " + vo.getIdSanpham());
            System.out.println("Ten: " + vo.getName());
            System.out.println("Gia: " + vo.getGia());
            System.out.println("So luong: " + vo.getSoluong());
            System.out.println("Ngay san xuat: " + vo.getNgaySx());
            System.out.println("Don vi san xuat: " + vo.getDonviSx());
            System.out.println("------------------------");
        }
    }

    public void xuatDSVo() {
        if (ds == null) {
            System.out.println("Khong co san pham");
        } else {
            for (var x : ds) {
                x.xuatSanpham();
                System.out.println();
            }
        }
    }

    public void addVo() {
        Vo a = createVoFromUserInput();
        if (ds == null) {
            ds = new Vo[1];
        } else {
            ds = Arrays.copyOf(ds, ds.length + 1);
        }
        ds[ds.length - 1] = a;
        try {
            FileWriter fw = new FileWriter("DSVo.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(a.getIdSanpham() + ", " + a.getName() + ", " + a.getGia() + ", " + a.getSoluong() + ", " + a.getNgaySx() + ", " + a.getDonviSx());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("An error occurred while writing to DSVo.txt.");
            ex.printStackTrace();
        }
    }

    public void deleteVo() {
        System.out.println("Moi ban nhap ten Vo can xoa: ");
        String tmp = sc.nextLine();

        // Read the file into the ds array
        Vo[] ds = docFileDSVo();

        if (ds != null) {  // Check if ds is not null
            int indexToDelete = -1;
            for (int i = 0; i < ds.length; i++) {
                if ((ds[i].getName().equals(tmp)) == true) {
                    indexToDelete = i;
                    break;
                }
            }

            if (indexToDelete != -1) {
                Vo[] newDs = new Vo[ds.length - 1];
                for (int i = 0, j = 0; i < ds.length; i++) {
                    if (i != indexToDelete) {
                        newDs[j++] = ds[i];
                    }
                }
                ds = newDs;
            } else {
                System.out.println("Khong tim thay Vo co ten la " + tmp);
                return;
            }

            try {
                FileWriter fr = new FileWriter("DSVo.txt");
                BufferedWriter bw = new BufferedWriter(fr);
                for (var x : ds) {
                    bw.write(x.getIdSanpham() + ", " + x.getName() + ", " + x.getGia() + ", " + x.getSoluong() + ", " + x.getNgaySx() + ", " + x.getDonviSx());
                    bw.newLine();
                }
                bw.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("An error occurred while writing to DSVo.txt.");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Khong co Vo nao trong danh sach.");
        }
    }

    public void updateSach() {
        System.out.print("Moi ban nhap id Sach can sua: ");
        String tmp = sc.nextLine();
        for (int i = 0; i < ds.length; i++) {
            if ((ds[i].getIdSanpham().compareTo(tmp)) == 1) {
                ds[i].nhapSanpham();
            }
        }
        try {
            FileWriter fr = new FileWriter("DSVo.txt");
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

    public void timKiemVo(String keyword) {
        // Read the data from the file into a local Vo array
        Vo[] voList = this.docFileDSVo();

        // Check if voList is null
        if (voList == null) {
            System.out.println("No data found.");
            return;
        }

        // Now search for the keyword in the voList array
        for (Vo vo : voList) {
            if (vo.getName().contains(keyword)) {
                vo.xuatSanpham();
            }
        }
    }

    public void ThayDoiBut() throws IOException {
        File fileTmp = new File(FileTmp);
        File file = new File(FileVo);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileTmp));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String ID;
        System.out.print("Moi nhap ID sach can thay doi ");
        ID = sc.nextLine();
        String sLine;
        String fiVo[] = new String[10];
        boolean bFound = false;
        while ((sLine = reader.readLine()) != null) {
            fiVo = sLine.split(",");
            if (fiVo[0].equals(ID)) {
                System.out.print("Moi nhap so luong but can thay doi ");
                int sl = sc.nextInt();
                writer.write(ID + "," + fiVo[1] + "," + fiVo[2] + "," + sl + "," + fiVo[4] + "," + fiVo[5] + "\n");
                bFound = true;
            } else {
                writer.write(fiVo[0] + "," + fiVo[1] + "," + fiVo[2] + "," + fiVo[3] + "," + fiVo[4] + "," + fiVo[5] + "\n");
            }
        }
        //}
        writer.close();
        reader.close();
        if (bFound == true) {
            file.delete();
            fileTmp.renameTo(new File(FileVo));
            System.out.println("Da cap nhat so luong Vo ID = " + ID);
        } else {
            fileTmp.delete();
            System.out.println("Khong tim thay Vo mang ID = " + ID);
        }
    }
}
