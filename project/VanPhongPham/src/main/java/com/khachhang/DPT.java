// Lớp KhachHang là một loại NguoiDung
public class KhachHang {
    private String maNguoiDung;
    private String tenDangNhap;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;

    // Default constructor
    public KhachHang() {
    }

    // Parameterized constructor
    public KhachHang(String maNguoiDung, String tenDangNhap, String hoTen, String soDienThoai, String diaChi) {
        this.maNguoiDung = maNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    // Getters
    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    // Setters
    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}


// Lớp TaiKhoan quản lý đăng ký và đăng nhập người dùng
class TaiKhoan {
    NguoiDung[] nguoiDung = new NguoiDung[100]; // Sử dụng mảng cố định với một kích thước tối đa
    int soLuongNguoiDung = 0; // Biến để theo dõi số lượng người dùng
    String tenFile = "nguoidung.txt";

    void dangKy(NguoiDung nguoiDung) throws IOException {
        docDanhSachNguoiDung(); // Đọc danh sách tài khoản từ tệp trước khi thêm tài khoản mới

        for (int i = 0; i < soLuongNguoiDung; i++) {
            if (this.nguoiDung[i].tenDangNhap.equals(nguoiDung.tenDangNhap)) {
                System.out.println("Ten dang nhap da ton tai. Vui long chon mot ten dang nhap khac");
                return; // Không thực hiện đăng ký nếu tên đăng nhập đã tồn tại
            }
        }

        this.nguoiDung[soLuongNguoiDung] = nguoiDung;
        soLuongNguoiDung++;

        ghiDanhSachNguoiDung(); // Ghi danh sách tài khoản mới vào tệp

        System.out.println("Dang ky thanh cong!");
    }

    void docThongTinNguoiDung(KhachHang khachHang) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("thongtin.txt"));
        String line;
   
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5 && parts[1].equals(khachHang.tenDangNhap)) {
                khachHang.maNguoiDung = parts[0];
                khachHang.hoTen = parts[2];
                khachHang.soDienThoai = parts[3];
                khachHang.diaChi = parts[4];
                break;
            }
        }
   
        reader.close();
    }    

    void docDanhSachNguoiDung() throws IOException {
        File file = new File(tenFile);

        if (!file.exists()) {
           file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(tenFile));
        String line;
        soLuongNguoiDung = 0; // Đặt lại biến đếm

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                if ("KhachHang".equals(parts[2])) {
                    this.nguoiDung[soLuongNguoiDung] = new KhachHang(parts[0], parts[1]);
                } 
                
                soLuongNguoiDung++;
            }
        }
        reader.close();
    }

    void ghiDanhSachNguoiDung() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile));
        for (int i = 0; i < soLuongNguoiDung; i++) {
            writer.write(nguoiDung[i].tenDangNhap + "," + nguoiDung[i].matKhau + "," + nguoiDung[i].vaiTro + "\n");
        }
        writer.close();
    }

    void suaThongTinNguoiDung(String tenDangNhap, String hoTenMoi, String soDienThoaiMoi, String diaChiMoi) throws IOException {
    docDanhSachNguoiDung(); // Đọc danh sách tài khoản từ tệp trước khi thực hiện sửa đổi

    for (int i = 0; i < soLuongNguoiDung; i++) {
        if (this.nguoiDung[i].tenDangNhap.equals(tenDangNhap)) {
            this.nguoiDung[i].hoTen = hoTenMoi;
            this.nguoiDung[i].soDienThoai = soDienThoaiMoi;
            this.nguoiDung[i].diaChi = diaChiMoi;
            break;
        }
    }

    ghiDanhSachNguoiDung(); // Ghi danh sách tài khoản mới vào tệp

    System.out.println("Sua thong tin thanh cong!");
}

void xoaThongTinNguoiDung(String tenDangNhap) throws IOException {
    docDanhSachNguoiDung(); // Đọc danh sách tài khoản từ tệp trước khi thực hiện xóa

    int index = -1;
    for (int i = 0; i < soLuongNguoiDung; i++) {
        if (this.nguoiDung[i].tenDangNhap.equals(tenDangNhap)) {
            index = i;
            break;
        }
    }

    if (index != -1) {
        // Di chuyển tất cả các phần tử sau index một bước về phía trước
        for (int i = index; i < soLuongNguoiDung - 1; i++) {
            this.nguoiDung[i] = this.nguoiDung[i + 1];
        }
        soLuongNguoiDung--;
    }

    ghiDanhSachNguoiDung(); // Ghi danh sách tài khoản mới vào tệp

    System.out.println("Xoa thong tin thanh cong!");
}


    boolean dangNhap(String tenDangNhap, String matKhau) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(tenFile));
        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[0].equals(tenDangNhap) && parts[1].equals(matKhau)) {
                System.out.println("Dang nhap thanh cong voi vai tro " + parts[2] + "!");
                found = true;
                break;
            }
        }

        reader.close();

        return found;
    }
    void saveUserInfoToFile(NguoiDung nguoiDung) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("thongtin.txt", true));
        writer.write(nguoiDung.maNguoiDung + "," + nguoiDung.tenDangNhap + "," + nguoiDung.hoTen + "," +
                nguoiDung.soDienThoai + "," + nguoiDung.diaChi + "\n");
        writer.close();
    }    
}
