package Util;

/**
 * Created by macbook on 4/3/17.
 */
public class HTTPResponse {

    public static class Status {
        private Integer code;
        private String message;

        public Status(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Status(Integer code) {
            this.code = code;
        }

        public Status() {
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private Status status;
    private Object data;

    public HTTPResponse(Status status, Object data) {
        this.status = status;
        this.data = data;
    }

    public HTTPResponse(Status status) {
        this.status = status;
    }

    public HTTPResponse() {
    }
}
