package ru.guteam.cookstarter.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.guteam.cookstarter.orderservice.model.Order;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCustomerId(@NotNull Long id);

    List<Order> findAllByRestaurantId(@NotNull Long id);
}
