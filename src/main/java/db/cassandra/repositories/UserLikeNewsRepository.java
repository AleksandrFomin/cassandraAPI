package db.cassandra.repositories;

import db.cassandra.classes.UserLikeImage;
import db.cassandra.classes.UserLikeNews;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLikeNewsRepository extends CassandraRepository<UserLikeNews,Integer> {
    List<UserLikeNews> findByUserId(Integer id);
    @Query("DELETE FROM userlikenews WHERE userid = :id1 AND newsid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
