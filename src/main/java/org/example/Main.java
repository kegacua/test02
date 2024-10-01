package org.example;

import org.example.MyController.ApiResponseUtil;
import org.example.MyController.Controller;
import org.example.model.ApiResponse;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Controller manager = new Controller();
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Cập nhật thông tin sinh viên bởi ID");
                System.out.println("3. Xóa sinh viên bởi ID");
                System.out.println("4. Tìm kiếm sinh viên theo tên");
                System.out.println("5. Sắp xếp sinh viên theo điểm trung bình (GPA)");
                System.out.println("6. Sắp xếp sinh viên theo tên");
                System.out.println("7. Hiển thị danh sách sinh viên");
                System.out.println("8. Ghi danh sách sinh viên vào file 'student01.txt'");
                System.out.println("9. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập giới tính: ");
                        String gender = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age = scanner.nextInt();
//                        int age;
//                        try {
//                            System.out.print("Nhập tuổi: ");
//                             age = scanner.nextInt();
//
//                            // Kiểm tra tuổi hợp lệ
//                            if (age <= 0) {
//                                ApiResponse response = ApiResponseUtil.invalidData("Invalid age: Age must be greater than 0.");
//                                System.out.println(response.getMessage());
//                                break;
//                            }
//                        } catch (InputMismatchException e) {
//                            scanner.nextLine();  // Clear buffer (vì sau lỗi InputMismatch, scanner sẽ không đọc được dòng tiếp theo đúng cách)
//                            ApiResponse response = ApiResponseUtil.invalidData("Invalid input: Age must be an integer.");
//                            System.out.println(response.getMessage());
//                            break;
//                        }
                        System.out.print("Nhập điểm toán: ");
                        double toan = scanner.nextDouble();
                        System.out.print("Nhập điểm lý: ");
                        double ly = scanner.nextDouble();
                        System.out.print("Nhập điểm hóa: ");
                        double hoa = scanner.nextDouble();
                        manager.them(name, gender, age, toan, ly, hoa).Form();
                        break;
                    case 2:
                        System.out.print("Nhập ID sinh viên: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhập tên: ");
                        String name01 = scanner.nextLine();
                        System.out.print("Nhập giới tính: ");
                        String gender01 = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age01 = scanner.nextInt();
                        System.out.print("Nhập điểm toán: ");
                        double toan01= scanner.nextDouble();
                        System.out.print("Nhập điểm lý: ");
                        double ly01 = scanner.nextDouble();
                        System.out.print("Nhập điểm hóa: ");
                        double hoa01 = scanner.nextDouble();
                        manager.update_id(id, name01, gender01, age01, toan01, ly01, hoa01).Form();
                        break;
                    case 3:
                        System.out.print("Nhập ID sinh viên: ");
                        id = scanner.nextInt();
                        manager.xoa_id(id).Form();
                        break;
                    case 4:
                        System.out.print("Nhập tên sinh viên: ");
                        String searchName = scanner.nextLine();
                        manager.tim_kiem(searchName).Form();
                       System.out.println(manager.tim_kiem(searchName).getData().getId()
                               +","+manager.tim_kiem(searchName).getData().getName()
                               +","+manager.tim_kiem(searchName).getData().getAge()
                               +","+manager.tim_kiem(searchName).getData().getGender()
                               +","+manager.tim_kiem(searchName).getData().getToan()
                               +","+manager.tim_kiem(searchName).getData().getLy()
                               +","+manager.tim_kiem(searchName).getData().getHoa()
                       );
                        break;
                    case 5:

                        manager.sap_xep_diem().Form();
                        manager.hien_thi();
                        break;
                    case 6:
                        manager.sap_xep_ten().Form();
                        manager.hien_thi();
                        break;
                    case 7:
                        manager.hien_thi();
                        break;
                    case 8:
                        manager.ghi_file();
                        System.out.println("Ghi file thành công!");
                        break;
                    case 9:
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
            scanner.close();
        }
}