package com.Cskh;

public class Cskh {

    private String sTen, sEmail, sSoDienThoai, sLinkMangXaHoi;

    //constructor
    private Cskh(String sTen, String sEmail, String sSoDienThoai, String sLinkMangXaHoi) {
        this.sTen = sTen;
        this.sEmail = sEmail;
        this.sSoDienThoai = sSoDienThoai;
        this.sLinkMangXaHoi = sLinkMangXaHoi;
    }

    private Cskh() {
    }

    private Cskh(Cskh a) {
        this.sTen = a.sTen;
        this.sEmail = a.sEmail;
        this.sSoDienThoai = a.sSoDienThoai;
        this.sLinkMangXaHoi = a.sLinkMangXaHoi;
    }

    //getter & setter
    public String getsTen() {
        return sTen;
    }

    public void setsTen(String sTen) {
        this.sTen = sTen;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsSoDienThoai() {
        return sSoDienThoai;
    }

    public void setsSoDienThoai(String sSoDienThoai) {
        this.sSoDienThoai = sSoDienThoai;
    }

    public String getsLinkMangXaHoi() {
        return sLinkMangXaHoi;
    }

    public void setsLinkMangXaHoi(String sLinkMangXaHoi) {
        this.sLinkMangXaHoi = sLinkMangXaHoi;
    }

    //method
    public static void display() {
        Cskh dsnv[] = new Cskh[]{
            new Cskh("Nguyen Dai Quoc", "luutrithon1996@gmail.com", "0931454176", "https://wwww.facebook.com/wolfdzai"),
            new Cskh("Dinh Phuc Thinh", "zaikaman123@gmail.com", "0931816175", "https://wwww.facebook.com/dinfucthin"),
            new Cskh("Tran Trung Viet", "tr.trungviet04@gmail.com", "0937024425", "https://wwww.facebook.com/profile.php?id=100019759148684"),
            new Cskh("Tran Dang Phat", "phattran280704@gmail.com", "0779792132", "https://www.facebook.com/profile.php?id=100022698711713"),
            new Cskh("Nguyen Hoang Sang", "lesang01227982715@gmail.com", "0776592967", "https://www.facebook.com/profile.php?id=100041332085485")
        };
        System.out.println("Ban co the lien he voi cac thanh vien sau de duoc giai quyet voi toc do phan hoi tot nhat");
        System.out.printf("%-25s%-70s%-40s%-12s\n","Ten","Facebook","Gmail","Sdt");
        for (int i = 0; i < dsnv.length; i++) {
            System.out.printf("%-25s%-70s%-40s%-12s\n",dsnv[i].sTen, dsnv[i].sLinkMangXaHoi, dsnv[i].sEmail, dsnv[i].sSoDienThoai);
        }

    }
}
