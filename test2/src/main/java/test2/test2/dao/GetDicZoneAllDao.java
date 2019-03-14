package test2.test2.dao;


import org.apache.ibatis.annotations.Mapper;
import test2.test2.entity.DicZoneAllEntity;

import java.util.List;
import java.util.Map;
@Mapper
public interface GetDicZoneAllDao {


    /**
     * @param map
     * @return
     */
    public List<DicZoneAllEntity> getDicZoneAllList(Map map);

    public List<DicZoneAllEntity> getDicZoneAllList_SENSOR1A(Map map);

    public List<DicZoneAllEntity> getDicZoneAllList_SENSOR2A(Map map);

}
