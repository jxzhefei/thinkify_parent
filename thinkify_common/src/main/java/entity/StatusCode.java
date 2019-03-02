package entity;

/**
 * @author INstamina
 * @date 2018年12月7日
 * @description 
 */
public class StatusCode {
	public static final int SUCCESS = 50000;//成功
	public static final int ERROR = 50001;//失败
	public static final int LOGINERROR = 50002;//用户名或密码错误
	public static final int REMOTEERROR = 50003;//远程调用失败
	public static final int ACCESSERROR = 50004;//权限不足
	public static final int REPERROR = 50005;//重复操作
}
