package java_61;

import java.io.Serializable;

public class SinhVien implements Comparable<SinhVien>, Serializable{
	private int maSinhVien;
	private String hoTen;
	private int namSinh;
	private double diemTB;
	
	public SinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public SinhVien(int maSinhVien, String hoTen, int namSinh, double diemTB) {
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diemTB = diemTB;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}
	
	public String getTen() {
		String ten = this.getHoTen().trim();//xóa khoảng trắng ở hai đầu tên
		if(ten.indexOf(" ") > 0) {//nếu trong tên có khoảng trắng
			int vt = ten.lastIndexOf(" ");//vt là vị trí khoảng trắng cuối cùng
			ten = ten.substring(vt+1);//gán tên bằng chuỗi sau dấu khoảng trắng cuối cùng của tên
		}
		return ten;//trả về tên
	}
	
	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", namSinh=" + namSinh + ", diemTB=" + diemTB
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return maSinhVien == other.maSinhVien;
	}

	@Override
	public int compareTo(SinhVien o) {
		return (int) (o.getDiemTB() - this.getDiemTB());
		//Chuỗi thì dùng compareTo
        //Số thì trừ
	}
}
