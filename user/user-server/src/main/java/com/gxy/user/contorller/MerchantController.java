package com.gxy.user.contorller;

import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.input.MerchantInfoInput;
import com.gxy.store.dto.output.MerchantInfoOutput;
import com.gxy.user.entity.Merchant;
import com.gxy.user.exception.UserException;
import com.gxy.user.service.MerchantService;
import com.gxy.user.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public ResultVO<MerchantInfoOutput> acquireMerchantInfo(@PathVariable("merchantId") Long merchantId) {
        Merchant merchant = merchantService.findById(merchantId);
        if (merchant == null) {
            throw new UserException(ResultCodeEnum.USER_NOT_EXIST);
        }
        return ResultVO.success(BeanUtils.createMerchantInfoOutput(merchant));
    }

    @PostMapping("/addMerchant")
    public ResultVO addUser(@Validated({MerchantInfoInput.AddMerchant.class}) @RequestBody MerchantInfoInput merchantInfoInput) {
        Merchant merchant = new Merchant();
        merchant.setMerchantId(snowFlakeIdGenerator.nextId());
        BeanUtils.copyProperties(merchantInfoInput, merchant);
        merchant.setActive(1);
        if (merchantService.add(merchant) == 0) {
            throw new UserException("创建商户失败");
        }
        return ResultVO.success();
    }

    @PostMapping("/updateMerchant")
    public ResultVO updateUser(@Validated({MerchantInfoInput.UpdateMerchant.class}) @RequestBody MerchantInfoInput merchantInfoInput) {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantInfoInput,merchant);
        if(merchantService.modifyByIdSelective(merchant)==0){
            throw new UserException("修改商户失败");
        }
        return ResultVO.success();
    }
}
