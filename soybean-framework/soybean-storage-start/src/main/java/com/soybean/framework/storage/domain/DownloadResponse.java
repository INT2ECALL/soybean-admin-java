package com.soybean.framework.storage.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.File;

/**
 * 响应结果
 *
 * @author wenxina
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownloadResponse implements java.io.Serializable {

    private static final long serialVersionUID = -498222912510624959L;

    private BufferedReader bufferedReader;
    /**
     * 上下文类型
     */
    private String contentType;
    /**
     * 内容编码
     */
    private String contentEncoding;
    /**
     * 文件长度
     */
    private long contentLength;
    /**
     * 文件-本地
     */
    private File file;
    /**
     * 本地文件地址
     */
    private String localFilePath;
}
