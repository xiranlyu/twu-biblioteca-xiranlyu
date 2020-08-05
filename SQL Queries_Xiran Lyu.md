### Q1 Who checked out the book 'The Hobbit’?
```
SELECT member.name FROM member WHERE member.id = (SELECT checkout_item.member_id FROM checkout_item, book WHERE book.id = checkout_item.book_id AND book.title = 'The Hobbit');
```
> Answer: Anand Beck


### Q2 How many people have not checked out anything?
```
SELECT  a.a-b.b FROM
(SELECT COUNT(*) a FROM member) a,
(SELECT COUNT(DISTINCT member_id) b FROM checkout_item) b;
```
> Answer: 37


### Q3 What books and movies aren't checked out?
```
SELECT book.title FROM  book
     WHERE book.id not in (SELECT checkout_item.book_id FROM checkout_item WHERE book.id = checkout_item.book_id);

SELECT movie.title FROM  movie
     WHERE movie.id not in (SELECT checkout_item.movie_id FROM checkout_item WHERE movie.id = checkout_item.movie_id);
```
> Answer: <br>

> BOOKS: <br>
Fellowship of the Ring<br>
1984<br>
Tom Sawyer<br>
Catcher in the Rye<br>
To Kill a Mockingbird<br>
Domain Driven Design<br>

> MOVIES: <br>
Thin Red Line<br>
Crouching Tiger, Hidden Dragon <br>
Lawrence of Arabia<br>
Office Space<br>

### Q4 Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database.
```
INSERT INTO book (title) VALUES ('The Pragmatic Programmer');
INSERT INTO member (name) VALUES ('Xiran Lyu');
INSERT INTO checkout_item (member_id, book_id) VALUES ( (SELECT member.id FROM member WHERE member.name = "Xiran Lyu"), (SELECT book.id FROM book WHERE book.title = "The Pragmatic Programmer"));
SELECT member.name FROM member WHERE member.id = (SELECT checkout_item.member_id FROM checkout_item, book WHERE book.id = checkout_item.book_id AND book.title = 'The Pragmatic Programmer');
```

### Q5 Who has checked out more than 1 item? Tip: Research the GROUP BY syntax.
```
SELECT member.name FROM member WHERE member.id in (SELECT checkout_item.member_id FROM checkout_item GROUP BY checkout_item.member_id HAVING COUNT(checkout_item.member_id) > 1);
```
> Answer: Anand Beck, Frank Smith
