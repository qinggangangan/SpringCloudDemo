package com.qinggan.cloud;

import java.time.ZonedDateTime;

/**
 * Description: ${DESCRIPTION}
 * Author: ${USER}
 * Date: ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}