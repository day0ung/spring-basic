package com.basic.next.dao;

import com.basic.next.dto.Site;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

@Mapper
public interface SiteDao {

    public Site getSite(Map<String, Object> param);
}
