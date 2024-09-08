package com.qinggan.cloud.service;

import com.qinggan.cloud.entities.Pay;

import java.util.List;

/**
 * Description:
 * Author: 1401687501x's
 * Date: 2024/5/15 21:45
 */
public interface PayService {

    int add(Pay pay);
    int delete(Integer id);
    int update(Pay pay);
    Pay getById(Integer id);
    List<Pay> getAll();
}
