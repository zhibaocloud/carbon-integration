package com.zhibaocloud.carbon.intg.desensitization;

/**
 * @author yangtuo
 */
public class Symbol {


    /**
     * '*'脱敏符
     */
    public static final String STAR = "*";

    private Symbol() {

    }

    /**
     * 获取符号
     *
     * @param number 符号个数
     * @param symbol 符号
     */
    public static String getSymbol(int number, String symbol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }
}
