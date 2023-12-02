package com.GioHang;

import com.DanhSachBut.DanhSachBut;
import com.DanhSachSach.DanhSachSach;
import com.DanhSachVo.DanhSachVo;
import com.PhuongThucThanhToan.PhuongThucThanhToan;
import com.SanPham.SanPham;
import com.DonHang.DonHang;
import com.KhachHang.KhachHang;
import com.HienThiSanPham.HienThiSanPham;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

public class GioHang {
    private SanPham[] gioHang = new SanPham[100]; // Assuming a maximum of 100 products in the cart
    private int soLuongDonHang;
    private int soLuongSanPhamTrongGio = 0;
    // Define phuongThucThanhToans
    private PhuongThucThanhToan[] phuongThucThanhToans;
    private String maDonHang = generateMaDonHang();

    // Default constructor
    public GioHang() {
        // Initialize phuongThucThanhToans in the constructor
        phuongThucThanhToans = new PhuongThucThanhToan[3];
        phuongThucThanhToans[0] = new PhuongThucThanhToan("1", "The tin dung", "Thanh toán bằng thẻ tín dụng");
        phuongThucThanhToans[1] = new PhuongThucThanhToan("2", "Momo", "Thanh toán bằng ví điện tử Momo");
        phuongThucThanhToans[2] = new PhuongThucThanhToan("3", "COD", "Thanh toán khi nhận hàng (COD)");
    }

    // Copy constructor
    public GioHang(GioHang other) {
        this.gioHang = other.gioHang.clone(); // This creates a new array that is a copy of the original
        this.soLuongDonHang = other.soLuongDonHang;
        this.soLuongSanPhamTrongGio = other.soLuongSanPhamTrongGio;
        this.phuongThucThanhToans = other.phuongThucThanhToans.clone(); // This creates a new array that is a copy of the original
        this.maDonHang = other.maDonHang;
    }

    // Parameterized constructor
    public GioHang(SanPham[] gioHang, int soLuongDonHang, int soLuongSanPhamTrongGio, PhuongThucThanhToan[] phuongThucThanhToans, String maDonHang) {
        this.gioHang = gioHang;
        this.soLuongDonHang = soLuongDonHang;
        this.soLuongSanPhamTrongGio = soLuongSanPhamTrongGio;
        this.phuongThucThanhToans = phuongThucThanhToans;
        this.maDonHang = maDonHang;
    }

    // Getters and Setters
    public SanPham[] getGioHang() {
        return gioHang;
    }

    public void setGioHang(SanPham[] gioHang) {
        this.gioHang = gioHang;
    }

    public int getSoLuongDonHang() {
        return soLuongDonHang;
    }

    public void setSoLuongDonHang(int soLuongDonHang) {
        this.soLuongDonHang = soLuongDonHang;
    }

    public int getSoLuongSanPhamTrongGio() {
        return soLuongSanPhamTrongGio;
    }

    public void setSoLuongSanPhamTrongGio(int soLuongSanPhamTrongGio) {
        this.soLuongSanPhamTrongGio = soLuongSanPhamTrongGio;
    }

    public PhuongThucThanhToan[] getPhuongThucThanhToans() {
        return phuongThucThanhToans;
    }

    public void setPhuongThucThanhToans(PhuongThucThanhToan[] phuongThucThanhToans) {
        this.phuongThucThanhToans = phuongThucThanhToans;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    // Other methods

    public void muaSanPham(SanPham[] sanPhamList, Scanner scanner, DanhSachSach danhSachSach, DanhSachVo danhSachVo, DanhSachBut danhSachBut) {
    boolean displayMenu = true;

    while (true) {
        if (displayMenu) {
            System.out.println("Chon loai san pham de mua:");
            System.out.println("1. Sach");
            System.out.println("2. Vo");
            System.out.println("3. But");
            System.out.println("4. Tim kiem san pham");
            System.out.println("11. Quay lai");
            System.out.print("Nhap lua chon (1, 2, 3, 4 hoac 11): ");
        }

        int productChoice = scanner.nextInt();
        scanner.nextLine();

        if (productChoice >= 1 && productChoice <= 4) {
            switch (productChoice) {
                case 1:
                    danhSachSach.xuatDSSach();
                    break;
                case 2:
                    danhSachVo.xuatDSVo();
                    break;
                case 3:
                    danhSachBut.xuatDSBut();
                    break;
                case 4:
                    System.out.print("Nhap tu khoa tim kiem: ");
                    String keyword = scanner.nextLine();
                    System.out.println("Ket qua tim kiem cho \"" + keyword + "\":");
                    danhSachSach.timKiemSach(keyword);
                    danhSachVo.timKiemVo(keyword);
                    danhSachBut.timKiemBut(keyword);
                    break;
            }

            int startIndex = (productChoice - 1) * 10;
            int endIndex = Math.min(productChoice * 10, sanPhamList.length);

            // Tạo một mảng tạm thời để chứa danh sách sản phẩm
            SanPham[] tempArray = Arrays.copyOfRange(sanPhamList, startIndex, endIndex);

            // User choice for buying the product
            int buyChoice;
            do {
                System.out.print("Nhap lua chon san pham hoac 11 de quay lai: ");
                buyChoice = scanner.nextInt();
                scanner.nextLine();

                if (buyChoice >= 1 && buyChoice <= tempArray.length) {
                    if (soLuongSanPhamTrongGio < 100) { // Check if the cart is not full
                        gioHang[soLuongSanPhamTrongGio] = tempArray[buyChoice - 1];
                        soLuongSanPhamTrongGio++;
                        System.out.println("Da them san pham vao gio hang.");
                    } else {
                        System.out.println("Gio hang da day, khong the them san pham.");
                        break; // Break out of the do-while loop
                    }
                } else if (buyChoice == 11) {
                    displayMenu = true; // Go back to the main menu
                    return;
                } else {
                    System.out.println("Lua chon khong hop le.");
                }
            } while (true); // Continue until the user chooses to go back
        } else if (productChoice == 11) {
            break; // Quay lai trang truoc
        } else {
            System.out.println("Lua chon khong hop le.");
        }

        displayMenu = false;
    }
}


    private String generateMaDonHang() {
        int lastOrderId = 0;
        File file = new File("lastorderid.txt");

        // Create the file if it doesn't exist
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        // Read the last order ID from the file
        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                lastOrderId = scanner.nextInt();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find lastorderid.txt.");
            e.printStackTrace();
        }

        lastOrderId++; // Increment the last order ID

        // Write the new last order ID to the file
        try {
            FileWriter writer = new FileWriter("lastorderid.txt");
            writer.write(String.valueOf(lastOrderId));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to lastorderid.txt.");
            e.printStackTrace();
        }

        return "DH" + lastOrderId; // Return the new order ID
    }

