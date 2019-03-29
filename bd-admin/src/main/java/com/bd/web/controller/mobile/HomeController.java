package com.bd.web.controller.mobile;

import com.bd.common.core.controller.BaseController;
import com.bd.system.domain.SysNotice;
import com.bd.system.domain.SysUser;
import com.bd.system.service.IShopPositionService;
import com.bd.system.service.ISysNoticeService;
import com.bd.system.service.ISysUserService;
import com.google.common.collect.Lists;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luxuewei
 * @since 2019/3/25
 */
@Slf4j
@RestController
@RequestMapping("/mobile/home")
public class HomeController extends BaseController {
    @Resource
    private ISysNoticeService noticeService;
    @Resource
    private ISysUserService userService;

    /**
     * 本月主题公告
     * @return
     */
    @GetMapping("/homeinfos")
    public List<SysNotice> homeinfos(){
        SysNotice themes = noticeService.selectNoticeByTypeAndMonth(1);
        SysNotice annonce = noticeService.selectNoticeByTypeAndMonth(2);
        List<SysNotice> list = Lists.newArrayList();
        list.add(themes);
        list.add(annonce);
        return list ;
    }

    @GetMapping("/myinfos/{userId}")
    public SysUser myinfos(@PathVariable("userId") Long  userId){
        SysUser user = userService.selectUserById(userId);
        return user ;
    }
}
