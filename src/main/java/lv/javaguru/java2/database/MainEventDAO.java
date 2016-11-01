package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.MainEvent;

import java.util.List;

/**
 * Created by Mike on 11/1/2016.
 */
public interface MainEventDAO {

    void create (MainEvent mainEvent);

    MainEvent getById (Long id);

    void update (MainEvent mainEvent);

    List<MainEvent> getAll();
}
