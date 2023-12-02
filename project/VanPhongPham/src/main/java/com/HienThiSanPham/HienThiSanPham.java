package com.HienThiSanPham;
import com.But.But;
import com.Sach.Sach;
import com.SanPham.SanPham;
import com.Vo.Vo;

public class HienThiSanPham {
    public static void hienThiSanPham(SanPham[] sanPhamList, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            // Kiểm tra xem phần tử có giá trị null không
            if (sanPhamList[i] != null) {
                // Hiển thị thông tin chung của sản phẩm
                System.out.print((i - startIndex + 1) + ". " + sanPhamList[i].getName() + " - " + sanPhamList[i].getGia() + "VND");

                // Kiểm tra loại sản phẩm và hiển thị thông tin cụ thể
                if (sanPhamList[i] instanceof Sach) {
                    Sach sach = (Sach) sanPhamList[i];
                    System.out.println(" - Tac gia: " + sach.getTacgia());
                } else if (sanPhamList[i] instanceof Vo) {
                    Vo vo = (Vo) sanPhamList[i];
                    System.out.println(" - Kich thuoc: " + vo.getKichthuoc());
                } else if (sanPhamList[i] instanceof But) {
                    But but = (But) sanPhamList[i];
                    System.out.println(" - Loai: " + but.getLoai());
                } else {
                    System.out.println(" - (Thong tin khong xac dinh)");
                }
            } else {
                System.out.println((i - startIndex + 1) + ". (San pham khong ton tai)");
            }
        }

        System.out.println((endIndex - startIndex + 2) + ". Quay lai");
    }
}

