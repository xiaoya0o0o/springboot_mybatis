package test2.test2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test2.test2.entity.DicZoneAllEntity;
import test2.test2.service.GetDicZoneAllService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Controller
// @RequestMapping(value = "/diczone")

@RestController
public class GetDicZoneAllController {

    @Autowired
    private GetDicZoneAllService getDicZoneAllService;

    @RequestMapping(value = "/getlist")
    public List<DicZoneAllEntity> getList() {
        Map map = new HashMap();
        List<DicZoneAllEntity> list = getDicZoneAllService.getDicZoneAllList(map);
        return list;
    }

    @RequestMapping(value = "/getredis")
    public void redisTest(){
        getDicZoneAllService.redisTest();
    }

    @RequestMapping(value = "/getlist1")
    public List<DicZoneAllEntity> getList1() {
        Map map = new HashMap();
        List<DicZoneAllEntity> list = getDicZoneAllService.getDicZoneAllList_SENSOR1A(map);
        return list;
    }

    @RequestMapping(value = "/getlist2")
    public List<DicZoneAllEntity> getList2() {
        Map map = new HashMap();
        List<DicZoneAllEntity> list = getDicZoneAllService.getDicZoneAllList_SENSOR2A(map);
        return list;
    }
}
