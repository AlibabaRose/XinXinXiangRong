package com.xxxr.core.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxr.core.boot.pojo.entity.UserInfo;
import com.xxxr.core.boot.pojo.vo.RegisterVO;
import com.xxxr.core.boot.pojo.vo.UserIndexVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxr.core.boot.pojo.query.UserInfoQuery;
import com.xxxr.core.boot.pojo.vo.LoginVO;
import com.xxxr.core.boot.pojo.vo.UserInfoVO;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author Jiangw
 * @since 2021-03-31
 */
public interface UserInfoService extends IService<UserInfo> {

    void register(RegisterVO registerVO);

    UserInfoVO login(LoginVO loginVO, String ip);

    boolean checkMobile(String mobile);

    IPage<UserInfo> listPage(Page<UserInfo> pageParam, UserInfoQuery userInfoQuery);

    void lock(Long id, Integer status);

    UserIndexVO getIndexUserInfo(Long userId);
}
