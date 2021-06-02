package com.xxxr.core.boot.service;

import com.xxxr.core.boot.pojo.entity.BorrowInfo;
import com.xxxr.core.boot.pojo.entity.Lend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxr.core.boot.pojo.vo.BorrowInfoApprovalVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的准备表 服务类
 * </p>
 *
 * @author Jiangw
 * @since 2021-03-31
 */
public interface LendService extends IService<Lend> {

    void createLend(BorrowInfoApprovalVO borrowInfoApprovalVO, BorrowInfo borrowInfo);

    List<Lend> selectList();

    Map<String, Object> getLendDetail(Long id);

    BigDecimal getInterestCount(BigDecimal invest, BigDecimal yearRate, Integer totalmonth, Integer returnMethod);

    void makeLoan(Long id);

}
