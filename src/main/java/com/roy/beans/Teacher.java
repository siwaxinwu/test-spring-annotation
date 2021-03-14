package com.roy.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/** description： author：dingyawu date：created in 23:21 2020/12/6 history: */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {
  private static final long serialVersionUID = 7387479910468805194L;

  @Value("${teacher.name}")
  private String name;

  @Value("${teacher.age}")
  private Integer age;

  @Value("${teacher.nickName}")
  private String nickName;

  public void init() {
    System.out.println("init。。。。。。。。。");
  }

  public void destroy() {
    System.out.println("destroy。。。。。。。。。");
  }
}
