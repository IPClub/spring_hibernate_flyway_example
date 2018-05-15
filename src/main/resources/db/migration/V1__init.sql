CREATE TABLE app_user
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username TEXT NOT NULL
);

CREATE TABLE app_task
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title VARCHAR(50) NOT NULL,
  description TEXT,
  created_at DATETIME,
  severity VARCHAR(16),
  status VARCHAR(16),
  user_id int,
  FOREIGN KEY (user_id) REFERENCES app_user(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE app_comment
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  comment_text TEXT NOT NULL,
  task_id int,
  FOREIGN KEY (task_id) REFERENCES app_task(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE app_notification
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  message TEXT NOT NULL,
  user_id int,
  FOREIGN KEY (user_id) REFERENCES app_user(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
