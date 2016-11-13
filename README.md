## WORLD HISTORY TRACKER

> Kek


>

# SQL


``` sql
CREATE TABLE users (
    userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(50) NOT NULL,
    hashPassword VARCHAR(100) NOT NULL,
    encryptSalt VARCHAR(100) NOT NULL,
    regDate TIMESTAMP DEFAULT NOW()
);

CREATE TABLE userEvents (
    eventId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    eventName TEXT NOT NULL,
    createDate TIMESTAMP DEFAULT NOW(),
    longitude DOUBLE NOT NULL DEFAULT 0,
    latitude DOUBLE NOT NULL DEFAULT 0,
    userId INT NOT NULL,
    FOREIGN KEY (userId)
        REFERENCES users (userId)
);
alter table users add column accessToken varchar(150)
 unique default null;


INSERT INTO `historyTracker`.`users`
(`userName`,
`hashPassword`,
`encryptSalt`)
VALUES
('User1',
'hashPass',
'salt');
```
