package com.cskh;

public class Cskh {

    private String sTen, sEmail, sSoDienThoai, sLinkMangXaHoi;

    Cskh(String sTen, String sEmail, String sSoDienThoai, String sLinkMangXaHoi) {
        this.sTen = sTen;
        this.sEmail = sEmail;
        this.sSoDienThoai = sSoDienThoai;
        this.sLinkMangXaHoi = sLinkMangXaHoi;
    }

    public static void display() {
        Cskh dsnv[] = new Cskh[]{
            new Cskh("Nguyen Dai Quoc\t", "luutrithon1996@gmail.com", "0931454176", "fb.com/wolfdzai\t"),
            new Cskh("Dinh Phuc Thinh\t", "zaikaman123@gmail.com\t", "0931816175", "fb.com/dinfucthin"),
            new Cskh("Tran Trung Viet\t", "", "", "cutt.ly/qwTNnwZY"),
            new Cskh("Tran Dang Phat\t", "", "", "cutt.ly/TwTNb3Ur"),
            new Cskh("Nguyen Hoang Sang", "lesang01227982715@gmail.com", "0776592967", "cutt.ly/4wTNbGKf")
        };
        System.out.println("Ban co the lien he voi cac thanh vien sau de duoc giai quyet voi toc do phan hoi tot nhat");
        System.out.println("Ten\t\t\t\t\tFacebook\t\t\tGmail\t\t\t\t\tSdt");
        for (int i = 0; i < dsnv.length; i++) {
            System.out.println(dsnv[i].sTen + "\t\t\t" + dsnv[i].sLinkMangXaHoi + "\t\t" + dsnv[i].sEmail + "\t\t" + dsnv[i].sSoDienThoai);
        }

    }
}
