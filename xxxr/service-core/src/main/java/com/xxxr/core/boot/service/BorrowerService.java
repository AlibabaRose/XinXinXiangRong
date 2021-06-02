package com.xxxr.core.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxr.core.boot.pojo.entity.Borrower;
import com.xxxr.core.boot.pojo.vo.BorrowerVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxr.core.boot.pojo.vo.BorrowerApprovalVO;
import com.xxxr.core.boot.pojo.vo.BorrowerDetailVO;

/**
 * <p>
 * 借款人 服务类
 * </p>
 *
 * @author Jiangw
 * @since 2021-03-31
 */
public interface BorrowerService extends IService<Borrower> {

    void saveBorrowerVOByUserId(BorrowerVO borrowerVO, Long userId);

    Integer getStatusByUserId(Long userId);

    IPage<Borrower> listPage(Page<Borrower> pageParam, String keyword);

    BorrowerDetailVO getBorrowerDetailVOById(Long id);

    void approval(BorrowerApprovalVO borrowerApprovalVO);
}
