package pl.coderslab.springhibernate.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.springhibernate.dao.PublisherDao;
import pl.coderslab.springhibernate.model.Publisher;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String s) {
        Long id = Long.parseLong(s);
        return publisherDao.findById(id);
    }
}
