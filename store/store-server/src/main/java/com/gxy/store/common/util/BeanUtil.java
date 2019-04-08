package com.gxy.store.common.util;

import com.gxy.store.common.dto.StoreDTO;
import com.gxy.store.common.entity.StoreGoods;
import com.gxy.store.common.vo.StoreGoodsInfoVO;
import com.gxy.store.common.vo.StoreInfoVO;
import com.gxy.store.common.entity.Store;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author guoxingyong
 * @since 2019/1/16 15:18
 */
public final class BeanUtil extends BeanUtils {

    /**
     * @param store not null store entity
     * @return StoreInfoOutput
     */
    public static StoreInfoVO createStoreInfoVO(Store store) {
        if (store == null) {
            return null;
        }
        StoreInfoVO storeInfoVO = new StoreInfoVO();
        copyProperties(store, storeInfoVO);
        return storeInfoVO;
    }

    /**
     * @param storeDTO not null store entity
     * @return StoreInfoOutput
     */
    public static StoreInfoVO createStoreInfoVO(StoreDTO storeDTO) {
        if (storeDTO == null) {
            return null;
        }
        StoreInfoVO storeInfoVO = new StoreInfoVO();
        copyProperties(storeDTO, storeInfoVO);
        List<StoreGoodsInfoVO> storeInfoOutPut = createStoreInfoVO(storeDTO.getStoreGoodsList());
        storeInfoVO.setStoreGoodsInfoVOS(storeInfoOutPut);
        return storeInfoVO;
    }

    /**
     * @param storeGoods not null a StoreGoods entity
     * @return StoreGoodsInfoOutput
     */
    public static StoreGoodsInfoVO createStoreInfoVO(StoreGoods storeGoods) {
        if (storeGoods == null) {
            return null;
        }
        StoreGoodsInfoVO storeGoodsInfoVO = new StoreGoodsInfoVO();
        copyProperties(storeGoods, storeGoodsInfoVO);
        return storeGoodsInfoVO;
    }


    /**
     * @param storeGoodsList StoreGoods entity list
     * @return StoreGoodsInfoOutput collection
     */
    public static List<StoreGoodsInfoVO> createStoreInfoVO(List<StoreGoods> storeGoodsList) {
        if (storeGoodsList == null) {
            return null;
        }
        return storeGoodsList.stream()
                .filter(Objects::nonNull)
                .map(BeanUtil::createStoreInfoVO)
                .collect(Collectors.toList());
    }
}
