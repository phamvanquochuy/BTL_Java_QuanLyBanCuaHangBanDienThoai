/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class KhachHang implements Serializable{
    private String MaKH;
    private String HoTen;
    private String DiaChi;
    private String SoDT;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String HoTen, String DiaChi, String SoDT) {
        super();
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }
    
    public void nhapKH(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang: ");
        MaKH = sc.nextLine();
        System.out.println("Nhap ho ten khach hang: ");
        HoTen = sc.nextLine();
        System.out.println("Nhap dia chi khach hang: ");
        DiaChi = sc.nextLine();
        System.out.println("Nhap so dien thoai khach hang: ");
        SoDT = sc.nextLine();
    }
    public void hienKH(){
        System.out.println("Ten khach hang: " + getHoTen());
        System.out.println("SDT khach hang: " + getSoDT());
        System.out.println("Dia chi khach hang: " + getDiaChi());
    }

    @Override
    public String toString() {
        return "KhachHang{" + "MaKH=" + MaKH + ", HoTen=" + HoTen + 
                ", DiaChi=" + DiaChi + ", SoDT=" + SoDT + '}';
    }
    
    
}
