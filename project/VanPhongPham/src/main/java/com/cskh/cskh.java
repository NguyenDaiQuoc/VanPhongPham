package com.cskh;
public class cskh{
    private String Ten, Email, SoDienThoai, LinkMangXaHoi;
    cskh (String Ten, String Email, String SoDienThoai, String LinkMangXaHoi){
        this.Ten = Ten;
        this.Email = Email;
        this.SoDienThoai = SoDienThoai;
        this.LinkMangXaHoi = LinkMangXaHoi;
    }
    public static void display(){
        cskh dsnv[] = new cskh[]{
            new cskh("Nguyen Dai Quoc","luutrithon1996@gmail.com","0931454176","fb.com/wolfdzai"),
            new cskh("Dinh Phuc Thinh","zaikaman123@gmail.com","0931816175", "fb.com/dinfucthin"),
            new cskh("Tran Trung Viet","" , "", "cutt.ly/qwTNnwZY"),
            new cskh("Tran Dang Phat", "", "", "cutt.ly/TwTNb3Ur"),
            new cskh("Nguyen Hoang Sang", "lesang01227982715@gmail.com", "0776592967", "cutt.ly/4wTNbGKf")
        };
        System.out.println("Ban co the lien he voi cac thanh vien sau de duoc giai quyet voi toc do phan hoi tot nhat");
        System.out.println("Ten\t\t\tFacebook\t\tGmail\t\t\t\tSdt");
        for(int i = 0; i < dsnv.length; i++){
            System.out.println(dsnv[i].Ten + "\t\t" + dsnv[i].LinkMangXaHoi + "\t\t" + dsnv[i].Email + "\t\t" + dsnv[i].SoDienThoai);
        }
        
    }
}