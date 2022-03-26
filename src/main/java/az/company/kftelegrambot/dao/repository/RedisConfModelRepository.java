package az.company.kftelegrambot.dao.repository;

import az.company.kftelegrambot.dao.entity.RedisConfModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisConfModelRepository extends CrudRepository<RedisConfModel, Long> {
}