    public void docDonHang(KhachHang khachHang) {
        try {
            File file = new File("donhang.txt");
            Scanner reader = new Scanner(file);

            System.out.println("Cac don hang da dat:");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] orderInfo = data.split(", ");
                // Check if the user ID matches
                if (orderInfo[0].equals(khachHang.getMaNguoiDung())) {
                    // Display the order information
                    System.out.println("Ma Don Hang: " + orderInfo[1]);
                    System.out.println("Khach Hang: " + orderInfo[2]);
                    System.out.println("Ngay Dat Hang: " + orderInfo[3]);
                    System.out.println("Trang Thai Don Hang: " + orderInfo[4]);
                    System.out.println("Tong So Tien: " + orderInfo[5] + " VND");
                    System.out.println("Phuong Thuc Thanh Toan: " + orderInfo[6]);

                    // Display the product information
                    for (int i = 7; i < orderInfo.length; i++) {
                        System.out.println("San Pham: " + orderInfo[i]);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep don hang.");
            e.printStackTrace();
        }
    }

    DonHang[] donHangArray = new DonHang[100000];

    public void datDonHang(Scanner scanner, KhachHang khachHang) { 
        // Calculate the total amount
    double tongSoTien = 0;
    SanPham[] sanPhamTrongGio = getGioHang();
    for (int i = 0; i < getSoLuongSanPhamTrongGio(); i++) {
        tongSoTien += sanPhamTrongGio[i].getFinalPrice();
    }

    // Print the total amount
        System.out.println("Tong so tien phai tra sau khi tinh thue va chiet khau la: " + tongSoTien);
        System.out.println("Chon phuong thuc thanh toan:");
        for (PhuongThucThanhToan pttt : phuongThucThanhToans) {
            System.out.println(pttt.getMaPhuongThuc() + ". " + pttt.getTen());
        }
        System.out.print("Nhap lua chon (1, 2 hoac 3): ");
        int luaChon = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        PhuongThucThanhToan phuongThucThanhToan = phuongThucThanhToans[luaChon - 1]; // Get the chosen payment method
        DonHang donHang = new DonHang(maDonHang, khachHang, this, phuongThucThanhToan);
        switch (luaChon) {
            case 1:
                System.out.print("Nhap so the ");
                String soThe = scanner.nextLine();
                System.out.print("Nhap ma CVV ");
                String maCVV = scanner.nextLine();
                System.out.print("Nhap ngay het han (mm/yy): ");
                String ngayHetHan = scanner.nextLine();
                
                System.out.println("Da thanh toan thanh cong bang the tin dung!");
                donHang.luuDonHang(); 
                break;
            case 2:
                System.out.println("Hay chuyen tien cho tai khoan nay: 0931816175, Ten: Dinh Phuc Thinh");
                donHang.luuDonHang(); 
                break;
            case 3:
                System.out.println("Dat hang thanh cong! San pham se duoc thanh toan khi nhan hang");
                donHang.luuDonHang(); 
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }
    }

    public void xemGioHang() {
    System.out.println("Danh sach san pham trong gio hang:");
    for (int i = 0; i < soLuongSanPhamTrongGio; i++) {
        if (gioHang[i] != null) {  // Check if the SanPham object is not null
            System.out.println((i + 1) + ". " + gioHang[i].getName() +                          
                               " - Gia: " + gioHang[i].getGia() + "VND" +
                               " - So luong: " + gioHang[i].getSoluong() +
                               " - Ngay san xuat: " + gioHang[i].getNgaySx() +
                               " - Don vi san xuat: " + gioHang[i].getDonviSx());
            }
        }
    }
}
