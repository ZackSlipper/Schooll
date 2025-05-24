# HTML Notes

## Base File

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width initial-scale=1">
		<title>[Page Title]</title>
		<link rel="stylesheet" href="styles/style.css">
	</head>
	<body>
	</body>
</html>
```

## Elements

### Images

```html
<img src="[Image Path]" alt="[Image Description]" title="[Title]">
```

### Links

```html
<a href="[Link Path]">[Link Text]</a>
```

#### Linking to an Email Address

```html
<a href="mailto:[Email Address]">[Email Address]</a>
```

#### Link to a Specific Part of a Page

```html
<a href="#[ID]">[Link Text]</a>
```

### Scrolling Content

```html
<marquee>[Content]</marquee>
```

### Lists

#### Unordered List

```html
<ul>
	<li>[List Item]</li>
</ul>
```

#### Ordered List

```html
<ol type="[Type]" start="[Start Number]" reversed>
	<li>[List Item]</li>
</ol>
```

### Text

#### Bold

```html
<b>[Text]</b>
```

#### Italic (Avoid)

```html
<i>[Text]</i>
```

#### Emphasized

```html
<em>[Text]</em>
```

#### Underline

```html
<u>[Text]</u>
```

#### Strikethrough (Don't Use)

```html
<strike>[Text]</strike>
```

#### Superscript

```html
<sup>[Text]</sup>
```

#### Subscript

```html
<sub>[Text]</sub>
```

#### Small

```html
<small>[Text]</small>
```

#### Marked

```html
<mark>[Text]</mark>
```

#### Deleted

```html
<del>[Text]</del>
```

#### Inserted

```html
<ins>[Text]</ins>
```

#### Strong

```html
<strong>[Text]</strong>
```

#### Code

```html
<code>[Text]</code>
```

#### Preformatted

* Keeps the text in the same format as it is written

```html
<pre>[Text]</pre>
```

#### Blockquote

```html
<blockquote cite="[URL]">[Text]</blockquote>
```

#### Cite

```html
<q cite="[URL]">[Text]</q>
```

#### Address

```html
<address>[Text]</address>
```

#### Abbreviation

```html
<abbr title="[Title]">[Text]</abbr>
```

#### Definition

```html
<dfn title="[Title]">[Text]</dfn>
```

#### Terms and Definitions

```html
<dl>
	<dt>[Term]</dt>
	<dd>[Definition]</dd>
</dl>
```

#### Time

```html
<time datetime="[YYYY-MM-DD]">[Text]</time>
```

#### Variable

```html
<var>[Text]</var>
```

#### Keyboard Input

```html
<kbd>[Text]</kbd>
```

#### Sample Output

```html
<samp>[Text]</samp>
```

#### Output

```html
<output>[Text]</output>
```

#### Progress

```html
<progress value="[Value]" max="[Max Value]">[Text]</progress>
```

#### Meter

```html
<meter value="[Value]" min="[Min Value]" max="[Max Value]">[Text]</meter>
```

#### Details

* Used to create a disclosure widget in which information is visible only when the widget is toggled open

```html
<details>
	<summary>[Summary]</summary>
	[Details]
</details>
```

### Tables

* Avoid using tables for layout purposes

```html
<table>
	<caption>[Caption]</caption>
	<tr>
		<th>[Header]</th>
		<th>[Header_2]</th>
		<th>[Header_3]</th>
	</tr>
	<tr>
		<td rowspan="2">[Data]</td> <!-- Spans two rows -->
		<td>[Data_2]</td>
		<td>[Data_3]</td>
	</tr>
	<tr>
		<!-- <td>[Data]</td> -->
		<td colspan="2">[Data_2]</td>
		<!-- <td>[Data_3]</td> -->
	</tr>
</table>
```

### Div and Span

* Div: Block-level element
* Span: Inline element

```html
<div>[Content]</div>
<span>[Content]</span>
```

### Forms

* Forms are used to collect user input
* Form attributes:
  * name: Name of the form
  * action: URL to which the form data is sent
  * method: HTTP method used to send the form data
	* get: Appends form data to the URL
	* post: Sends form data in the body of the request

```html
<form action="[URL]" method="[Method]">
	<fieldset>
		<legend>[Legend]</legend>
		<label for="[ID]">[Label]</label>
		<input type="[Type]" id="[ID]" name="[Name]" value="[Value]" placeholder="[Placeholder]" required>
		<textarea id="[ID]" name="[Name]" placeholder="[Placeholder]" required></textarea>
		<select id="[ID]" name="[Name]" required>
			<option value="[Value]">[Option]</option>
		</select>
		<input type="submit" value="[Submit]">
		<input type="reset" value="[Reset]">
	</fieldset>
</form>
```

## Semantic Elements

### BDI

* Isolates a part of text that might be formatted in a different direction from other text outside it

```html
<p>My favorite number is <bdi>123456789</bdi>.</p>
```

### Figure and Figcaption

* Figure: Represents self-contained content

```html
<figure>
	<img src="[Image Path]" alt="[Image Description]">
	<figcaption>[Caption]</figcaption>
