package com.soybean.uaa.service.impl;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.useragent.Browser;
import cn.hutool.http.useragent.OS;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.soybean.framework.db.mybatis.SuperServiceImpl;
import com.soybean.uaa.domain.entity.log.LoginLog;
import com.soybean.uaa.repository.LoginLogMapper;
import com.soybean.uaa.service.LoginLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 业务实现类
 * 系统日志
 * </p>
 *
 * @author wenxina
 * @since 2019-10-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl extends SuperServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    private static final String USER_AGENT = "User-Agent";
    private final HttpServletRequest request;

    @Override
    public LoginLog saveLoginLog(Long userId, String principal, String realName) {
        String ip = ServletUtil.getClientIP(request);
        final String clientId = request.getParameter("client_id");
        String ua = request.getHeader(USER_AGENT);
        final UserAgent userAgent = UserAgentUtil.parse(ua);
        final Browser browser = userAgent.getBrowser();
        final OS os = userAgent.getOs();
        LoginLog loginLog = LoginLog.builder()
                .userId(userId)
                .principal(principal).ip(ip)
                .platform(userAgent.getPlatform().getName())
                .engine(userAgent.getEngine().getName())
                .engineVersion(userAgent.getEngineVersion())
                .browser(browser.getName())
                .browserVersion(browser.getVersion(ua))
                .os(os.getName())
                .clientId(clientId).name(realName)
                .build();
        super.save(loginLog);
        return loginLog;
    }
}
