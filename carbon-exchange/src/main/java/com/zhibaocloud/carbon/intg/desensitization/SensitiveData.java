package com.zhibaocloud.carbon.intg.desensitization;

import java.io.Serializable;

/**
 * 敏感数据标记接口
 * <p>
 * 所有实现该接口的数据都是敏感数据，支持脱敏处理
 *
 * @author yangtuo
 */
public interface SensitiveData extends Serializable {

}
