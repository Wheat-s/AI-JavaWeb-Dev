package com.wheat.exception;

import com.wheat.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错了~", e);
        return Result.error("出错了,请联系管理员~");
    }
    
    
   @ExceptionHandler 
    public Result handleDuplicateKeyException(DuplicateKeyException e){
       log.error("程序出错了~", e);
       /*//从异常对象 e 中获取错误信息的字符串
       String message = e.getMessage();
       *//**
        * 在异常信息 message 中查找 “Duplicate entry” 这个关键词出现的位置
        * 	•	如果找到了，它会返回第一次出现的索引（如 0、20 等）。
        * 	•	如果没找到，则返回 -1。
        *//*
       int i = message.indexOf("Duplicate entry");
       
       // 从 message 字符串的 第 i 个位置（包含）开始，截取到末尾，形成新的字符串。
       String errMsg = message.substring(i);
       
       // 根据空格对字符串 errMsg 进行切分，每个单词作为一个数组元素，存储到 arr 数组中。
       String[] arr = errMsg.split(" ");
       
       // 返回错误信息,并使用.replace("'", "")去掉单引号
       return Result.error(arr[2].replace("'","") + " 已存在");*/
       
       // 根据chatGPT修改
       String message = e.getMessage();
       
       /*
           获取错误信息的值 根据单引号 ‘  来截取  
           Duplicate entry 'aaa' for key 'emp.username'
       */
       int firstQuote = message.indexOf("'"); //获取第一个单引号
       int secondQuote = message.indexOf("'", firstQuote + 1);  // 获取第二个 单引号
       String value = message.substring(firstQuote + 1, secondQuote);  // 把两个单引号之间的内容截取 赋给value 也就是 aaa

       // 获取数据库的 表.字段  'emp.username'
       int lastQuote = message.lastIndexOf("'"); //获取最后一个单引号
       int secondLastQuote = message.lastIndexOf("'", lastQuote - 1); // 获取倒数第二个单引号
       String key = message.substring(secondLastQuote + 1, lastQuote); // 把两个单引号之间的内容截取 赋给key 也就是 emp.username 

       /*
           提取表的字段名
           判断是否包含 . 如果没有就返回key本身  
           emp.username --> username
       */
       String field = key.contains(".") ? key.split("\\.")[1] : key; 

       // emp表中的字段中文名映射（可根据项目实际需求维护）
       Map<String, String> fieldMap = new HashMap<>();
       fieldMap.put("username", "用户名");
       fieldMap.put("phone", "手机号");
       fieldMap.put("email", "邮箱");

       /**
        *  getOrDefault(key, defaultValue) 是 Java Map 的一个方法：
        *  如果 fieldMap 中 存在这个字段名的键（即 key），就返回对应的 value（例如 “用户名”）。
        *  如果 不存在，就返回默认值，也就是 field 自己。
        */
       String fieldName = fieldMap.getOrDefault(field, field); 
       
       // 返回错误的信息 例如: 用户名: aaa 已存在.
       return Result.error(fieldName + ": " + value + " 已存在");
   }
    
}
