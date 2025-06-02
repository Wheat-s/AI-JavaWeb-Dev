package com.wheat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzOption {
    // 测试提交信息是否清空,并且修改了IDEA git 提交时检查代码的警告和导入包未使用的设置.
    private List clazzList;
    private List dataList;
}
