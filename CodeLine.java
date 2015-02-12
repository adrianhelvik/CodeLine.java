import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Linked list for handling lines of code, disregards whitespace-only lines and can check indentation of lines
 */
public class CodeLine {

    // Private properties
    private String content;
    private CodeLine prev;
    private CodeLine next;
    private static String indent =              "    ";
    private static String whitespaceOnlyLines = "(^[\\n]|(\\n)([\\s]*)(?=\\n)|[\\n]$)";

    // Public setters
    public void setContent(String c)            { content = c; }

    // Private setters
    private void setPrev(CodeLine p)            { prev = p; }
    private void setNext(CodeLine n)            { next = n; }

    // Getters
    public String getContent()                  { return trimFront(content); }
    public CodeLine getPrev()                   { return prev; }
    public CodeLine getNext()                   { return next; }
    public CodeLine getFirst()                  { if (getPrev() != null) return getPrev().getFirst(); else return this; }
    public CodeLine getLast()                   { if (getNext() != null) return getNext().getLast(); else return this; }
    public int getIndentLevel()                 { return (content.length() - trimFront(content).length()) / indent.length(); }

    // Constructors
    public CodeLine (String content)            { this(clean(content).split("\n")); }
    private CodeLine (String[] contents)        { setContent(contents[0]); addLines( cdr(contents) ); }
    private CodeLine (String s, CodeLine n)     { setContent(s); setPrev(n); }
    private CodeLine ()                         { }

    // Public methods
    public void addLines(String[] lines)        { for (String l : lines) addLine(l); }
    public void addLine(String l)               { CodeLine cl = new CodeLine(l, getLast()); getLast().setNext(cl); }
    public String toString()                    { return content; }

    // Private methods
    private static String clean(String s)       { return s == null ? null : s.replaceAll(whitespaceOnlyLines, ""); }
    private static String trimFront(String s)   { return s == null ? null : s.replaceFirst("^[\\s]+", ""); }
    private static <T> T[] cdr(T[] array)       { return Arrays.copyOfRange(array, 1, array.length); }
}
