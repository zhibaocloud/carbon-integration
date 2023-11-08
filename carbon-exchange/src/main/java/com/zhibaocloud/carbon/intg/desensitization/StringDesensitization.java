package com.zhibaocloud.carbon.intg.desensitization;


/**
 * 字符串脱敏
 *
 * @author yangtuo
 */
public interface StringDesensitization extends Desensitization<String> {

    default String desensitize(String original) {
        return Symbol.getSymbol(original.length(), Symbol.STAR);
    }
}