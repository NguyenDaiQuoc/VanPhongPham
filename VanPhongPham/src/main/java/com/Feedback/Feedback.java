package com.Feedback;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class Feedback{
    Scanner sc= new Scanner(System.in);
    int iRating;
    String sFeedBack;
    public Feedback(){};
    public Feedback(int Rt,String Fb){
        this.iRating=Rt;
        this.sFeedBack=Fb;
    }
    public Feedback(Feedback fb){
        this.iRating=fb.iRating;
        this.sFeedBack=fb.sFeedBack;
    }

    public int getRating() {
        return iRating;
    }

    public void setRating(int iRating) {
        for(;;){
            System.out.print("Nhap danh gia cua ban tren thang diem 5: ");
            iRating = sc.nextInt();
            if(iRating >= 1 && iRating <= 5) break;
        }
        this.iRating = iRating;
    }

    public String getFeedBack() {
        return sFeedBack;
    }

    public void setFeedBack(String sFeedBack) {
           for(;;){
            System.out.print("Nhap loi danh gia cua ban(khong duoc duoi 3 ki tu): ");
            sFeedBack = sc.nextLine();
            if(sFeedBack.length()>=3) break;
        }
        this.sFeedBack=sFeedBack;
    }

    public void AddFeedback()throws IOException{
        String Fb = "Feedback.txt";
        File fFeedback = new File(Fb);
         try {
            if (!fFeedback.exists()) {
                fFeedback.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Feedback fb = new Feedback(0,"");
        setRating(iRating);
        setFeedBack(sFeedBack);
        BufferedWriter writer = new BufferedWriter(new FileWriter(Fb,true));
        writer.write(getRating()+","+getFeedBack()+","+java.time.LocalDate.now()+"\n");
        writer.close();
    }
}

