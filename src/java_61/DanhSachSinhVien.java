package java_61;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> dssv;

	public DanhSachSinhVien() {
		this.dssv = new ArrayList<SinhVien>();
	}

	public DanhSachSinhVien(ArrayList<SinhVien> dssv) {
		this.dssv = dssv;
	}
	
	//1.Thêm sinh viên
	public void themSinhVien(SinhVien sv) {
		this.dssv.add(sv);
	}
	//2.Hiển thị danh sách sinh viên
	public void hienThiDSSV() {
		for (SinhVien sinhVien : dssv) {
			System.out.println(sinhVien);
		}
	}
	//3.Kiểm tra danh sách có rổng hay không
	public boolean kiemTraDanhSachRong() {
		return this.dssv.isEmpty();
	}
	//4.In ra số lượng sinh viên
	public int soLuongSinhVien() {
		return this.dssv.size();
	}
	//5.Làm rỗng danh sách sinh viên
	public void lamRongDSSV() {
		this.dssv.clear();
	}
	//6.Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên
	public boolean kiemTraSinhVienTonTai(SinhVien sv) {
		return this.dssv.contains(sv);
	}
	//7.Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên
	public void xoaSinhVien(SinhVien sv) {
		this.dssv.remove(sv);
	}
	//8.   Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.
	public void timKiemTheoTen(String ten) {
		for (SinhVien sinhVien : dssv) {
			if(sinhVien.getTen().equals(ten) == true) {
				System.out.println(sinhVien);
			}
		}
	}
	//9.   Xuất ra danh sách sinh viên có điểm từ cao đến thấp
	public void dssvDiemTuCaoDenThap() {
		Collections.sort(dssv);
//		Collections.sort(dssv,new Comparator<SinhVien>() {
//			@Override
//			public int compare(SinhVien sv1, SinhVien sv2) {
//				if (sv1.getDiemTB() > sv2.getDiemTB()) {
//		            return -1;
//		        }
//		        return 1;
//			}
//		 });
	}
	//10.   Xuất ra danh sách sinh viên sắp xếp theo tên
	public void dssvSapXepTheoTen() {
		Collections.sort(dssv,new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
		        return sv1.getTen().compareTo(sv2.getTen());
		        //Chuỗi thì dùng compareTo
		        //Số thì trừ
			}
		 });
	}
	
	//11.Ghi danh sách sinh viên xuống file
	public void luuDSSVXuongFile(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for (SinhVien sinhVien : dssv) {
				oos.writeObject(sinhVien);
			}
			
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//12.Đọc thông tin từ file
	public void docFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			ArrayList<SinhVien> list_SV = new ArrayList<SinhVien>();
			while(fis.available() > 0) {
				SinhVien sv = (SinhVien) ois.readObject();
				if(sv == null) {
					break;
				}else {
					list_SV.add(sv);
				}
			}
			
			for (SinhVien sinhVien : list_SV) {
				System.out.println(sinhVien);
			}
				
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}