package com.xxxr.core.boot.service;

import com.xxxr.core.boot.pojo.vo.InvestVO;
import com.xxxr.core.boot.pojo.entity.LendItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的出借记录表 服务类
 * </p>
 *
 * @author Jiangw
 * @since 2021-03-31
 */
public interface LendItemService extends IService<LendItem> {

    List<LendItem> selectByLendId(Long lendId, Integer status);

    List<LendItem> selectByLendId(Long lendId);

    String commitInvest(InvestVO investVO);

    void notify(Map<String, Object> paramMap);
}
