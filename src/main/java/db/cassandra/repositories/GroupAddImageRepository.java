package db.cassandra.repositories;

import db.cassandra.classes.AddFriend;
import db.cassandra.classes.GroupAddImage;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAddImageRepository extends CassandraRepository<GroupAddImage,Integer> {
    List<GroupAddImage> findByGroupId(Integer id);
    @Query("DELETE FROM groupaddimage WHERE groupid = :id1 AND imageid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
