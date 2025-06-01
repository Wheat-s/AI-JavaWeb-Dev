package com.wheat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private Integer id; // 员工ID
    private String username; // 用户名
    private String name; // 名称
    private String token;    // 登录令牌
}
