package io.github.wujun728.oauth.utils;

/**
 * @author jun
 * @version 1.0
 * @date 2021/10/22
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
public class UsernameHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    public static String getContext() {
        return contextHolder.get();
    }

    public static void setContext(String username) {
        contextHolder.set(username);
    }

    public static void clearContext() {
        contextHolder.remove();
    }
}
