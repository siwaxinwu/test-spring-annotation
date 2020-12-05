package com.roy.beans;

import lombok.*;

import java.io.Serializable;

/**
 * description：
 * author：dingyawu
 * date：created in 23:16 2020/12/4
 * history:
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 7387479910468805194L;
    private String name;
    private Integer age;
}
