package test2.test2.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration  // applicationContext.xml
public class RedisConfig {

    @Value("${spring.redis.cluster.nodes}")
    private  String clusterNodes;
    private int connectionTimeout = 60000;
    private int soTimeout = 60000;
    private int maxAttempts = 6;
//    private String pass2 = "passw0rd2";
    @Value("${spring.redis.password}")
    private String pass2;

    @Bean
    public JedisCluster getJedisCluster(){

        System.out.println("clusterNodes-----"+clusterNodes);

        // 分集群节点
        String[] cNodes = clusterNodes.split(",");
        Set<HostAndPort> nodesPort = new HashSet<HostAndPort>();
        for( String nodes : cNodes ){
            String[] hp = nodes.split(":");
            nodesPort.add(new HostAndPort(hp[0],Integer.parseInt(hp[1])));
        }
//        JedisCluster jedisCluster = new JedisCluster(nodesPort,connectionTimeout,soTimeout,maxAttempts,pass2,jedisPoolConfig);
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(100);
        config.setMinIdle(0);//设置最小空闲数
        config.setMaxWaitMillis(2000);
        //在获取Jedis连接时，自动检验连接是否可用
        config.setTestOnBorrow(true);
        //在将连接放回池中前，自动检验连接是否有效
        config.setTestOnReturn(true);
        //自动测试池中的空闲连接是否都是可用连接
        config.setTestWhileIdle(true);
        //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时,默认true
        config.setBlockWhenExhausted(false);
        //表示idle object evitor两次扫描之间要sleep的毫秒数
        config.setTimeBetweenEvictionRunsMillis(30000);
        //表示idle object evitor每次扫描的最多的对象数
        config.setNumTestsPerEvictionRun(10);
        //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
        config.setMinEvictableIdleTimeMillis(60000);
        //需要密码连接的创建对象方式
        //参数依次是：集群地址，链接超时时间，返回值的超时时间，链接尝试次数，密码和配置文件
        JedisCluster jedisCluster = new JedisCluster(nodesPort,connectionTimeout,soTimeout,maxAttempts,pass2,config);
        return jedisCluster;
    }
}
