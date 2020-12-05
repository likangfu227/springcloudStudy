package com.lkf.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommPaymentVO<T> {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 返回值
     */
    private T result;

    public CommPaymentVO(Integer code, String message) {
        this(code, message, null);
    }
}
