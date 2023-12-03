
package com.DanhSachSanPham;

import com.DanhSachBut.DanhSachBut;
import com.DanhSachSach.DanhSachSach;
import com.DanhSachVo.DanhSachVo;
import java.util.Scanner;

public class DanhSachSanPham {
    private DanhSachBut dsBut;
    private DanhSachSach dsSach;
    private DanhSachVo dsVo;
    
    Scanner sc = new Scanner(System.in);

    public void menu(){
        System.out.println("0.Thoat");
        System.out.println("1.Nhap Danh Sach San Pham");
        System.out.println("2.Xuat Danh Sach San Pham");
        System.out.println("3.Them San Pham");
        System.out.println("4.Xoa San Pham");
        System.out.println("5.Sua San Pham");
    }
    
    public void menu1(){
        System.out.println("0.Thoat");
        System.out.println("1.But");
        System.out.println("2.Sach");
        System.out.print("3.Vo");
    }
    
    public void timKiemSanPham(String keyword) {
    System.out.println("Ket qua tim kiem cho \"" + keyword + "\":");
    
    System.out.println("\nBut:");
    dsBut.timKiemBut(keyword);
    
    System.out.println("\nSach:");
    dsSach.timKiemSach(keyword);
    
    System.out.println("\nVo:");
    dsVo.timKiemVo(keyword);
}

    public void thucHien(){
        dsBut = new DanhSachBut();
        dsSach = new DanhSachSach();
        dsVo = new DanhSachVo();
        while(true){
            menu();
            int choose;
            System.out.print("Moi ban nhap lua chon: ");
            choose = Integer.parseInt(sc.nextLine());
            if(choose == 0){
                break;
            }
            switch(choose){
                case 1: 
                    while(true){
                        menu1();
                        System.out.println();
                        int choose1;
                        System.out.print("Moi ban nhap lua chon: ");
                        choose1 = Integer.parseInt(sc.nextLine());
                        if(choose1 == 0) break;
                        switch(choose1){
                            case 1:
                                dsBut.nhapDSBut(); 
                                dsBut.ghiFileDSBut();
                                break;
                            case 2:
                                dsSach.nhapDSSach();
                                dsSach.ghiFileDSSach();
                                break;
                            case 3:
                                dsVo.nhapDSVo();
                                dsVo.ghiFileDSVo();
                                break;
                        }
                    }
                    break;
                case 2:
                    while(true){
                        menu1();
                        int choose2;
                        System.out.println();
                        System.out.print("Moi ban nhap lua chon: ");
                        choose2 = Integer.parseInt(sc.nextLine());
                        if(choose2 == 0) break;
                        switch(choose2){
                            case 1:
                                dsBut.docFileDSBut(); break;
                            case 2:
                                dsSach.docFileDSSach(); break;
                            case 3:
                                dsVo.docFileDSVo(); break;
                                
                        }
                    }
                    break;
                case 3:
                    while(true){
                        menu1();
                        int choose3;
                        System.out.println();
                        System.out.print("Moi ban nhap lua chon: ");
                        choose3 = Integer.parseInt(sc.nextLine());
                        if(choose3 == 0) break;
                        switch(choose3){
                            case 1:
                                dsBut.addBut(); break;
                            case 2:
                                dsSach.addSach(); break;
                            case 3:
                                dsVo.addVo(); break;
                        }
                    }
                    break;
                case 4:
                    while(true){
                        menu1();
                        int choose4;
                        System.out.println();
                        System.out.print("Moi ban nhap lua chon: ");
                        choose4 = Integer.parseInt(sc.nextLine());
                        if(choose4 == 0) break;
                        switch(choose4){
                            case 1:
                                dsBut.deleteBut(); break;
                            case 2:
                                dsSach.deleteSach(); break;
                            case 3:
                                dsVo.deleteVo(); break;
                        }
                    }
                    break;
                case 5:
                    while(true){
                        menu1();
                        int choose5;
                        System.out.println();
                        System.out.print("Moi ban nhap lua chon: ");
                        choose5 = Integer.parseInt(sc.nextLine());
                        if(choose5 == 0) break;
                        switch(choose5){
                            case 1:
                                dsBut.updateBut(); break;
                            case 2:
                                dsSach.updateSach(); break;
                            case 3:
                                dsVo.updateSach(); break;
                        }
                    }
                    break;
            }
        }
    }
}
