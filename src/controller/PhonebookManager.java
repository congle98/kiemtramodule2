package controller;

import model.Contact;
import storage.TextFileFactory;


import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookManager {
    private Scanner scanner = new Scanner(System.in);
    private TextFileFactory textFileFactory = TextFileFactory.getINSTANCE();
    private ArrayList<Contact> contacts = new ArrayList<>();
    private CheckInput checkInput = CheckInput.getINSTANCE();



    public String createPhoneNumber(){
        System.out.println("mời nhập số điện thoại");
        String phoneNumber="";
        boolean check = false;
        do {
            check =false;
            phoneNumber = scanner.nextLine();
            if(!checkInput.checkPhoneNumber(phoneNumber)){
                System.out.println("nhập sai định dang sđt, sđt phải có 10 số");
            }
            for (Contact c:contacts
                 ) {
                if(c.getPhoneNumber().equals(phoneNumber)){
                    System.out.println("sđt đã tồn tại trong danh bạ mời nhập lại");
                    check=true;
                }
            }
        }while (!checkInput.checkPhoneNumber(phoneNumber)||check);
        return phoneNumber;
    }
    public String createGroup(){
        System.out.println("mời nhập nhóm danh bạ ví dụ: gia đình, công việc");
        String group = scanner.nextLine();
        return group;
    }
    public String createFullName(){
        System.out.println("mời nhập họ tên");
        String fullName = scanner.nextLine();
        return fullName;
    }
    public String createGender(){
        System.out.println("mời nhập giới tính");
        String gender = scanner.nextLine();
        return gender;
    }
    public String createAddress(){
        System.out.println("mời nhập địa chỉ");
        String address = scanner.nextLine();
        return address;
    }
    public String createDoB(){
        System.out.println("mời nhập ngày sinh");
        String dateOfBirth = scanner.nextLine();
        return dateOfBirth;
    }
    public String createEmail(){
        System.out.println("mời nhập Email");
        String email="";
        do {
             email = scanner.nextLine();
             if(!checkInput.checkEmail(email)){
                 System.out.println("nhập sai định dạng email mời nhập lại vd:cong@gmail.com");
             }
        }while (!checkInput.checkEmail(email));
        return email;
    }
    public void addContact(){
        Contact contact = new Contact();
        contact.setPhoneNumber(createPhoneNumber());
        contact.setContactGroup(createGroup());
        contact.setFullName(createFullName());
        contact.setGender(createGender());
        contact.setAddress(createAddress());
        contact.setDateOfBirth(createDoB());
        contact.setEmail(createEmail());
        contacts.add(contact);
    }
//    public void showGroupContact(){
//        for (Contact contact:contacts
//             ) {
//            System.out.println(contact.getContactGroup());
//        }
//    }
    public void showContacts(){
        for (Contact contact:contacts
             ) {
            System.out.println(contact);
        }
    }
    public void showContactsMenu(){
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            showContacts();
            System.out.println("1.Thêm mới");
            System.out.println("2.Thoát");
            choose = scanner.nextLine();
            switch (choose){
                    case "1":
                    addContact();
                    break;
                case "2":
                    break;
                default:
                    System.err.println("sai tuỳ chọn");
                    break;
            }
        }while (!choose.equals("2"));
    }
    public Contact getContactByPhoneNumber(){
        System.out.println("mời nhập số điện thoại muốn sửa");
        Boolean check = false;
        Contact contact=null;
        while (!check){
            String numberPhone = scanner.nextLine();
            for (Contact cont:contacts
            ) {
                if(cont.getPhoneNumber().equals(numberPhone)){
                    contact = cont;
                    check=true;
                    break;
                }
            }
            if(numberPhone.equals("")) break;
            if(!check) System.out.println(" ko tìm thấy số điện thoại trên mời nhập lai");
        }
        return contact;
    }
    public void upadteContactMenu(){
        Contact contact = getContactByPhoneNumber();
        if(contact!=null){
            Scanner scanner = new Scanner(System.in);
            String choose;
            System.out.println("Mời nhập thông tin muốn sửa");
            do {
                System.out.println("1.Nhóm danh bạ");
                System.out.println("2.Họ và tên");
                System.out.println("3.Giới tính");
                System.out.println("4.Địa chỉ");
                System.out.println("5.Ngày sinh");
                System.out.println("6.Thoát");
                choose = scanner.nextLine();
                switch (choose){
                    case "1":
                        contact.setContactGroup(createGroup());
                        break;
                    case "2":
                        contact.setFullName(createFullName());
                        break;
                    case "3":
                        contact.setGender(createGender());
                        break;
                    case "4":
                        contact.setAddress(createAddress());
                        break;
                    case "5":
                        contact.setDateOfBirth(createDoB());
                        break;
                    case "6":
                        break;
                    default:
                        System.err.println("sai tuỳ chọn");
                        break;
                }
            }while (!choose.equals("6"));
        }
    }
    public void deleteContact(){
        Contact contact = getContactByPhoneNumber();
        System.out.println("Nhấn Y để xoá hoặc phím bất kỳ để thoát");
        String choose = scanner.nextLine();
        if(choose.equalsIgnoreCase("y")){
            contacts.remove(contact);
        }
    }
    public void getContact(){
        System.out.println("mời nhập số điện thoại cần tìm kiếm");
        String phoneNumber = scanner.nextLine();
        Boolean check = false;
        for (Contact c:contacts
             ) {
            if(c.getPhoneNumber().contains(phoneNumber)){
                System.out.println(c);
                check = true;
            }
        }
        if(!check) System.out.println("số điện thoại ko tồn tại trong thuê bao");
    }
    public void getDataInFile(){
        contacts = textFileFactory.readerFile("data.txt");
        if(contacts.size()==0){
            System.out.println("file chưa có dữ liệu!!");
        }
    }
    public void saveDataOutFile(){
        textFileFactory.saveFile(contacts,"data.txt");
    }

}
