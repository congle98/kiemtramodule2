package views;

import controller.PhonebookManager;

import java.util.Scanner;

public class Client {
    static PhonebookManager phonebookManager = new PhonebookManager();
    public static void main(String[] args) {
    menu();
    }






    static void menu(){
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới thuê bao");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xoá liên hệ");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi vào file");
            System.out.println("8.Thoát");
            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    phonebookManager.showContactsMenu();
                    break;
                case "2":
                    phonebookManager.addContact();
                    break;
                case "3":
                    phonebookManager.upadteContactMenu();
                    break;
                case "4":
                    phonebookManager.deleteContact();
                    break;
                case "5":
                    phonebookManager.getContact();
                    break;
                case "6":
                    phonebookManager.getDataInFile();
                    break;
                case "7":
                    phonebookManager.saveDataOutFile();
                    break;
                case "8":
                    System.out.println("cảm ơn đã dùng phần mềm");
                    break;
                default:
                    System.err.println("sai tuỳ chọn");
                    break;
            }
        }while (!choose.equals("8"));
    }
}
