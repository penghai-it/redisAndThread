package it.ph.com.redistest.service;

/**
 * @author PH
 * @时间： 2022/11/7
 * @描述：
 */
public interface TestService {
    /**
     * redis分组测试
     **/
    void groupingTest();

    /**
     * 更具key获取value(有分组)
     **/
    Object getGroupingData();

    /**
     * 更具key删除value(有分组)
     **/
    Object deleteData(String key);
}
