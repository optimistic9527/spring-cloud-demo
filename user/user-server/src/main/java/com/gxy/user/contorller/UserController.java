package com.gxy.user.contorller;

import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.vo.ResultVO;
import com.gxy.dto.UserInfoInput;
import com.gxy.user.config.SnowFlakeIdGeneratorConfig;
import com.gxy.user.entity.User;
import com.gxy.user.exception.UserException;
import com.gxy.user.service.UserService;
import com.gxy.user.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.gxy.user.utils.BeanUtils.createUserInfoOutput;

/**
 * @author guoxingyong
 * @since 2019/1/3 20:57
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SnowFlakeIdGenerator snowFlakeIdGenerator;
    @Resource
    private UserService userService;

    @GetMapping("/{userId}")
    public ResultVO acquireUserInfo(@PathVariable("userId") String userId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new UserException(ResultCodeEnum.USER_NOT_EXIST);
        }
        return ResultVO.success(createUserInfoOutput(user));
    }

    @PostMapping("/addUser")
    public ResultVO addUser(@Valid @RequestBody UserInfoInput userInfoInput){
        //todo 沒有校驗唯一性,为了方便所以业务在这里写了，正式需要移动到Service中，其他同
        User user=new User();
        BeanUtils.copyProperties(userInfoInput,user);
        long id = snowFlakeIdGenerator.nextId();
        user.setUserId(id);
        user.setMoney(0);
        user.setActive(1);
        user.setFreezeMoney(0);
        if(userService.add(user)==0){
            throw new UserException("创建用户失败");
        }
        return ResultVO.success();
    }
}