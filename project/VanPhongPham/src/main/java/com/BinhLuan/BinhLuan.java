
package com.BinhLuan;
import com.SanPham.SanPham;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            File file = new File("Binh Luan.txt");
    
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
}
