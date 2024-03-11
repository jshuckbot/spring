package ru.gb.lesson_4.repository;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_4.models.Cat;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class CatRepository {
    private List<Cat> cats = new ArrayList<>();

}