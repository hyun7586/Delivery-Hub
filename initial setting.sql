CREATE TABLE `User` (
	`user_id`	bigint	NOT NULL,
	`name`	varchar(50)	NULL,
	`role`	varchar(50)	NULL,
	`email`	varchar(50)	NULL,
	`password`	varchar(16)	NULL,
	`created_at`	datetime	NULL,
	`updated_at`	datetime	NULL
);

CREATE TABLE `Restaurant` (
	`restaurant_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`name`	varchar(50)	NULL,
	`location`	varchar(50)	NULL,
	`created_at`	datetime	NULL,
	`updated_at`	datetime	NULL
);

CREATE TABLE `Order` (
	`order_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`restaurant_id`	bigint	NOT NULL,
	`status`	varchar(50)	NULL,
	`total_price`	int	NULL,
	`created_at`	datetime	NULL,
	`updated_at`	datetime	NULL,
	`location`	varchar(50)	NULL
);

CREATE TABLE `OrderItem` (
	`item_id`	bigint	NOT NULL,
	`order_id`	bigint	NOT NULL,
	`menu_id`	bigint	NOT NULL,
	`quantity`	int	NULL,
	`price`	int	NULL
);

CREATE TABLE `Menu` (
	`menu_id`	bigint	NOT NULL,
	`restaurant_id`	bigint	NOT NULL,
	`name`	varchar(50)	NULL,
	`description`	varchar(255)	NULL,
	`price`	int	NULL,
	`created_at`	datetime	NULL,
	`updated_at`	datetime	NULL
);

CREATE TABLE `Review` (
	`review_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`restaurant_id`	bigint	NOT NULL,
	`title`	varchar(50)	NULL,
	`content`	text	NULL,
	`rate`	int	NULL
);

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `Restaurant` ADD CONSTRAINT `PK_RESTAURANT` PRIMARY KEY (
	`restaurant_id`
);

ALTER TABLE `Order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`order_id`
);

ALTER TABLE `OrderItem` ADD CONSTRAINT `PK_ORDERITEM` PRIMARY KEY (
	`item_id`
);

ALTER TABLE `Menu` ADD CONSTRAINT `PK_MENU` PRIMARY KEY (
	`menu_id`
);

ALTER TABLE `Review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`review_id`
);

