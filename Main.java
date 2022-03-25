/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        DanhSachHoaDon ds = new DanhSachHoaDon();
        while(true) Menu(ds);
    }
    
    private static void Menu(DanhSachHoaDon ds) throws Exception{
        int chon;
        System.out.println("\n----MENU----");
        System.out.println("1. Them danh sach hoa don.");
        System.out.println("2. Them tung hoa don.");
        System.out.println("3. Hien danh sach hoa don.");
        System.out.println("4. Tin kiem hoa don theo ma.");
        System.out.println("5. Xoa hoa don theo ma.");
        System.out.println("6. Tong tien tat ca hoa don.");
        System.out.println("7. Sap xep hoa don theo tong tien");
        System.out.println("8. Danh sach hoa don co tong tien tren 3000000.");
        System.out.println("9. Ghi file");
        System.out.println("10. Doc file");
        System.out.println("0. Thoat");
        
        System.out.print("Moi ban chon:" );
        while(true){
            try {
                chon = sc.nextInt();
                if(!(chon >= 0 && chon <=10)) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Khong hop le. Vui long nhap lai!");
                sc.nextLine();
            }
        }
        
        switch(chon){
            case 1: ds.nhapDS(); break;
            case 2: ds.them(); break;
            case 3: ds.hienDS(); break;
            case 4: ds.timKiem(); break;
            case 5: ds.xoa(); break;
            case 6: ds.tinhTong(); break;
            case 7: ds.sapXep(); break;
            case 8: ds.locTren3Trieu(); break;
            case 9: ds.ghiFile(); break;
            case 10: ds.docFile(); break;
            case 0: System.out.println("Chuong trinh ket thuc!"); System.exit(0);
        }
        
    }
}
