package course.springboot.bean;

public class RetMsg {
    private static final int SUCCESS_NO=200;
    private static final String SUCCESS_MSG="SUCCESS";
    private static final int ERROR_NO=500;
    private Integer errNo;
    private String errMsg;
    private String data;

    public RetMsg() {
    }

    public RetMsg(Integer errNo, String errMsg) {
        this.errNo = errNo;
        this.errMsg = errMsg;
    }

    public RetMsg(Integer errNo, String errMsg, String data) {
        this.errNo = errNo;
        this.errMsg = errMsg;
        this.data = data;
    }

    public static RetMsg buildSuccessMsg(String data){
        return new RetMsg(SUCCESS_NO,SUCCESS_MSG,data);
    }

    public static RetMsg buildErrorMsg(String msg){
        return new RetMsg(ERROR_NO,msg);
    }

    public Integer getErrNo() {
        return errNo;
    }

    public void setErrNo(Integer errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
