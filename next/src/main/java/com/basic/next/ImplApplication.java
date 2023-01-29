package com.basic.next;

import com.basic.next.dao.SiteDao;
import com.basic.next.dto.Site;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ImplApplication implements ApplicationRunner {

    @Autowired
    SiteDao dao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, Object> param = new HashMap<>();
        Site site = dao.getSite(param);

        log.info("site :{}", site);
        log.error("site :{}", site);
        log.debug("site :{}", site);
    }
}
