package db.cassandra.repositories;

import db.cassandra.classes.UserLikeNews;
import db.cassandra.classes.UserRepostNews;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepostNewsRepository extends CassandraRepository<UserRepostNews,Integer> {
    List<UserRepostNews> findByUserId(Integer id);
    @Query("DELETE FROM userrepostnews WHERE userid = :id1 AND newsid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
