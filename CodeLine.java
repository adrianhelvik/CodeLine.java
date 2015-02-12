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
    private String indent =                     "    ";

    // Public setters
    public void setContent(String c)            { content = c; }

    // Private setters
    private void setPrev(CodeLine p)            { prev = p; }
    private void setNext(CodeLine n)            { next = n; }

    // Getters
    public String getContent()                  { return trimFront(content); }
    public CodeLine getPrev()                   { return prev; }
    public CodeLine getNext()                   { return next; }
    public CodeLine getFirst()                  { CodeLine cl = this; while (cl.getPrev() != null) cl = cl.getPrev(); return cl; }
 // public CodeLine getFirst()                  { if (getPrev != null) return getPrev.getFirst(); else return this; }
    public CodeLine getLast()                   { CodeLine cl = this; while (cl.getNext() != null) cl = cl.getNext(); return cl; }
 // public CodeLine getLast()                   { if (getNext() != null) return getPrev().getLast(); else return this; }
    public int getIndentLevel()                 { return (content.length() - trimFront(content).length()) / indent.length(); }

    // Constructors
    public CodeLine (String content)            { this(clean(content).split("\n")); }
    private CodeLine (String[] contents)        { setContent(contents[0]); addLines( Arrays.copyOfRange(contents, 1, contents.length) ); }
    private CodeLine ()                         { }

    // Public methods
    public void addLines(String[] lines)        { for (String l : lines) addLine(l); }
    public void addLine(String l)               { CodeLine last = getLast(), cl = new CodeLine(); cl.setContent(l); last.setNext(cl); cl.setPrev(last); }
    public String toString()                    { return content; }

    // Private methods
    private static String clean(String s)       { return s == null ? null : s.replaceAll("(^[\\n]|(\\n)([\\s]*)(?=\\n)|[\\n]$)", ""); }
    private static String trimFront(String s)   { return s == null ? null : s.replaceFirst("^[\\s]+", ""); }
}
