package db.cassandra.repositories;

import db.cassandra.classes.UserRepostNews;
import db.cassandra.classes.UserWriteComment;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWriteCommentRepository extends CassandraRepository<UserWriteComment,Integer> {
    List<UserWriteComment> findByUserId(Integer id);
    @Query("DELETE FROM userwritecomment WHERE userid = :id1 AND commentid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
