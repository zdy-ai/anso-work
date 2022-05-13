package sms.persistence;

/**
 * @Package: PACKAGE_NAME
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 11:55
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class PerException extends Exception{
    public PerException() {
    }

    public PerException(String message) {
        super(message);
    }

    public PerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PerException(Throwable cause) {
        super(cause);
    }
}