</figure>
```

## Pseudo-Elements and Pseudo-Classes

### Pseudo-Elements

* Used to style specified parts of an element

```css
p::first-line {
	font-weight: bold;
}
```

```css
p::first-letter {
	font-size: 200%;
}
```

```css
p::before {
	content: "Hello";
}
```

```css
p::after {
	content: "World";
}
```

```css
p::selection {
	background-color: yellow;
}
```

```css
p::placeholder {
	color: red;
}
```

```css
p::marker {
	color: blue;
}
```

```css
p::spelling-error {
	color: red;
}
```

```css
p::grammar-error {
	color: red;
}
```

### Pseudo-Classes

* Used to define the special state of an element

```css
a:visited {
	color: purple;
}
```

```css
a:hover {
	color: red;
}
```

```css
a:active {
	color: blue;
}
```

```css
a:focus {
	color: green;
}
```

```css
a:link {
	color: blue;
}
```

```css
a:target {
	color: orange;
}
```

```css
a:lang(en) {
	color: black;
}
```

```css
input:enabled {
	background-color: white;
}
```

```css
input:disabled {
	background-color: gray;
}
```

```css
input:checked {
	background-color: yellow;
}
```

```css
input:indeterminate {
	background-color: orange;
}
```

```css
input:required {
	background-color: red;
}
```

```css
input:optional {
	background-color: green;
}
```

```css
input:valid {
	background-color: blue;
}
```

```css
input:invalid {
	background-color: pink;
}
```

```css
input:in-range {
	background-color: purple;
}
```

```css
input:out-of-range {
	background-color: brown;
}
```

```css
input:read-only {
	background-color: black;
}
```

```css
input:read-write {
	background-color: white;
}
```

```css
input:default {
	background-color: gray;
}
```

```css
input:root {
	background-color: yellow;
}
```

```css
input:empty {
	background-color: orange;
}
```

```css
input:nth-child(2) {
	background-color: red;
}
```

```css
input:nth-last-child(2) {
	background-color: blue;
}
```

```css
input:nth-of-type(2) {
	background-color: green;
}
```

```css
input:nth-last-of-type(2) {
	background-color: yellow;
}
```

```css
input:first-child {
	background-color: purple;
}
```

```css
input:last-child {
	background-color: brown;
}
```

```css
input:first-of-type {
	background-color: pink;
}
```

```css
input:last-of-type {
	background-color: black;
}
```

```css
input:only-child {
	background-color: white;
}
```

```css
input:only-of-type {
	background-color: gray;
}
```

```css
input:target {
	background-color: orange;
}
```

```css
input:lang(en) {
	background-color: yellow;
}
```

```css
input:not([type="submit"]) {
	background-color: red;
}
```

## CSS Selectors

### ID Selector

```css
#id {
	property: value;
}
```

### Class Selector

```css
.class {
	property: value;
}

### Universal Selector

```css
* {
	property: value;
}
```

### Element Selector

```css
element {
	property: value;
}
```

### Group Selector

```css
selector1, selector2 {
	property: value;
}
```

### Descendant Selector

```css
selector1 selector2 {
	property: value;
}
```

### Child Selector

```css
selector1 > selector2 {
	property: value;
}
```

### Adjacent Sibling Selector

```css
selector1 + selector2 {
	property: value;
}
```

### General Sibling Selector

```css
selector1 ~ selector2 {
	property: value;
}
```

### Attribute Selector

```css
[attribute="value"] {
	property: value;
}
```

### Pseudo-Class Selector

```css
selector:pseudo-class {
	property: value;
}
```

### Pseudo-Element Selector

```css
selector::pseudo-element {
	property: value;
}
```

## CSS Inherited Properties

* color
* font-family
* font-size

## CSS Units

* Absolute Units
  * cm: Centimeters
  * mm: Millimeters
  * in: Inches
  * px: Pixels
  * pt: Points
  * pc: Picas

* Relative Units
  * em: Relative to the font-size of the element
  * ex: Relative to the x-height of the font
  * ch: Relative to the width of the "0" (zero)
  * rem: Relative to the font-size of the root element
  * vw: Relative to 1% of the width of the viewport
  * vh: Relative to 1% of the height of the viewport
  * vmin: Relative to 1% of the viewport's smaller dimension
  * vmax: Relative to 1% of the viewport's larger dimension
  * %: Relative to the parent element
  
* Angle Units
  * deg: Degrees
  * grad: Gradients
  * rad: Radians
  * turn: Turns

## Positioning

### Static

```html
<div style="position: static;">[Content]</div>
```

### Absolute

```html
<div style="position: absolute;">[Content]</div>
```

### Relative

```html
<div style="position: absolute">
	<div style="position: relative;">[Content]</div>
</div>
```

### Fixed

```html
<div style="position: fixed;">[Content]</div>
```

### Sticky

```html
<div style="position: sticky;">[Content]</div>
```

## Overflow

### Visible

```html
<div style="overflow: visible;">[Content]</div>
```

### Hidden

```html
<div style="overflow: hidden;">[Content]</div>
```

### Scroll

```html
<div style="overflow: scroll;">[Content]</div>
```

### Auto

```html
<div style="overflow: auto;">[Content]</div>
```

## Grid

### Container

```css
display: grid;
```

### Columns

```css
grid-template-columns: 100px 100px 100px;
grid-template-columns: 1fr 1fr 1fr;
grid-template-columns: repeat(3, 1fr);
grid-template-columns: auto auto auto;
grid-template-columns: auto-fit;
grid-template-columns: auto-fill;
grid-template-columns: minmax(100px, auto);
grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
```

### Rows

```css
grid-template-rows: 100px 100px 100px;
grid-template-rows: 1fr 1fr 1fr;
...
grid-auto-rows: 100px; /* Sets the height of the rows that are not explicitly defined */
```

### Gaps

```css
column-gap: 10px;
row-gap: 15px;
gap: 15px 10px;
```

### Items

```css
grid-column: 1 / 3; /* Span two columns */
grid-row: 1 / 3; /* Span two rows */
grid-area: 1 / 1 / 3 / 3; /* Span two rows and two columns */
grid-column-start: 1; /* Start at the first column */
grid-column-end: 3; /* End at the third column */
```

#### Naming Grid Areas

```css
grid-template-areas:
	"header header header"
	"main main sidebar"
	"footer footer footer";
```

```css
grid-area: header;
grid-area: main;
grid-area: sidebar;
grid-area: footer;
```
