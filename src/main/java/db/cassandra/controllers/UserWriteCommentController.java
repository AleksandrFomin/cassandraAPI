package db.cassandra.controllers;

import db.cassandra.classes.UserRepostNews;
import db.cassandra.classes.UserWriteComment;
import db.cassandra.repositories.UserRepostNewsRepository;
import db.cassandra.repositories.UserWriteCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/userwritecomment")
public class UserWriteCommentController {
    @Autowired
    UserWriteCommentRepository userWriteCommentRepository;

    @GetMapping("/findall")
    public List<UserWriteComment> findAll() {
        return userWriteCommentRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public List<UserWriteComment> findById(@PathVariable Integer id) {
        return userWriteCommentRepository.findByUserId(id);
    }

    @GetMapping("/add/{id1}/{id2}/{id3}/{actionDate}")
    public void addFriend(@PathVariable Integer id1,
                          @PathVariable Integer id2,
                          @PathVariable Integer id3,
                          @PathVariable String actionDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userWriteCommentRepository.save(new UserWriteComment(id1, id2, id3, format.parse(actionDate)));
    }

    @GetMapping("/removebyid/{id1}/{id2}")
    public void removeFriend(@PathVariable Integer id1,
                             @PathVariable Integer id2){
        userWriteCommentRepository.removeById(id1, id2);
    }
}
