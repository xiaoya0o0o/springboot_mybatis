package test2.test2.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import test2.test2.dao.GetDicZoneAllDao;
import test2.test2.entity.DicZoneAllEntity;
import test2.test2.service.GetDicZoneAllService;

import java.util.List;
import java.util.Map;

@Service
public class GetDicZoneAllServiceImpl implements GetDicZoneAllService {

    @Autowired
    private GetDicZoneAllDao getDicZoneAllDao;

    @Autowired
    private JedisCluster jedisCluster;

    @Cacheable(value = "getDicZoneAllList")
    public List<DicZoneAllEntity> getDicZoneAllList(Map map) {
        System.out.println("是否走redis缓存");
        List<DicZoneAllEntity> list = getDicZoneAllDao.getDicZoneAllList(map);

        return list;
    }

    @Override
    public void redisTest(){
        jedisCluster.set("test123","abc");
        String test123 = jedisCluster.get("test123");

        System.out.println("---redis---"+test123);
    }

}
