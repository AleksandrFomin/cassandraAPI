package db.cassandra.repositories;

import db.cassandra.classes.AddFriend;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddFriendRepository extends CassandraRepository<AddFriend,Integer> {
    List<AddFriend> findByPersonId1(Integer id);
    @Query("DELETE FROM addfriend WHERE personid1 = :id1 AND personid2 = :id2")
    void removeById(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
