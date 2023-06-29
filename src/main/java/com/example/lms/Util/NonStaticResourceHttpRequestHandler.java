package com.example.lms.Util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.nio.file.Path;

// 自定义请求处理器，用于返回视频流
@Component
public class NonStaticResourceHttpRequestHandler extends ResourceHttpRequestHandler {
    public final static String ATTR_FILE = "NON-STATIC-FILE";


    @Override
    protected Resource getResource(HttpServletRequest request) {
        // 从请求属性获取文件路径
        final Path filePath = (Path) request.getAttribute(ATTR_FILE);

        // 创建 FileSystemResource 对象，并使用文件路径作为参数
        return new FileSystemResource(filePath);
    }
}