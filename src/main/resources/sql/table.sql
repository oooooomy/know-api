CREATE TABLE `t_article`
(
    `id`            varchar(50) NOT NULL,
    `uid`           varchar(50) NOT NULL,
    `title`         varchar(50) NOT NULL,
    `has_poster`    tinyint     NOT NULL,
    `type`          varchar(50) NOT NULL,
    `poster`        varchar(50) DEFAULT NULL,
    `content`       text        NOT NULL,
    `agree_count`   int         NOT NULL,
    `create_at`     varchar(50) NOT NULL,
    `comment_count` int         NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment`
(
    `id`        varchar(50) NOT NULL,
    `uid`       varchar(50) NOT NULL,
    `aid`       varchar(50) NOT NULL,
    `content`   text        NOT NULL,
    `create_at` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_image`
(
    `id`   varchar(50) NOT NULL,
    `data` longblob    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user`
(
    `id`        varchar(50) NOT NULL,
    `nickname`  varchar(20) NOT NULL,
    `phone`     varchar(11) NOT NULL,
    `password`  varchar(20) NOT NULL,
    `avatar`    varchar(50) NOT NULL,
    `school`    varchar(50) NOT NULL,
    `create_at` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_video`
(
    `id`        varchar(50) NOT NULL,
    `uid`       varchar(50) NOT NULL,
    `fid`       varchar(50) NOT NULL,
    `type`      varchar(20) NOT NULL,
    `title`     varchar(50) NOT NULL,
    `create_at` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;