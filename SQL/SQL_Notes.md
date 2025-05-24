# SQL Notes

## SQL Basics

### Basic Info

- SQL stands for Structured Query Language
- All tables are stored in a database
- Tables must have names
- `PRIMARY KEY` - a unique identifier for each row in a table
- `FOREIGN KEY` - a key that links two tables together
- `CRUD`- Create, Read, Update, Delete
- Keywords should be written in uppercase
- Names of tables and columns should be written in lowercase

### SQL Syntax

- SQL is not case sensitive
- SQL statements end in a semicolon `;`
- SQL keywords are case-insensitive
- SQL comments are two hyphens `--` or `/* */`
- SQL is whitespace insensitive

### SQL Data Types

- Numeric
  - INT([size])
  - FLOAT([size], [decimals])
  - BIGINT, SMALLINT, TINYINT, DECIMAL, NUMERIC
  - REAL
  - BIT, BOOLEAN
  - SERIAL
  - MONEY, SMALLMONEY
  - DEC
  - FIXED
  - FLOAT4, FLOAT8
  - INT2, INT4, INT8, INTEGER, MIDDLEINT
- Date and Time
  - DATE, TIME
  - DATETIME([fsp]) - YYYY-MM-DD HH:MM:SS
  - TIMESTAMP([fsp])
- String
  - VARCHAR([size]) - most common
  - CHAR([size]) - rarely used
  - TEXT([size]) - used for large text (books, articles)
  - BINARY, VARBINARY, BLOB
- Other
  - ENUM, SET, JSON
- NULL
  - NULL
- Special
  - AUTO_INCREMENT

### SQL Operators

- Arithmetic Operators
  - `+`, `-`, `*`, `/`, `%`
- Comparison Operators
  - `=`, `!=`, `>`, `<`, `>=`, `<=`
- Logical Operators
  - `AND`, `OR`, `NOT`
- Bitwise Operators
  - `&`, `|`, `^`, `~`, `<<`, `>>`
- Assignment Operators
  - `=`, `+=`, `-=`, `*=`, `/=`, `%=`
- Other Operators
  - `LIKE`, `IN`, `BETWEEN`, `IS NULL`, `IS NOT NULL`
- Concatenation Operator
  - `||`

### SQL Functions

- String Functions
  - `CONCAT()`, `LENGTH()`, `LOWER()`, `UPPER()`, `SUBSTRING()`, `REPLACE()`, `REVERSE()`, `TRIM()`, `CHAR_LENGTH()`, `CHARACTER_LENGTH()`, `LEFT()`, `RIGHT()`
  - `LOCATE()`, `POSITION()`, `INSTR()`, `LPAD()`, `RPAD()`, `REPEAT()`, `SPACE()`, `ASCII()`, `CHR()`, `SOUNDEX()`, `DIFFERENCE()`
  - `INSERT()`, `ELT()`, `FIELD()`, `FIND_IN_SET()`, `MAKE_SET()`, `EXPORT_SET()`, `QUOTE()`, `QUOTENAME()`, `FORMAT()`
  - `CONCAT_WS()`, `GROUP_CONCAT()`
  - `REGEXP_LIKE()`, `REGEXP_REPLACE()`, `REGEXP_INSTR()`, `REGEXP_SUBSTR()`
  - `REGEXP()`, `REGEXP_INSTR()`, `REGEXP_SUBSTR()`, `REGEXP_REPLACE()`
- `NOW()` - returns the current date and time (timestamp)

### Creating A Database

```sql
CREATE DATABASE database_name;
```

### Dropping A Database

```sql
DROP DATABASE database_name;
```

### Using A Database

```sql
USE database_name;
```

### Creating A Table

```sql
CREATE TABLE table_name (
	column0_name column0_data_type AUTO_INCREMENT PRIMARY KEY,
	column1_name column1_data_type,
	column2_name column2_data_type,
	...
);
```

### Dropping A Table

```sql
DROP TABLE table_name;
```

### Renaming A Table

```sql
ALTER TABLE table_name
RENAME TO new_table_name;
```

### Adding A Column

```sql
ALTER TABLE table_name
ADD column_name column_data_type;
```

### Dropping A Column

```sql
ALTER TABLE table_name
DROP COLUMN column_name;
```

### Renaming A Column

```sql
ALTER TABLE table_name
CHANGE COLUMN old_column_name new_column_name column_data_type;
```

### Changing Column Data Type

```sql
ALTER TABLE table_name
MODIFY COLUMN column_name new_column_data_type;
```

### Deleting All Data In A Table (Truncating)

```sql
TRUNCATE TABLE table_name;
```

### Inserting Data

```sql
INSERT INTO table_name (column1_name, column2_name, ...)
VALUES (value1, value2, ...);
```

Or

```sql
INSERT INTO table_name
VALUES (value1, value2, ...), (value1, value2, ...), ...;
```

### Selecting Data

```sql
SELECT column1_name, column2_name, ...
FROM table_name
WHERE condition;
```

### Updating Data

```sql
UPDATE table_name
SET column1_name = value1, column2_name = value2, ...
WHERE condition;
```

### Deleting Data

```sql
DELETE FROM table_name
WHERE condition;
```
