package test2.test2.dao;


import org.apache.ibatis.annotations.Mapper;
import test2.test2.entity.DicZoneAllEntity;

import java.util.List;
import java.util.Map;
@Mapper
public interface GetDicZoneAllDao {


    public List<DicZoneAllEntity> getDicZoneAllList(Map map);


}
