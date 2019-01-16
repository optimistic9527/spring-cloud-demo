package com.gxy.store.util;

import com.gxy.store.dto.output.StoreGoodsInfoOutput;
import com.gxy.store.dto.output.StoreInfoOutput;
import com.gxy.store.entity.Store;
import com.gxy.store.entity.StoreGoods;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author guoxingyong
 * @since 2019/1/16 15:18
 */
public abstract class BeanUtil extends BeanUtils {

    /**
     * @param store not null store entity
     * @return StoreInfoOutput
     */
    public static StoreInfoOutput createStoreInfoOutput(Store store) {
        if (store == null) {
            return null;
        }
        StoreInfoOutput storeInfoOutput = new StoreInfoOutput();
        copyProperties(store, storeInfoOutput);
        return storeInfoOutput;
    }

    /**
     * @param storeGoods not null a StoreGoods entity
     * @return StoreGoodsInfoOutput
     */
    public static StoreGoodsInfoOutput createStoreInfoOutPut(StoreGoods storeGoods) {
        if (storeGoods == null) {
            return null;
        }
        StoreGoodsInfoOutput storeGoodsInfoOutput = new StoreGoodsInfoOutput();
        copyProperties(storeGoods, storeGoodsInfoOutput);
        return storeGoodsInfoOutput;
    }


    /**
     * @param storeGoodsList StoreGoods entity list
     * @return StoreGoodsInfoOutput collection
     */
    public static List<StoreGoodsInfoOutput> createStoreInfoOutPut(List<StoreGoods> storeGoodsList) {
        if (storeGoodsList == null) {
            return null;
        }
        return storeGoodsList.stream()
                .filter(Objects::nonNull)
                .map(BeanUtil::createStoreInfoOutPut)
                .collect(Collectors.toList());
    }
}
