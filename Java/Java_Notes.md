# Java Notes

* Java is a compiled language

## Primitive Data Types

* byte
  * Byte.MIN_VALUE = -128
  * Byte.MAX_VALUE = 127
  * Size: 8 bits (1 byte)
* short
  * Short.MIN_VALUE = -32768
  * Short.MAX_VALUE = 32767
  * Size: 16 bits (2 bytes)
* int
  * Integer.MIN_VALUE = -2147483648
  * Integer.MAX_VALUE = 2147483647
  * Size: 32 bits (4 bytes)
* long
  * Long.MIN_VALUE = -9223372036854775808
  * Long.MAX_VALUE = 9223372036854775807
  * Size: 64 bits (8 bytes)
  
* float
  * Float.MIN_VALUE = 1.4E-45
  * Float.MAX_VALUE = 3.4028235E38
* double
  * Double.MIN_VALUE = 4.9E-324
  * Double.MAX_VALUE = 1.7976931348623157E308

* char
  * Can be set to either the character, the unicode value or an integer value
* boolean

## Wrapper Classes

* byte -> Byte
* short -> Short
* int -> Integer
* long -> Long
* float -> Float
* double -> Double
* char -> Character
* boolean -> Boolean

## String

* Strings are immutable
* Getting a char at a specific index: `string.charAt(int index)`
* Getting the length of a string: `string.length()`
* Multiline strings: `String multiline = """This is a multiline string"""`
* `\n` is used for a new line
* `\t` is used for a tab
* `\[unicode value]` is used for a specific character
* Format specifiers: `%s` for strings, `%d` for integers, `%f` for floats, `%c` for characters, `%b` for booleans
* `.[number]f` is used to specify the number of decimal places for a float. eg. `%.2f` will round to 2 decimal places

## Printing to the Console

* `System.out.println("Hello World");`
* `System.out.print("Hello World");`

## Scanning for Input

* `import java.util.Scanner;` imports the Scanner class
* `Scanner scanner = new Scanner(System.in);`
* When done using the scanner it needs to be closed: `scanner.close();`

## Foreach Loop

* `for (int number : numbers) { ... }`

## Arrays

### Creating Arrays

* `int[] numbers = new int[5];`
* `int[] numbers = {1, 2, 3, 4, 5};`

### Array to String

* Import the Arrays class: `import java.util.Arrays;`
* `Arrays.toString(array)`

### Multidimensional Arrays

* `int[][] numbers = new int[2][3];`
* `int[][] numbers = {{1, 2, 3}, {4, 5, 6}};`
* `int[][] numbers = new int[2][];`
* `numbers[0] = new int[3];`
* `numbers[1] = new int[2];`
* `numbers[0][0] = 1;`
* `numbers[0][1] = 2;`