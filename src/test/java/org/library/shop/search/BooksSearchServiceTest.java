package org.library.shop.search;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class BooksSearchServiceTest {

    private BooksSearchService booksSearchService = new BooksSearchService();

    @Test
    public void should_return_empty_if_no_criteria() {
        Assertions.assertThat(booksSearchService.search(new BooksCriteria()).get()).isEmpty();
    }

    @Test
    public void should_search_by_title() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setName("le petit prince");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(1);
    }
    @Test
    public void should_find_by_case_insensitive_title() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setName("le peTit Prince");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(1);
    }

    @Test
    public void should_find_by_title_if_contains_criteria() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setName("la");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(2);
    }

    @Test
    public void should_search_by_author() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setAuthor("stiegler");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(2);
    }

    @Test
    public void should_find_by_insensitive_author() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setAuthor("stiEgleR");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(2);
    }
    @Test
    public void should_find_by_complete_author_name() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setAuthor("joshua bloch");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(1);
    }

    @Test
    public void should_find_by_incomplete_author_name() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setAuthor("josh bloc");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(1);
    }

    @Test
    public void should_find_by_isbn() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setIsbn("620");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(1);
    }

    @Test
    public void should_be_cumulative_criterias() {
        BooksCriteria criteria = new BooksCriteria();
        criteria.setIsbn("53");
        criteria.setName("dans");
        criteria.setAuthor("Stiegler");
        Assertions.assertThat(booksSearchService.search(criteria).get()).hasSize(1);
    }

}