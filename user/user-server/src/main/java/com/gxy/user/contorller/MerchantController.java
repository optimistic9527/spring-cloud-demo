package com.gxy.user.contorller;

import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.common.dto.MerchantInfo;
import com.gxy.store.common.vo.MerchantInfoVO;
import com.gxy.user.entity.Merchant;
import com.gxy.user.exception.UserException;
import com.gxy.user.service.MerchantService;
import com.gxy.user.utils.BeanUtil;
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
    public ResultVO<MerchantInfoVO> acquireMerchantInfo(@PathVariable("merchantId") Long merchantId) {
        Merchant merchant = merchantService.findById(merchantId);
        if (merchant == null) {
            throw new UserException(ResultCodeEnum.USER_NOT_EXIST);
        }
        return ResultVO.success(BeanUtil.createMerchantInfoVO(merchant));
    }

    @PostMapping("/addMerchant")
    public ResultVO addUser(@Validated({MerchantInfo.AddMerchant.class}) @RequestBody MerchantInfo merchantInfo) {
        Merchant merchant = new Merchant();
        merchant.setMerchantId(snowFlakeIdGenerator.nextId());
        BeanUtil.copyProperties(merchantInfo, merchant);
        merchant.setActive(1);
        if (merchantService.add(merchant) == 0) {
            throw new UserException("创建商户失败");
        }
        return ResultVO.success();
    }

    @PostMapping("/updateMerchant")
    public ResultVO updateUser(@Validated({MerchantInfo.UpdateMerchant.class}) @RequestBody MerchantInfo merchantInfo) {
        Merchant merchant = new Merchant();
        BeanUtil.copyProperties(merchantInfo, merchant);
        if (merchantService.modifyByIdSelective(merchant) == 0) {
            throw new UserException("修改商户失败");
        }
        return ResultVO.success();
    }
}
