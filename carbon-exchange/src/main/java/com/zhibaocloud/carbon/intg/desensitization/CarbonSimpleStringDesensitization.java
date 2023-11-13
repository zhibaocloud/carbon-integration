package com.zhibaocloud.carbon.intg.desensitization;

/**
 * @author yangtuo
 */
public class CarbonSimpleStringDesensitization implements CarbonStringDesensitization {

  @Override
  public String desensitize(String original) {
    return Symbol.getSymbol(original.length(), Symbol.STAR);
  }
}
