package pl.coderslab.springhibernate.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.springhibernate.dao.AuthorDao;
import pl.coderslab.springhibernate.model.Author;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String id) {
        return authorDao.findById(Long.parseLong(id));
    }
}
