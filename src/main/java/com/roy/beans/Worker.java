package com.roy.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.Serializable;

/**
 * description：
 * author：dingyawu
 * date：created in 23:01 2020/12/6
 * history:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {
    private static final long serialVersionUID = 7387479910468805194L;
    @Value("roy")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber; //注入表达式结果

    @Value("http://www.baidu.com")
    private Resource url; // 注入URL资源


}