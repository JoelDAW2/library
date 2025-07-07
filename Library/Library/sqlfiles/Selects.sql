Select * from users;
Select * from books;
Select * from reviews order by book_id;

-- Select b.id,b.title from books b left join reviews r on b.id = r.book_id where not r.user_id = 1 order by b.id;

-- Select b.id,b.title from books b left join reviews r on b.id = r.book_id WHERE NOT EXISTS (SELECT *FROM books b WHERE b.id = r.book_id )order by b.id;

Select b.id,b.title from books b left join reviews r on b.id = r.book_id 
WHERE not r.user_id = 1 OR not EXISTS (
    SELECT *
    FROM books b 
    WHERE b.id = r.book_id 
)
order by b.id;
