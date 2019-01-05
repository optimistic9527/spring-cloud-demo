package com.gxy.store.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.store.mapper.StoreMapper;

@Service
public class StoreService{

    @Resource
    private StoreMapper storeMapper;

}
