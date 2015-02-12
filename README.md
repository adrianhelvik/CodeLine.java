# CodeLine.java
About CodeLine:
I wrote this class for compiling an indent based note taking language I am developing into html. To do this, I will need to know the indentation of the previous and next line. CodeLine makes this simple, as you have acess to the indentation level and the next, prev, first and last line of code.

Important note about the indentation method:
By default I have set indent = four spaces. This is not the best solution in every scenario, but as that's what I always use I decided to go with it.

How to use:
Construct a new CodeLine object with the code that you want processed as the argument. Use next, prev, first and last line of code.

About the coding style:
I created this in a slightly pedantic coding style, where I forced myself to keep every code block short enough to fit into a single line. Interesting challenge! Had to brush up on my regex and be as concise as possible.
