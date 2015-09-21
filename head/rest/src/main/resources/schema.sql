CREATE TABLE departments (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(128)
);

CREATE TABLE employees (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  deptId     INT NOT NULL,
  name       VARCHAR(128),
  patronymic VARCHAR(128),
  surname    VARCHAR(128),
  birth      DATE,
  salary     INT,
  FOREIGN KEY (deptId) REFERENCES departments (id)
);

CREATE VIEW avgSalary AS SELECT departments.name, AVG(salary) AS salary FROM departments, employees WHERE departments.id = employees.deptId  GROUP BY deptId;