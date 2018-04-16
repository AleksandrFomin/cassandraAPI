package db.cassandra.controllers;

import db.cassandra.classes.AddFriend;
import db.cassandra.repositories.AddFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class AddFriendController {
    @Autowired
    AddFriendRepository addFriendRepository;

    @GetMapping("/findall")
    public List<AddFriend> findAll() {
        return addFriendRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<AddFriend> findById(@PathVariable Integer id) {
        return addFriendRepository.findByPersonId1(id);
    }

    @GetMapping("/findby2id/{id1}/{id2}")
    public AddFriend findBy2Id(@PathVariable Integer id1, @PathVariable Integer id2) {
        return addFriendRepository.findAddFriendByPersonId1AndPersonId2(id1, id2);
    }

}
