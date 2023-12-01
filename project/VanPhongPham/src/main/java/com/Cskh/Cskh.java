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
    private Cskh(){
    }
    
    private Cskh(Cskh a){
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
