package db.cassandra.controllers;

import db.cassandra.classes.AddFriend;
import db.cassandra.repositories.AddFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        addFriendRepository.save(new AddFriend(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        addFriendRepository.removeById(id1, id2);
    }
}
