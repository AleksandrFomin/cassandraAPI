package db.cassandra.repositories;

import db.cassandra.classes.SubscribeGroup;
import db.cassandra.classes.UserLikeImage;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLikeImageRepository extends CassandraRepository<UserLikeImage,Integer> {
    List<UserLikeImage> findByUserId(Integer id);
    @Query("DELETE FROM userlikeimage WHERE userid = :id1 AND imageid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
