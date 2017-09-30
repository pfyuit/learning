package com.pfyuit.myjavaee.service.admin;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.pfyuit.myjavaee.dao.cache.couchbase.CouchbaseDao;
import com.pfyuit.myjavaee.dao.cache.memcached.MemcachedDao;
import com.pfyuit.myjavaee.dao.cache.redis.RedisDao;
import com.pfyuit.myjavaee.dao.database.cassandra.UsersDao;
import com.pfyuit.myjavaee.dao.database.hbase.HBaseDao;
import com.pfyuit.myjavaee.dao.database.mongodb.MongoDbDao;
import com.pfyuit.myjavaee.dao.database.mybatis.ApplyMapper;
import com.pfyuit.myjavaee.dao.distribute.zookeeper.ZooKeeperDao;
import com.pfyuit.myjavaee.dao.messaging.activemq.MessageProducerService;
import com.pfyuit.myjavaee.dao.messaging.kafka.KafkaDao;
import com.pfyuit.myjavaee.dao.search.elastic.ElasticSearchDao;
import com.pfyuit.myjavaee.dao.search.solr.SolrDao;
import com.pfyuit.myjavaee.model.database.mongodb.Task;
import com.pfyuit.myjavaee.model.database.mybatis.Apply;
import com.pfyuit.myjavaee.model.messaging.activemq.Notify;
import com.pfyuit.myjavaee.model.search.elastic.User;
import com.pfyuit.myjavaee.util.BeanUtil;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private HBaseDao hbaseDao;

    @Autowired
    private MongoDbDao mongoDbDao;

//    @Autowired
//    private UsersDao usersDao;

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private MemcachedDao memcachedDao;

//    @Autowired
//    private CouchbaseDao couchbaseDao;

    @Autowired
    private RedisDao redisDao;

//    @Autowired
//    private ElasticSearchDao searchDao;

//    @Autowired
//    private MessageProducerService messageProducer;

    @Autowired
    private ZooKeeperDao zookeeperDao;

    @Autowired
    private KafkaDao kafkaDao;

    @Autowired
    private SolrDao solrDao;

    @Override
    public void check() throws Exception {
        //Check database
        checkHbase();
        checkMongoDb();
        checkCassandra();
        checkMySQL();

        //Check cache
        checkMemcached();
        checkCouchbase();
        checkRedis();

        //Check search
        checkElastic();
        checkSolr();

        //Check message
        checkActiveMQ();
        checkKafka();

        //Check distributed
        checkZookeeper();
    }

    private void checkHbase() throws IOException {
        hbaseDao.put("test", "1", "d", "name", "tom");
        hbaseDao.put("test", "2", "d", "age", "20");
        System.out.println(hbaseDao.get("test", "1", "d", "name"));
    }

    private void checkMongoDb() {
//        DB db = mongoDbDao.getDB();
//        System.out.println(db.toString());
//
//        if (mongoDbDao.isCollectionExists("Boy")) {
//            return;
//        }
//        DBCollection collection = mongoDbDao.createCollection("Boy");
//        System.out.println(collection.toString());
//
//        if (mongoDbDao.isCollectionExists(Task.class)) {
//            return;
//        }
//        collection = mongoDbDao.createCollection(Task.class);
//        System.out.println(collection.toString());
//
//        boolean result = mongoDbDao.isCollectionExists("Boy");
//        System.out.println(result);
//
//        result = mongoDbDao.isCollectionExists(Task.class);
//        System.out.println(result);
//
//        Set<String> collections = mongoDbDao.getCollections();
//        System.out.println(collections);
//
//        Task task = new Task();
//        task.setName("pfyuit");
//        task.setAge(20);
//        mongoDbDao.save(task);
//
//        List<Task> tasks = mongoDbDao.findAll(Task.class);
//        for (Task taska : tasks) {
//            System.out.println(taska.getName() + ":" + taska.getAge());
//        }

    }

    private void checkCassandra() {
//        usersDao.createKeySpace();
//        usersDao.createTable();
//        usersDao.save();
//        usersDao.update();
//        usersDao.find();
        // usersDao.delete();
    }

    private void checkMySQL() {
        Apply model = new Apply();
        model.setActivityId(1);
        model.setApplyTime(new Timestamp(new Date().getTime()));
        model.setLastModify(new Timestamp(new Date().getTime()));
        model.setOwnerId(1);
        model.setOwnerName("tom");
        model.setStatus("start");
        applyMapper.save(model);

        model = applyMapper.findById(36);
        applyMapper.delete(model);

        model = applyMapper.findById(36);
        model.setStatus("finished");
        model.setLastModify(new Timestamp(new Date().getTime()));
        applyMapper.update(model);

        model = applyMapper.findById(36);
        BeanUtil.printModel(model);

        List<Apply> models = applyMapper.findByOwnerId(10);

        models = applyMapper.findByActivityId(8);
    }

    private void checkMemcached() {
        memcachedDao.check();

        memcachedDao.set("key1", "value1");
        memcachedDao.set("key2", "value2");
        memcachedDao.set("anexamplekey", "value2");

        memcachedDao.get("key1");
        memcachedDao.get("key2");
        memcachedDao.get("anexamplekey");

        memcachedDao.delete("key1");
        memcachedDao.delete("key2");
        memcachedDao.delete("anexamplekey");
    }

    private void checkCouchbase() {
//        couchbaseDao.insert("key1", "value1");
//        couchbaseDao.get("key1");
    }

    private void checkRedis() {
        redisDao.stringSet("key1", "value1");
        redisDao.stringGet("key1");

        redisDao.listListInsert("key2", "value1");
        redisDao.listListInsert("key2", "value2");

        redisDao.listGetAll("key2");
        redisDao.listDelete("key2", 0, "value1");
    }

    private void checkElastic() {
//        User model = new User();
//        model.setUserId("10001");
//        model.setUserName("Andrew");
//        model.setUserFavorite("Aireplane");
//        searchDao.indexUser("10001", model);
//
//        model = new User();
//        model.setUserId("10001");
//        model.setUserName("Andrew");
//        model.setUserFavorite("Software");
//        searchDao.upsertUser("10001", model);
    }

    private void checkSolr() throws IOException, SolrServerException {
//        List<Integer> blogIds = solrDao.searchBlog("mysql");
    }

    private void checkActiveMQ() {
//        Notify notify = new Notify();
//        notify.setNotifyId("N100001");
//        notify.setNotifyMsg("This is a test message from Jms");
//        messageProducer.sendMessage(notify);
    }

    private void checkKafka() {
//        for (int i = 0; i < 100; i++) {
//            kafkaDao.sendMessage("mykey", "myvalue" + i);
//        }
    }

    private void checkZookeeper() throws KeeperException, InterruptedException {
        if (zookeeperDao.exists("/test", false)) {
            zookeeperDao.delete("/test/child1", -1);
            zookeeperDao.delete("/test/child2", -1);
            zookeeperDao.delete("/test/child3", -1);
            zookeeperDao.delete("/test", -1);
        }
        zookeeperDao.create("/test", "testdata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zookeeperDao.create("/test/child1", "child1data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zookeeperDao.create("/test/child2", "child2data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zookeeperDao.create("/test/child3", "child3data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zookeeperDao.setData("/test/child1", "child1data_update".getBytes(), -1);
        byte[] bytes = zookeeperDao.getData("/test/child1", false, null);
        System.out.println(new String(bytes));
    }

}
