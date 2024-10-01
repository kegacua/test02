package org.example.model;

public class ApiResponse {
    private int status;
    private String message;
    private String code;
    private Students data;

    public ApiResponse(int status, String message, String code, Students data) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.data = data;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Students getData() {
        return data;
    }
    public void setData(Students data) {
        this.data = data;
    }
    public void Form(){
        System.out.println("{");
        System.out.println("status:" + status+",");
        System.out.println("message: " + message+",");
        System.out.println("code: " + code+",");
        if(data != null){
            System.out.println("data: [");
            System.out.println("{");
            System.out.println("Id:"+data.getId());
            System.out.println("Name:"+data.getName());
            System.out.println("Gender:"+data.getGender());
            System.out.println("Age:"+data.getAge());
            System.out.println("}");
            System.out.println("]");

        }
        else{
        System.out.println("data: {}");
        }
        System.out.println("}");
    }

}
