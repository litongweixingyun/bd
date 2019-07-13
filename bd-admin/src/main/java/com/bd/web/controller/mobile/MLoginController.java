package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.common.core.domain.AjaxResult;
import com.bd.common.exception.GlobalException;
import com.bd.common.utils.UUIDUtil;
import com.bd.framework.shiro.service.SysPasswordService;
import com.bd.system.domain.SysUser;
import com.bd.system.service.ISysUserService;
import com.bd.system.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author luxuewei
 * @since 2019/3/19
 */
@Slf4j
@RestController
@RequestMapping("/mobile/sys")
public class MLoginController extends BaseController {

    @Resource
    private ISysUserService userService;
    @Resource
    private SysPasswordService passwordService;

    @PostMapping("/login")
    public AjaxResult login(LoginVO vo){
        if(vo == null) {
            throw new GlobalException("参数异常");
        }
        log.info("vo="+vo);
        String mobile = vo.getPhone();
        String password = vo.getPass();

        SysUser user = userService.selectUserByPhoneNumber(mobile);
        if(user == null) {
            throw new GlobalException("手机号不存在");
        }
        passwordService.validate(user, password);

        String uuid = UUIDUtil.uuid();
        user.setToken(uuid);
        userService.updateUserInfo(user);

        return success().put("token",uuid);
    }


}
