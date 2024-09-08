package com.qinggan.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.qinggan.cloud.entities.Pay;
import com.qinggan.cloud.entities.PayDTO;
import com.qinggan.cloud.resp.ResultData;
import com.qinggan.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * Author: 1401687501x's
 * Date: 2024/5/15 22:10
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值："+i);
    }

    @DeleteMapping("/pay/delete/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> UpdatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值："+i);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        Pay payById = payService.getById(id);
        return ResultData.success(payById);
    }

    @GetMapping("pay/getAll")
    @Operation(summary = "查询",description = "查询所有记录")
    public ResultData<List<Pay>> getAll(){
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${qinggan.info}") String qingganInfo)
    {
        return "qingganInfo: "+qingganInfo+"\t"+"port: "+port;
    }
}
