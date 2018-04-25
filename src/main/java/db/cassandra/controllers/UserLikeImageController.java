package db.cassandra.controllers;

import db.cassandra.classes.SubscribeGroup;
import db.cassandra.classes.UserLikeImage;
import db.cassandra.repositories.SubscribeGroupRepository;
import db.cassandra.repositories.UserLikeImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/userlikeimage")
public class UserLikeImageController {
    @Autowired
    UserLikeImageRepository userLikeImageRepository;

    @GetMapping("/findall")
    public List<UserLikeImage> findAll() {
        return userLikeImageRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<UserLikeImage> findById(@PathVariable Integer id) {
        return userLikeImageRepository.findByUserId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userLikeImageRepository.save(new UserLikeImage(id1, id2, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        userLikeImageRepository.removeById(id1, id2);
    }
}
