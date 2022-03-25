/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class HoaDon extends KhachHang implements Comparable<HoaDon>, Serializable{

    private String MaHD;
    private String TenNV;
    private int SoLuongDaBan;
    private String NgayLap;
    ArrayList<SanPham> listSP;

    public HoaDon() {
        super();
    }

    public HoaDon(String MaHD, String TenNV, int SoLuongDaBan, String NgayLap, ArrayList<SanPham> listSP, String MaKH, String HoTen, String DiaChi, String SoDT) {
        super(MaKH, HoTen, DiaChi, SoDT);
        this.MaHD = MaHD;
        this.TenNV = TenNV;
        this.SoLuongDaBan = SoLuongDaBan;
        this.NgayLap = NgayLap;
        this.listSP = listSP;
    }
    
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getSoLuongDaBan() {
        return SoLuongDaBan;
    }

    public void setSoLuongDaBan(int SoLuongDaBan) {
        this.SoLuongDaBan = SoLuongDaBan;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public ArrayList<SanPham> getListSP() {
        return listSP;
    }

    public void setListSP(ArrayList<SanPham> listSP) {
        this.listSP = listSP;
    }
    
    public void nhap() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don: ");
        MaHD = sc.nextLine();
        System.out.println("Nhap ten nhan vien: ");
        TenNV = sc.nextLine();
        super.nhapKH();
        System.out.println("Nhap so luong da ban: ");
        // Vòng lặp bắt sự kiện nhập sai
        while(true){
            try {
                SoLuongDaBan = sc.nextInt();
                if(SoLuongDaBan < 0)
                    throw new Exception(); // Số lượng bán không âm
                break;
            } catch (Exception e) {
                System.out.println("Nhap sai gia tri. Vui long nhap lai!");
                sc.nextLine();
            }
        }
        listSP = new ArrayList<>(SoLuongDaBan);
        for(int i=0;i<SoLuongDaBan;i++){
            SanPham sp = new SanPham();
            System.out.println("Nhap mat hang thu " + (i+1));
            sp.nhapSP();
            listSP.add(sp);
        }
    }
    
    public void hien(){
        System.out.println("\nMa hoa don: " + MaHD);
        System.out.println("Ten nhan vien: " + TenNV);
        super.hienKH();
        System.out.println("So luong da ban: "+ SoLuongDaBan);
        System.out.println("Danh sach mat hang: ");
        System.out.printf("%-13s|%-20s|%-20s|%-10s|%-10s\n",
                "Ma san pham","Ten san pham","Xuat xu","So luong","Don gia");
        for (SanPham sp : listSP) {
            sp.hienSP();
        }
    }
    
    public float tinhTong(){
            float tong=0;
            for (SanPham sp : listSP) {
                tong+=(sp.getDonGia()*sp.getSoLuong());
            }
            return tong;
        }
    
    @Override
    public int compareTo(HoaDon o) {
        if(tinhTong()>o.tinhTong()) return 1;
        else if(tinhTong()<o.tinhTong()) return -1;
        else return 0;
    }
    
    
}
