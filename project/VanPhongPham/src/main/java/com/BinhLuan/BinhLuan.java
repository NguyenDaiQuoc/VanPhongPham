
package com.BinhLuan;
import com.SanPham.SanPham;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinhLuan {
    private String maBinhLuan;
    private String noiDung;
    private Date ngayDang;
    private SanPham sanPham;

    // Default constructor
    public BinhLuan() {
    }

    // Constructor with all fields
    public BinhLuan(String maBinhLuan, String noiDung, Date ngayDang, SanPham sanPham) {
        this.maBinhLuan = maBinhLuan;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.sanPham = sanPham;
    }

    // Copy constructor
    public BinhLuan(BinhLuan other) {
        this.maBinhLuan = other.maBinhLuan;
        this.noiDung = other.noiDung;
        this.ngayDang = other.ngayDang;
        this.sanPham = other.sanPham;  // This assumes that SanPham is immutable or that it's okay to share references
    }

    // Existing constructor
    public BinhLuan(String maBinhLuan, String noiDung, SanPham sanPham) {
        this(maBinhLuan, noiDung, new Date(), sanPham);
    }

    // Getter and Setter methods for maBinhLuan
    public String getMaBinhLuan() {
        return maBinhLuan;
    }

    public void setMaBinhLuan(String maBinhLuan) {
        this.maBinhLuan = maBinhLuan;
    }

    // Getter and Setter methods for noiDung
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    // Getter and Setter methods for ngayDang
    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    // Getter and Setter methods for sanPham
    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void luuBinhLuan() {
        try {
            File file = new File("binhluan.txt");
    
            // Create the file if it doesn't exist
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }
    
            FileWriter writer = new FileWriter(file, true);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            String strDate = formatter.format(ngayDang);  
            writer.write(maBinhLuan + ", " + noiDung + ", " + strDate + ", " + sanPham.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi luu binh luan.");
            e.printStackTrace();
        }
    }

    public void xemBinhLuan(SanPham chosenProduct) {
    try {
        File file = new File("binhluan.txt");
        Scanner reader = new Scanner(file);

        System.out.println("Binh luan cho san pham: " + chosenProduct.getName());
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] commentInfo = data.split(", ");
            // Check if the product name matches
            if (commentInfo[3].equals(chosenProduct.getName())) {
                // Display the comment information
                System.out.println("Ma Binh Luan: " + commentInfo[0]);
                System.out.println("Noi Dung: " + commentInfo[1]);
                System.out.println("Ngay Dang: " + commentInfo[2]);
            }
        }
        reader.close();
    } catch (FileNotFoundException e) {
        System.out.println("Khong tim thay tep binh luan.");
        e.printStackTrace();
    }
}
}
