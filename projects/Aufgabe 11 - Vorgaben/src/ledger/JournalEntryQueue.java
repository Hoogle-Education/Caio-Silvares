package ledger;

import exceptions.InvalidJournalEntryException;

import java.util.LinkedList;
import java.util.Queue;

public class JournalEntryQueue {

    private  Queue<String> buffer;
    private Integer maxNumberOfRecords;

    public JournalEntryQueue(int maxNumberOfRecords) {
        buffer = new LinkedList<>();
        this.maxNumberOfRecords = maxNumberOfRecords;
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public void add(String entry)  {
        if(buffer.size() < maxNumberOfRecords)
            buffer.add(entry);
    }

    public String getNext()  {
        if(buffer.isEmpty())
            return "";

        return buffer.poll();
    }

}
