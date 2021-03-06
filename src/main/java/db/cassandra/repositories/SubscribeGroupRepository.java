package db.cassandra.repositories;

import db.cassandra.classes.GroupAddVideo;
import db.cassandra.classes.SubscribeGroup;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribeGroupRepository extends CassandraRepository<SubscribeGroup,Integer> {
    List<SubscribeGroup> findByUserId(Integer id);
    @Query("DELETE FROM subscribegroup WHERE userid = :id1 AND groupid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
