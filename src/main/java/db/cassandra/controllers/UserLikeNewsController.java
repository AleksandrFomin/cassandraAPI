package db.cassandra.controllers;

import db.cassandra.classes.UserLikeImage;
import db.cassandra.classes.UserLikeNews;
import db.cassandra.repositories.UserLikeImageRepository;
import db.cassandra.repositories.UserLikeNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/userlikenews")
public class UserLikeNewsController {
    @Autowired
    UserLikeNewsRepository userLikeNewsRepository;

    @GetMapping("/findall")
    public List<UserLikeNews> findAll() {
        return userLikeNewsRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<UserLikeNews> findById(@PathVariable Integer id) {
        return userLikeNewsRepository.findByUserId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userLikeNewsRepository.save(new UserLikeNews(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        userLikeNewsRepository.removeById(id1, id2);
    }
}
