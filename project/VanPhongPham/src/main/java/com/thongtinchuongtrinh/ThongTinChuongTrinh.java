package com.ThongTinChuongTrinh;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThongTinChuongTrinh {

    String sPhienBan, sTenChuongTrinh, sMoTa, sTeamDev;
    Date dtNgayBatDau, dtNgayKetThuc;

    ThongTinChuongTrinh(String sPhienBan, String sTenChuongTrinh, String sMoTa, String sTeamDev, Date dtNgayBatDau, Date dtNgayKetThuc) {
        this.sPhienBan = sPhienBan;
        this.sTenChuongTrinh = sTenChuongTrinh;
        this.sMoTa = sMoTa;
        this.sTeamDev = sTeamDev;
        this.dtNgayBatDau = dtNgayBatDau;
        this.dtNgayKetThuc = dtNgayKetThuc;
    }

    public static void display() {
        Calendar calStart = Calendar.getInstance();
        calStart.set(2023, Calendar.NOVEMBER, 8, 20, 30);
        Date startDate = calStart.getTime();

        Calendar calEnd = Calendar.getInstance();
        calEnd.set(2023, Calendar.JANUARY, 1);
        Date endDate = calEnd.getTime();

        ThongTinChuongTrinh chuongTrinh = new ThongTinChuongTrinh(
                "1.0.0",
                "Chuong trinh Ban van phong pham",
                "",
                "1. Nguyen Dai Quoc\n"
                + "   - Facebook: fb.com/wolfdzai\n"
                + "   - Email: luutrithon1996@gmail.com\n"
                + "   - Phone: 0931454176\n"
                + "2. Dinh Phuc Thinh\n"
                + "   - Facebook: fb.com/dinfucthin\n"
                + "   - Email: zaikaman123@gmail.com\n"
                + "   - Phone: 0931816175\n"
                + "3. Tran Trung Viet\n"
                + "   - Facebook: cutt.ly/qwTNnwZY\n"
                + "4. Tran Dang Phat\n"
                + "   - Facebook: cutt.ly/TwTNb3Ur\n"
                + "5. Nguyen Hoang Sang\n"
                + "   - Facebook: cutt.ly/4wTNbGKf\n"
                + "   - Email: lesang01227982715@gmail.com\n"
                + "   - Phone: 0776592967\n",
                startDate,
                endDate
        );
        Date check = new Date();
        System.out.println("Chuong trinh: " + chuongTrinh.sTenChuongTrinh);
        System.out.println("Version: " + chuongTrinh.sMoTa);
        System.out.println("Release Date: " + chuongTrinh.dtNgayBatDau);
        if (chuongTrinh.dtNgayKetThuc == check) {
            System.out.println("Stop Date: " + chuongTrinh.dtNgayKetThuc);
        }
        System.out.println("Dev team:");
        System.out.println(chuongTrinh.sTeamDev);
    }

}
