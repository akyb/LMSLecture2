package com.gcit.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.dao.AuthorDAO;
import com.gcit.domain.Author;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class LMSAuthorController {

	@Autowired
	AuthorDAO authorDao;
	@RequestMapping(value = "/bookstore/rest/tblAuthor/{authorId}", method = RequestMethod.GET)
	public Author getAuthor(@PathVariable(value = "authorId") int authorId) throws SQLException {
		Author author = authorDao.readOne(authorId);
		return author;
	}

	@RequestMapping(value = "/bookstore/rest/tblAuthor", method = RequestMethod.GET)
	public List<Author> getAuthors() throws SQLException {
		return authorDao.readAll();
	}

	@RequestMapping(value = "/bookstore/rest/tblAuthor/{authorId}", method = RequestMethod.DELETE)
	public void deleteAuthor(@PathVariable(value = "authorId") int authorId) throws SQLException {
		authorDao.delete(authorId);
	}

	@RequestMapping(value = "/bookstore/rest/tblAuthor", method = RequestMethod.PUT)
	public void updateAuthor(@RequestBody Author author, Locale locale, Model model) throws SQLException {
		authorDao.update(author);
	}

	@RequestMapping(value = "/bookstore/rest/tblAuthor", method = RequestMethod.POST)
	public void addAuthor(@RequestBody Author author, Locale locale, Model model) throws SQLException {
		authorDao.insert(author);
	}
}
