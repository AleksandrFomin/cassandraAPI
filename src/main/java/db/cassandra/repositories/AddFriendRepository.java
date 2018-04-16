package db.cassandra.repositories;

import db.cassandra.classes.AddFriend;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddFriendRepository extends CassandraRepository<AddFriend,Integer> {
    List<AddFriend> findByPersonId1(Integer id);
    AddFriend findAddFriendByPersonId1AndPersonId2(Integer id1, Integer id2);
}
