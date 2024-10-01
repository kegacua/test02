package org.example.MyController;

import org.example.model.ApiResponse;
import org.example.model.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private List<Students> students = new ArrayList<Students>();

    public Controller() {
        doc_file();
    }

    //them sinh vien
    public ApiResponse them(String name, String gender, int age, double toan, double ly, double hoa){
        try {
            for(Students student: students){
                if(student.getName().equals(name) && student.getGender().equals(gender) && student.getAge() == age){
                    return ApiResponseUtil.duplicateData("doi tuong da ton tai trong tep studen.txt");
                }
            }
            Students student = new Students(name, gender, age, toan, ly, hoa);
            students.add(student);
            return ApiResponseUtil.success("them thong tin thanh cong",student);
        }
        catch(Exception e){
            return ApiResponseUtil.dbError("loi");
        }
    }
    //update by id
    public  ApiResponse update_id(int id, String name, String gender, int age, double toan, double ly, double hoa){
        for(Students s : students){
            if(s.getId()==id){
                s.setName(name);
                s.setGender(gender);
                s.setAge(age);
                s.setToan(toan);
                s.setLy(ly);
                s.setHoa(hoa);
                s.setTrung_binh(s.trung_binh());
                s.setHoc_luc(s.hoc_luc());
                return ApiResponseUtil.success("update id thong tin thanh cong"
                        ,new Students(name,gender,age,toan,ly,hoa));
            }

        }
        return ApiResponseUtil.notFound("khong tin thay ket qua");

    }
    //xoa sinh vien
    public ApiResponse xoa_id(int id){
        if( students.remove(students.removeIf(students -> students.getId() == id))){
            return ApiResponseUtil.success("xoa thanh cong",null);
        }
        return ApiResponseUtil.notFound("xoa khong thanh cong");
    }
    //tim-kiem theo ten
    public ApiResponse tim_kiem(String name) {
        for (Students s : students) {
            if (s.getName().equals(name)) {
                return ApiResponseUtil.success("tim kiem ten thanh cong",s);
            }
        }
        return ApiResponseUtil.notFound("tim kiem ten that bai");
    }
    //sap  xep theo diem
    public ApiResponse sap_xep_diem(){
        students.sort(Comparator.comparingDouble(Students::getTrung_binh).reversed());
        return ApiResponseUtil.success("sap xep theo diem thanh cong",null);
    }
    //sap xep theo ten
    public ApiResponse sap_xep_ten(){
        students.sort(Comparator.comparing(Students::getName));
        return ApiResponseUtil.success("sap xep theo ten thanh cong",null);
    }
    //hien thi danh sach
    public void hien_thi(){
        for(Students s : students){
            System.out.println(s.getId()+","+s.getName()+","+s.getAge()+","+s.getGender()+","+s.getToan()+","+s.getLy()+","+s.getHoa());
        }
         ApiResponseUtil.success("hien thi thanh cong",null).Form();
    }
    //ghi file
    public void ghi_file() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\tuan\\IdeaProjects\\test01\\src\\main\\java\\org\\example\\text\\student01.txt"))) {
            for (Students s : students) {
                writer.print(",");
                writer.print(s.getName()+",");
                writer.print(s.getAge()+",");
                writer.print(s.getGender()+",");
                writer.print(s.getToan()+",");
                writer.print(s.getLy()+",");
                writer.print(s.getHoa()+",");
                writer.print(s.getTrung_binh()+",");
                writer.println(s.getHoc_luc()+",");

            }
             ApiResponseUtil.success("ghi file thanh cong",null).Form();
        } catch (IOException e) {
            //e.printStackTrace();
             ApiResponseUtil.dbError("ghi file khong thanh cong").Form();
        }
    }
    //doc_file

    public void doc_file() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\tuan\\IdeaProjects\\test01\\src\\main\\java\\org\\example\\text\\student.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String gender = data[3];
                double toan = Double.parseDouble(data[4]);
                double ly = Double.parseDouble(data[5]);
                double hoa = Double.parseDouble(data[6]);
                students.add(new Students(name, gender, age, toan, ly, hoa));

            }
             ApiResponseUtil.success("doc file thong tin thanh cong",null).Form();
        } catch (IOException e) {
            //System.out.println("Lỗi khi đọc file: " + e.getMessage());
            //e.printStackTrace();
            ApiResponseUtil.dbError("doc file thong tin thanh cong").Form();
        }
    }

}
