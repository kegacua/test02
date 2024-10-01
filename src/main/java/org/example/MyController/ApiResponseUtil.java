package org.example.MyController;

import org.example.model.ApiResponse;
import org.example.model.Students;

public class ApiResponseUtil {
    //thanh cong
    public static ApiResponse success(String message, Students data) {
        return new ApiResponse(1, message, "200", data);
    }
    //khong thay ket qua
        public static  ApiResponse notFound(String message) {
            return new ApiResponse(1, message, "404", null);
        }
    //du lieu khong dung rang buoc
            public static ApiResponse invalidData(String message) {
                return new ApiResponse (0, message, "900", null);
            }
                    //truy van that bai
                    public static ApiResponse dbError(String message) {
                        return new ApiResponse (0, message, "901", null);
                    }

    //them 1 doi tuong da ton tai
    public static  ApiResponse duplicateData(String message) {
        return new ApiResponse(0, message, "902", null);
    }
    //loi khac
    public static  ApiResponse serverError(String message) {
        return new ApiResponse(0, message, "500", null);
    }
}
