package test2.test2.service;


import test2.test2.entity.DicZoneAllEntity;

import java.util.List;
import java.util.Map;

public interface GetDicZoneAllService {


    public List<DicZoneAllEntity> getDicZoneAllList(Map map);
    public void redisTest();
    public List<DicZoneAllEntity> getDicZoneAllList_SENSOR1A(Map map);
    public List<DicZoneAllEntity> getDicZoneAllList_SENSOR2A(Map map);
}
