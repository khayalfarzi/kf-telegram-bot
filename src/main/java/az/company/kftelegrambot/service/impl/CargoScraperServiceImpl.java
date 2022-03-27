package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.dao.repository.RedisConfModelRepository;
import az.company.kftelegrambot.service.CargoScraperService;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class CargoScraperServiceImpl implements CargoScraperService {

    private final RedisConfModelRepository repository;

    public CargoScraperServiceImpl(RedisConfModelRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    @Override
    public void test() {

        System.out.println(repository.findAll());
        String url = "https://www.mover.az/az/CalcPrice";

        String json = null;
        try {
            json =
             Jsoup.connect(url)
                    .get()
                    .html();

            System.out.println();
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
