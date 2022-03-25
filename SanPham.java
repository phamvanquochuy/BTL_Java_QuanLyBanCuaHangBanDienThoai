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
public class SanPham implements Serializable{
    private String MaSP;
    private String TenSP;
    private String XuatXu;
    private int SoLuong;
    private float DonGia;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String XuatXu, int SoLuong, float DonGia) {
        super();
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.XuatXu = XuatXu;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public void setXuatXu(String XuatXu) {
        this.XuatXu = XuatXu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }
    
    public void nhapSP(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham: ");
        MaSP = sc.nextLine();
        System.out.println("Nhap ten san pham: ");
        TenSP = sc.nextLine();
        System.out.println("Nhap xuat su: ");
        XuatXu = sc.nextLine();
                // Vòng lặp bắt sự kiện nhập sai
        while(true){
            try {
                System.out.println("Nhap so luong: ");
                setSoLuong(sc.nextInt());
                System.out.println("Nhap don gia: ");
                setDonGia(sc.nextFloat());
                if(getSoLuong()<0 || getDonGia()<0)
                    throw new Exception(); // Số lượng và đơn giá không âm               
                break;
            } catch (Exception e) {
                System.out.println("Nhap sai gia tri. Vui long nhap lai!");
                sc.nextLine();
            }
        }
    }
    public void hienSP(){
        System.out.printf("%-13s|%-20s|%-20s|%-10d|%-10.2f\n",
                getMaSP(),getTenSP(),getXuatXu(),getSoLuong(),getDonGia());
    }

    @Override
    public String toString() {
        return "SanPham{" + "MaSP=" + MaSP + ", TenSP=" + TenSP + 
                ", XuatXu=" + XuatXu + ", SoLuong=" + SoLuong + ", DonGia=" + DonGia + '}';
    }
    
    
}
