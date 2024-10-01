package org.example.model;


public class Students {
    private static int increaseid = 0;
    private int id;
    private String name;
    private String gender;
    private int age;
    private double toan;
    private double ly;
    private double hoa;
    private double trung_binh;
    private String hoc_luc;


    public Students(String name, String gender, int age, double toan, double ly, double hoa) {
        this.id = ++increaseid;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.trung_binh = trung_binh();
        this.hoc_luc = hoc_luc();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
         this.name= name;
    }
    public  String getName(){
        return this.name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    public double getTrung_binh() {
        return trung_binh;
    }

    public void setTrung_binh(double trung_binh) {
        this.trung_binh = trung_binh;
    }

    public String getHoc_luc() {
        return hoc_luc;
    }

    public void setHoc_luc(String hoc_luc) {
        this.hoc_luc = hoc_luc;
    }

    public  double trung_binh(){
        return (toan+ly+hoa)/3;
    }
    public  String hoc_luc(){
    if(trung_binh() >= 8) return "Gioi";
    else if(trung_binh() >= 6.5) return "Kha";
    else if(trung_binh() >= 5) return "Trung binh";
    else return "Yeu";
    }
}

