package com.yunspace.helloxml.db;

import com.yunspace.helloxml.core.Pirate;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PirateDAO extends AbstractDAO<Pirate> {
    public PirateDAO(SessionFactory factory) {
        super(factory);
    }

    public Pirate create(Pirate pirate) {
        return persist(pirate);
    }


    public Optional<Pirate> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public List<Pirate> findAll() {
        return list(namedQuery("com.yunspace.helloxml.core.Pirate.findAll"));
    }

    public void update (Pirate pirate) {

        this.currentSession().update(Pirate.class.getName(), pirate);
    }

    public void delete(Pirate pirate) {
        this.currentSession().delete(Pirate.class.getName(), pirate);
    }


}
