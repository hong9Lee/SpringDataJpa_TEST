# Study-SpringDataJPA
인터넷 강의를 통해 ORM(SpringDataJpa) 학습
- 연관관계에 따른 도메인 생성, JPA Query, Test Code를 통한 CRUD 테스트 

## 1. 연관관계 매핑 학습 
![erd](https://user-images.githubusercontent.com/94272140/178130079-0909c4ac-0025-4132-9ac0-1edf7490eca6.png)

```
@NoArgsConstructor
@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Where(clause = "deleted = false")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    ...

    @OneToOne(mappedBy = "book")
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Review> reviwes = new ArrayList<>();

    @ManyToOne(cascade = { CascadeType.ALL })
    private Publisher publisher;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    public void addBookAndAuthors(BookAndAuthor... bookAndAuthors) {
        Collections.addAll(this.bookAndAuthors, bookAndAuthors);
    }
    ...
}    
```

## 2. query method, jpql, native query를 통한 쿼리생성 학습
```
List<Book> findByCategoryNull();
List<Book> findAllByDeletedFalse();
List<Book> findByCategoryIsNullAndDeletedFalse();

@Query(value = "select b from Book b " +
         "where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
List<Book> findByNameRecently(@Param("name") String name,
                              @Param("createdAt") LocalDateTime createdAt,
                              @Param("updatedAt") LocalDateTime updatedAt);

@Query(value = "select new com.data.jpa.datajpa.repository.dto.BookNameAndCategory(b.name, b.category) from Book b")
List<BookNameAndCategory> findBookNameAndCategory();

@Query(value = "select * from book order by id desc limit 1", nativeQuery = true)
Map<String, Object> findRawRecord();

...
```

## 3. Test Code를 통한 CRUD 테스트
```
private Book givenBook() { // Book 생성
  Book book = new Book();
  book.setName("Jpa 초격차 패키지");
  book.setAuthorId(1L);

  return bookRepository.save(book);
}

private void givenBookReviewInfo() { // 리뷰 생성
  BookReviewInfo bookReviewInfo = new BookReviewInfo();
  bookReviewInfo.setBook(givenBook());
  bookReviewInfo.setAverageReviewScore(4.5f);
  bookReviewInfo.setReviewCount(2);

  bookReviewInfoRepository.save(bookReviewInfo);
}

@Test
void crueTest() {
  givenBook();
  givenBookReviewInfo();

  // 저장한 Book 정보 Select
  Book result =
      bookReviewInfoRepository
      .findById(1L)
      .orElseThrow(RuntimeException::new)
      .getBook();

System.out.println("book = " + result);
        
    // 저장한 리뷰 정보 Select    
    BookReviewInfo result2 = bookRepository
      .findById(1L)
      .orElseThrow(RuntimeException::new)
      .getBookReviewInfo();

System.out.println("result2 = " + result2);
}
...
```

