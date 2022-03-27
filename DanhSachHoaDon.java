/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class DanhSachHoaDon {
    ArrayList<HoaDon> listDS = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void nhapDS() throws Exception{
        int n = 0;
        System.out.println("Nhap so luong hoa don: ");
        // Vòng lặp bắt sự kiện nhập sai
        while(true){
            try {
                n = sc.nextInt();
                if(n<0)
                    throw new Exception(); // Số hóa đơn >0
                break;
            } catch (Exception e) {
                System.out.println("Nhap sai gia tri. Vui long nhap lai!");
                sc.nextLine();
                break;
            }
        }
       for(int i=0;i<n;i++){
           System.out.println("-------------------");
           System.out.println("Nhap hoa don thu " + (i+1));
           HoaDon hd = new HoaDon();
           hd.nhap();
           listDS.add(hd);
       }
    }
    
    public void hienDS(){
        System.out.println("\nDanh sach hoa don: ");
        for (HoaDon hd : listDS) {
            System.out.println("-----------------------------");
            System.out.println("Hoa don thu " + (listDS.indexOf(hd)+1));
            hd.hien();
        }
    }
    
    public void timKiem(){
        String x;
        System.out.print("Nhap ma hoa don muon tim kiem: ");
        x = sc.nextLine();
        for (HoaDon hd : listDS) {
            if(hd.getMaHD().equals(x)){
                System.out.println("Thong tin hoa don can tim: ");
                System.out.println("---------------------------");
                hd.hien();
                break;
            }else{
                System.out.println("Ma hoa don khong co trong danh sach");
                break;
            }
        }
    }
    
    public void tinhTong(){
        float tong = 0;
        for (HoaDon hd : listDS) {
            tong+=hd.tinhTong();
        }
        BigDecimal tempBig = new BigDecimal(Double.toString(tong));
        System.out.println("Tong tien cac hoa don: " + tempBig);
    }
    
    public void sapXep(){
        Collections.sort(listDS);
        System.out.println("Sap xep theo tong tien tang dan: ");
        hienDS();
    }
    
    public void xoa(){
        String x;
        int k=0;
        System.out.print("Nhap ma hoa don muon xoa: ");
        x = sc.nextLine();
        for(int i=0;i<listDS.size();i++){
            if(listDS.get(i).getMaHD().equals(x)){
                listDS.remove(i);
                k=1;
                break;
            }
        }
        if(k==0) System.out.println("Khong co ma hoa don nay trong danh sach");
        else System.out.println("Danh sach sau khi xoa");
        hienDS();
    }
    
    public void them() throws Exception {
        HoaDon hd = new HoaDon();
        hd.nhap();
        listDS.add(hd);
    }
    
    public void locTren3Trieu(){
        System.out.println("Danh sach hoa don tren 3 trieu: ");
        for (HoaDon hd : listDS) {
            if(hd.tinhTong()>3000000){
                System.out.println("------------------------");
                hd.hien();
            }
        }
    }
    public void ghiFile() throws FileNotFoundException, IOException{
        FileOutputStream fout = new FileOutputStream("hoadon.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        try {
            for (HoaDon hd : listDS) {
                out.writeObject(hd);
            }
        } catch (Exception e) {
            out.close();
            fout.close();
        }
        System.out.println("Ghi file thanh cong");
    }
    
    public void docFile() throws FileNotFoundException, IOException{
        FileInputStream fin = new FileInputStream("hoadon.txt");
        ObjectInputStream in = new ObjectInputStream(fin);
        try {
            listDS.clear();
            HoaDon hd = null;
            while((hd = (HoaDon)in.readObject())!=null){
                listDS.add(hd);
            }
        } catch (Exception e) {
            in.close();
            fin.close();
        }
        System.out.println("Doc file thanh cong");
    }
}
