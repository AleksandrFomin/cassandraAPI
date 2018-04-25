package db.cassandra.repositories;

import db.cassandra.classes.GroupAddNews;
import db.cassandra.classes.GroupAddVideo;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAddVideoRepository extends CassandraRepository<GroupAddVideo,Integer> {
    List<GroupAddVideo> findByGroupId(Integer id);
    @Query("DELETE FROM groupaddvideo WHERE groupid = :id1 AND videoid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
