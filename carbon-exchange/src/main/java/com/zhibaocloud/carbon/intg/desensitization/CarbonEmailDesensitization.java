package com.zhibaocloud.carbon.intg.desensitization;

import com.github.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangtuo
 */
public class CarbonEmailDesensitization implements CarbonStringDesensitization {

    /**
     * 邮箱正则(半匹配)
     */
    private static final Pattern DEFAULT_PATTERN = Pattern.compile("([A-Za-z0-9_\\-.])+@([A-Za-z0-9_\\-.])+\\.([A-Za-z]{2,4})");

    /**
     * 邮箱脱敏
     */
    @Override
    public String desensitize(String original) {
        Matcher matcher = DEFAULT_PATTERN.matcher(original);
        while (matcher.find()) {
            String group = matcher.group();
            int l = group.lastIndexOf("@");
            original = original.replace(group, Symbol.getSymbol(l, Symbol.STAR) + group.substring(l));
        }
        return original;
    }


}