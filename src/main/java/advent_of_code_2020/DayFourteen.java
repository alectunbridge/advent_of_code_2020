package advent_of_code_2020;

import com.google.common.cache.AbstractCache;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFourteen {

    private String mask;
    private Map<Long,Long> memory;

    public DayFourteen(String input) {
        memory = new HashMap<>();
        if ("mem".equals(input.substring(0,3))){
            parseMemInstruction(input);
        } else {
            this.mask = input.substring(7);
        }
    }

    private void parseMemInstruction(String memInstruction) {
        Pattern pattern = Pattern.compile("mem\\[(\\d*)\\] = (\\d*)");
        Matcher matcher = pattern.matcher(memInstruction);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Can't parse mem instruction: " + memInstruction);
        }
        memory.put(Long.parseLong(matcher.group(1)),Long.parseLong(matcher.group(2)));
    }

    public String getMask() {
        return mask;
    }

    public long getLocation(long address) {
        return memory.get(address);
    }
}
