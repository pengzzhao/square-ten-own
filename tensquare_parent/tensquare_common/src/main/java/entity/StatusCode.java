package entity;

public final class StatusCode {

    /**  成功  */
    public static final int OK = 2000;
    /**  失败  */
    public static final int ERROR = 2001;
    /**  用户名或密码错误  */
    public static final int LOGIN_ERROR = 2002;
    /**  权限不足  */
    public static final int ACCESS_ERROR = 2003;
    /**  远程调用失败  */
    public static final int REMOTE_ERROR = 2004;
    /**  重复操作  */
    public static final int REPERROR = 2005;

}
