package ru.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.home.page.MainPage;

@Service
public class MainPageService {

    @Autowired
    private MainPage page;

//    @Autowired
//    private Environment environment;

    public void open() {
        page.open();
    }

    public String openPost(int index) {
        return page.openPost(index);
    }

    public void verify(String postTitle) {
        page.verify(postTitle);
    }
}
