package com.gxy.store.common.contorller;

import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.common.entity.StoreGoods;
import com.gxy.store.common.util.BeanUtil;
import com.gxy.store.common.qo.PurchaseDetailQuery;
import com.gxy.store.common.dto.StoreGoodsInfo;
import com.gxy.store.common.service.StoreGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/reduceInventory") //fixme 这里没有保证幂等性,可以添加动作唯一id进行避免
    public ResultVO reduceInventory(@Valid @RequestBody List<PurchaseDetailQuery> purchaseDetailQueryList) {
        storeGoodsService.reduceInventory(purchaseDetailQueryList);
        return ResultVO.success();
    }
}
