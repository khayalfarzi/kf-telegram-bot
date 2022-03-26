package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.dao.entity.RedisConfModel;
import az.company.kftelegrambot.dao.repository.RedisConfModelRepository;
import az.company.kftelegrambot.service.CargoScraperService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
public class CargoScraperServiceImpl implements CargoScraperService {

    private final RedisConfModelRepository repository;

    public CargoScraperServiceImpl(RedisConfModelRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    @Override
    public void test() {

        repository.save(new RedisConfModel(1L, LocalDateTime.now(), LocalDateTime.now()));

//        String url = "https://findex.az/plans";
//
//        String json = null;
//        try {
////            json =
//             Jsoup.connect(url)
//                    .get()
//                    .select("div[class=\"styled__PlansColumnGrid-sc-5j6jxd-5 wfjdT\"]")
//                    .forEach(element -> {
//                        element.select("");
//                    });
////                    .html();
//
////            System.out.println();
////            System.out.println(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
