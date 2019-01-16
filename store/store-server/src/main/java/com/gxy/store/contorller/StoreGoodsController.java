package com.gxy.store.contorller;

import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.input.StoreGoodsInfo;
import com.gxy.store.entity.StoreGoods;
import com.gxy.store.service.StoreGoodsService;
import com.gxy.store.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoxingyong
 * @since 2019/1/16 16:34
 */
@RestController
@RequestMapping("/storeGoods")
public class StoreGoodsController {
    @Autowired
    private SnowFlakeIdGenerator snowFlakeIdGenerator;
    @Autowired
    private StoreGoodsService storeGoodsService;

    @PostMapping("/addStoreGoods")
    public ResultVO addStoreGoods(@RequestBody StoreGoodsInfo storeGoodsInfo) {
        StoreGoods storeGoods = new StoreGoods();
        BeanUtil.copyProperties(storeGoodsInfo, storeGoods);
        long storeGoodsId = snowFlakeIdGenerator.nextId();
        storeGoods.setGoodsId(storeGoodsId);
        if (storeGoodsService.add(storeGoods) > 0) {
            return ResultVO.success();
        }
        return ResultVO.failure("添加商品失败");
    }
}
