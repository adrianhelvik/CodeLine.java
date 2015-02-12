import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * FIFO & LIFO linked list for lines of code, disregards whitespace-only lines and can check indentation of lines
 */
public class CodeLine {

    // Private properties
    private String content;
    private CodeLine previous;
    private CodeLine next;
    private String indent =                     "    ";

    // Public setters
    public void setContent(String c)            { content = c; }

    // Private setters
    private void setPrevious(CodeLine p)        { previous = p; }
    private void setNext(CodeLine n)            { next = n; }

    // Getters
    public String getContent()                  { return trimFront(content); }
    public CodeLine getPrevious()               { return previous; }
    public CodeLine getNext()                   { return next; }
    public CodeLine getFirst()                  { CodeLine cl = this; while (cl.getPrevious() != null) cl = cl.getPrevious(); return cl; }
    public CodeLine getLast()                   { CodeLine cl = this; while (cl.getNext() != null) cl = cl.getNext(); return cl; }
    public int getIndentLevel()                 { return (content.length() - trimFront(content).length()) / indent.length(); }

    // Constructors
    public CodeLine (String content)            { this(content.split("\n"); }
    private CodeLine (String[] contents)        { this(contents[0]); addLines( Arrays.copyOfRange(contents, 1, contents.length) ); }

    // Public methods
    public void addLines(String[] lines)        { for (String l : lines) addLine(l); }
    public void addLine(String line)            { CodeLine last = getLast(), cl = new CodeLine(line); last.setNext(cl); cl.setPrevious(last); }

    // Private methods
    private String removeEmptyLines(String s)   { return s == null ? null : s.replaceAll("(^[\\n]|(\\n)([\\s]*)(?=\\n)|[\\n]$)", ""); }
    private String trimFront(String original)   { return original == null ? null : original.replaceFirst("^[\\s]+", ""); }
}
