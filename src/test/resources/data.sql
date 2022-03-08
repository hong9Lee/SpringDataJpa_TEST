-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'martin', 'martin@fastcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'martin2', 'martin2@fastcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'martin3', 'martin3@fastcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'martin4', 'martin4@fastcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'martin', 'martin5@fastcampus.com', now(), now());

insert into publisher(`id`, `name`) values ( 1, '패스트캠퍼스' );
insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values ( 1, 'JPA 초격차 패키지', 1, false , 100);
insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values ( 2, 'Spring Security 패키지', 1, false , 200);
insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values ( 3, 'cloud 패키지', 1, true , 100);

insert into review(`id`, `title`, `content`, `score`, `user_id`, `book_id`) values ( 1, '내 인생을 바꾼 책', '너무너무 좋았어요', 5.0, 1, 1 );
insert into review(`id`, `title`, `content`, `score`, `user_id`, `book_id`) values ( 2, '너무 진도가 빨라요', '벼로', 3.0, 2, 2 );

insert into comment(`id`, `comment`, `review_id`) values ( 1, '저도 좋았어요', 1 );
insert into comment(`id`, `comment`, `review_id`) values ( 2, '저는 별로였는데', 1 );
insert into comment(`id`, `comment`, `review_id`) values ( 3, '그냥 그럼', 2 );
