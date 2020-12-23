package advent_of_code_2020;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFourteen {

    private char[] mask;
    private Map<Long,Long> memory;

    public DayFourteen(String... input) {
        memory = new HashMap<>();
        mask = new char[36];
        Arrays.fill(mask,'X');
        for (String line : input) {
            if ("mem".equals(line.substring(0, 3))) {
                executeMemInstruction(line);
            } else {
                this.mask = line.substring(7).toCharArray();
            }
        }
    }

    private void executeMemInstruction(String memInstruction) {
        Pattern pattern = Pattern.compile("mem\\[(\\d*)] = (\\d*)");
        Matcher matcher = pattern.matcher(memInstruction);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Can't parse mem instruction: " + memInstruction);
        }
        long bitmaskedValue = applyMask(Long.parseLong(matcher.group(2)));
        memory.put(Long.parseLong(matcher.group(1)),bitmaskedValue);
    }

    private long applyMask(long value) {
        char[] paddedValueAsBits = String.format("%36s", Long.toBinaryString(value))
                .replace(' ', '0').toCharArray();

        for (int i = 0, charArrayLength = mask.length; i < charArrayLength; i++) {
            char maskBit = mask[i];
            if ('X' == maskBit) {
                continue;
            }
            paddedValueAsBits[i] = mask[i];
        }
        return Long.parseUnsignedLong(String.valueOf(paddedValueAsBits),2);
    }

    public String getMask() {
        return String.valueOf(mask);
    }

    public long getLocation(long address) {
        return memory.get(address);
    }

    public long sumMemoryContents() {
        return memory.values().stream().mapToLong(Long::longValue).sum();
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> input = Files.readAllLines(Path.of(DayFourteen.class.getClassLoader().getResource("day_fourteen.txt").toURI()));
        DayFourteen dayFourteen = new DayFourteen(input.toArray(new String[0]));
        System.out.println(dayFourteen.sumMemoryContents());
    }
}
