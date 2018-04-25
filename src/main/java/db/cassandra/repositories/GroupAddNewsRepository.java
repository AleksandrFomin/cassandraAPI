package db.cassandra.repositories;

import db.cassandra.classes.GroupAddImage;
import db.cassandra.classes.GroupAddNews;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAddNewsRepository extends CassandraRepository<GroupAddNews,Integer> {
    List<GroupAddNews> findByGroupId(Integer id);
    @Query("DELETE FROM groupaddnews WHERE groupid = :id1 AND newsid = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
