package com.soybean.uaa.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soybean.framework.db.configuration.dynamic.annotation.TenantDS;
import com.soybean.framework.db.mybatis.SuperMapper;
import com.soybean.framework.db.mybatis.auth.DataScope;
import com.soybean.framework.db.mybatis.conditions.query.LbqWrapper;
import com.soybean.uaa.domain.entity.baseinfo.User;
import com.soybean.uaa.domain.vo.UserResp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wenxina
 */
@TenantDS
@Repository
public interface UserMapper extends SuperMapper<User> {


    /**
     * 分页查询用户
     *
     * @param page    page
     * @param wrapper wrapper
     * @return 查询结果
     */
    IPage<UserResp> findPage(IPage<User> page, LbqWrapper<User> wrapper);

    /**
     * 带数据权限用户列表
     *
     * @param dataScope dataScopeAspectJExpressionPointcut
     * @return 用户
     */
    List<User> list(DataScope dataScope);
}
