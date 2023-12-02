package com.DonHang;

import com.KhachHang.KhachHang;
import com.GioHang.GioHang;
import com.PhuongThucThanhToan.PhuongThucThanhToan;
import com.SanPham.SanPham;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DonHang {
    private String maDonHang;
    private KhachHang khachHang;
    private GioHang gioHang;
    private Date ngayDatHang;
    private String trangThaiDonHang;
    private PhuongThucThanhToan phuongThucThanhToan;

    // Default constructor
    public DonHang() {
        this.trangThaiDonHang = "Chua xu ly";
        this.ngayDatHang = new Date();
    }

    // Parameterized constructor
    public DonHang(String maDonHang, KhachHang khachHang, GioHang gioHang, PhuongThucThanhToan phuongThucThanhToan) {
        this.maDonHang = maDonHang;
        this.khachHang = khachHang;
        this.gioHang = gioHang;
        this.ngayDatHang = new Date();
        this.trangThaiDonHang = "Chua xu ly"; // Mặc định là chưa xử lý
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    // Copy constructor
    public DonHang(DonHang other) {
        this.maDonHang = other.maDonHang;
        this.khachHang = new KhachHang(other.khachHang); // Create a new KhachHang instance to avoid sharing references
        this.gioHang = new GioHang(other.gioHang); // Create a new GioHang instance to avoid sharing references
        this.ngayDatHang = other.ngayDatHang;
        this.trangThaiDonHang = other.trangThaiDonHang;
        this.phuongThucThanhToan = other.phuongThucThanhToan; // This assumes that PhuongThucThanhToan is immutable or that it's okay to share references
    }

    // Constructor with only maDonHang
    public DonHang(String maDonHang) {
        this.maDonHang = maDonHang;
        this.trangThaiDonHang = "Chua xu ly";
        this.ngayDatHang = new Date();
    }

    public void luuDonHang() {
        try {
            FileWriter writer = new FileWriter("donhang.txt", true);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strDate = formatter.format(ngayDatHang);
            writer.write(
                    khachHang.getMaNguoiDung() + ", " + maDonHang + ", " + khachHang.getHoTen() + ", " + strDate + ", "
                            + trangThaiDonHang);

            // Calculate the total amount
            int tongSoTien = 0;
            SanPham[] sanPhamTrongGio = gioHang.getGioHang();
            for (int i = 0; i < gioHang.getSoLuongSanPhamTrongGio(); i++) {
                tongSoTien += sanPhamTrongGio[i].getGia();
            }

            // Write the total amount and the payment method to the file
            writer.write(", " + tongSoTien + ", " + phuongThucThanhToan.getTen());

            // Write the product information to the file
            for (int i = 0; i < gioHang.getSoLuongSanPhamTrongGio(); i++) {
                writer.write(", " + sanPhamTrongGio[i].getName());
            }

            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi luu don hang.");
            e.printStackTrace();
        }
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public String getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(String trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public PhuongThucThanhToan getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
}
