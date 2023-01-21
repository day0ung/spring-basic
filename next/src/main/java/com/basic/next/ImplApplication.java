package com.basic.next;

import com.basic.next.dao.SiteDao;
import com.basic.next.dto.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ImplApplication implements ApplicationRunner {

    @Autowired
    SiteDao dao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, Object> param = new HashMap<>();
        Site site = dao.getSite(param);
        System.out.println(site);
    }
}
