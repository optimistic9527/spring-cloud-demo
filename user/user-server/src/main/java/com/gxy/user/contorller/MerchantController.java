package com.gxy.user.contorller;
import java.time.LocalDateTime;

import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.vo.ResultVO;
import com.gxy.dto.MerchantInfoInput;
import com.gxy.dto.UserInfoInput;
import com.gxy.user.entity.Merchant;
import com.gxy.user.entity.User;
import com.gxy.user.exception.UserException;
import com.gxy.user.service.MerchantService;

import com.gxy.user.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author guoxingyong
 * @since 2019/1/4 11:29
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    private SnowFlakeIdGenerator snowFlakeIdGenerator;

    @Resource
    private MerchantService merchantService;

    @GetMapping("/{merchantId}")
    public ResultVO acquireMerchantInfo(@PathVariable("merchantId") String merchantId) {
        Merchant merchant = merchantService.findById(merchantId);
        if (merchant == null) {
            throw new UserException(ResultCodeEnum.USER_NOT_EXIST);
        }
        return ResultVO.success(BeanUtils.createMerchantInfoOutput(merchant));
    }

    @PostMapping("/addMerchant")
    public ResultVO addUser(@Valid @RequestBody MerchantInfoInput merchantInfoInput){
        Merchant merchant=new Merchant();
        merchant.setMerchantId(snowFlakeIdGenerator.nextId());
        BeanUtils.copyProperties(merchantInfoInput,merchant);
        merchant.setActive(1);
        if(merchantService.add(merchant)==0){
            throw new UserException("创建商户失败");
        }
        return ResultVO.success();
    }
}