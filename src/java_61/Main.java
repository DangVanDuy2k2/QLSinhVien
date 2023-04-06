package java_61;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		int luaChon = 0;
		do {
			System.out.println("MENU ---------- ");
			System.out.println("Vui lòng chọn chức năng: ");
			System.out.println(
			  "1.   Thêm sinh viên vào danh sách.\n"
			+ "2.   In danh sách sinh viên ra màn hình.\n"
			+ "3.   Kiểm tra danh sách có rỗng hay không.\n"
			+ "4.   Lấy ra số lượng sinh viên trong danh sách.\n"
			+ "5.   Làm rỗng danh sách sinh viên.\n"
			+ "6.   Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên.\n"
			+ "7.   Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.\n"
			+ "8.   Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.\n"
			+ "9.   Xuất ra danh sách sinh viên có điểm từ cao đến thấp.\n"
			+ "10.  Xuất ra danh sách sinh viên sắp xếp theo tên.\n"
			+ "11.  Lưu xuống file.\n"
			+ "12.  Đọc thông tin từ file.\n"
			+ "0.   Thoát khỏi chương trình");
			luaChon = sc.nextInt();
			sc.nextLine();
			
			switch (luaChon) {
			case 1:
				//1.	Thêm sinh viên vào danh sách.
				System.out.println("Nhập mã sinh viên: "); int maSinhVien = sc.nextInt();sc.nextLine();
				System.out.println("Nhập họ và tên: "); String hoVaTen = sc.nextLine();
				System.out.println("Nhập năm sinh: "); int namSinh = sc.nextInt();
				System.out.println("Nhập điểm trung bình: "); float diemTrungBinh = sc.nextFloat();
				SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
				dssv.themSinhVien(sv);
				break;
			case 2:
				//2.	In danh sách sinh viên ra màn hình
				dssv.hienThiDSSV();
				break;
			case 3:
				//3.	Kiểm tra danh sách có rỗng hay không
				System.out.println("Danh sách sinh viên rỗng : "+dssv.kiemTraDanhSachRong());
				break;
			case 4:
				//4.	Lấy ra số lượng sinh viên trong danh sách
				System.out.println("Số lượng sinh viên : "+dssv.soLuongSinhVien());
				break;
			case 5:
				//5.	Làm rỗng danh sách sinh viên.
				dssv.lamRongDSSV();
				break;
			case 6:
				//6.	Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên
				System.out.println("Nhập mã sinh viên : ");int maSinhVien1 = sc.nextInt();
				SinhVien sv1 = new SinhVien(maSinhVien1);
				
				System.out.println("Sinh viên tồn tại : "+dssv.kiemTraSinhVienTonTai(sv1));
				break;
			case 7:
				//7.    Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên
				System.out.println("Nhập mã sinh viên : ");int maSinhVien2 = sc.nextInt();
				SinhVien sv2 = new SinhVien(maSinhVien2);
				
				dssv.xoaSinhVien(sv2);
				break;
			case 8:
				//8.   Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím
				System.out.println("Nhập tên cần tìm : ");String ten = sc.nextLine();
				
				dssv.timKiemTheoTen(ten);
				break;
			case 9:
				//9.   Xuất ra danh sách sinh viên có điểm từ cao đến thấp
				dssv.dssvDiemTuCaoDenThap();
				dssv.hienThiDSSV();
				break;
			case 10:
				//10.   Xuất ra danh sách sinh viên sắp xếp theo tên
				dssv.dssvSapXepTheoTen();
				dssv.hienThiDSSV();
				break;
			case 11:
				System.out.println("Nhập tên file : ");String tenFile1 = sc.nextLine();
				File f1 = new File(tenFile1);
				dssv.luuDSSVXuongFile(f1);
				break;
			case 12 :
				System.out.println("Nhập tên file : ");String tenFile2 = sc.nextLine();
				File f2 = new File(tenFile2);
				dssv.docFile(f2);
				break;
			default:
				break;
			}
		}while(luaChon!=0);
	}
}
