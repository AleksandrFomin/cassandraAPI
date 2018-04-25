package db.cassandra.controllers;

import db.cassandra.classes.UserLikeNews;
import db.cassandra.classes.UserRepostNews;
import db.cassandra.repositories.UserLikeNewsRepository;
import db.cassandra.repositories.UserRepostNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/userrepostnews")
public class UserRepostNewsController {
    @Autowired
    UserRepostNewsRepository userRepostNewsRepository;

    @GetMapping("/findall")
    public List<UserRepostNews> findAll() {
        return userRepostNewsRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<UserRepostNews> findById(@PathVariable Integer id) {
        return userRepostNewsRepository.findByUserId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userRepostNewsRepository.save(new UserRepostNews(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        userRepostNewsRepository.removeById(id1, id2);
    }
}
